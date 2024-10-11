import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {
    private ArrayList<Jogador> jogadores;
    private ArrayList<PropostaTroca> propostas;
    private Scanner in;
    private Estatisticas estatisticas = new Estatisticas();

    public Sistema(){
        jogadores = new ArrayList<>();
        in = new Scanner(System.in);
        propostas = new ArrayList<>();
    }


    public void cadastrarJogador(){
        System.out.println("Iniciando cadastro...");
        System.out.print("Digite seu nome: ");
        String nome = in.nextLine();
        if (nome.isBlank()) {
            System.out.println("Você precisa digitar seu nome.");
            return;
        }


        System.out.print("Digite seu email: ");
        String email = in.nextLine();
        if (email.isBlank()) {
            System.out.println("Você precisa digitar seu email.");
            return;
        }



        System.out.print("Digite seu PIN (6 dígitos): ");
        String senha = in.nextLine();


        boolean jogadorCadastrado = false;



        for (Jogador j : jogadores) {
            if (email.equals(j.getEmail())) {
                System.out.println("Já existe um usuário com esse email.");
                jogadorCadastrado = true;
                break;
            }
        }

        if (!jogadorCadastrado) {
            if (senha.length() == 6) {
                Jogador jogador = new Jogador(nome, email, senha);
                jogadores.add(jogador);
                System.out.println("Jogador cadastrado com sucesso.");
                estatisticas.incrementarTotalUsuarios();
            } else {
                System.out.println("Seu PIN deve ter 6 dígitos.");
            }
        }
    }

    public void login(){
        System.out.println("Iniciando login...");
        System.out.print("Informe seu email: ");
        String email = in.nextLine();
        System.out.print("Informe seu PIN: ");
        String senha = in.nextLine();


        for (Jogador j : jogadores){
            if (j.getEmail().equals(email) && j.getSenha().equals(senha)){
                System.out.println("Login com sucesso! Seja bem-vindo " + j.getNome());
                App.jogadorlogado = j;
                j.mostrarPropostas();
                return;
            }
        }
        System.out.println("Email ou senha errados.");
    }

    public void logout(){
        if (App.jogadorlogado == null){
            System.out.println("Você não está logado.");
        } else {
            System.out.println("Saindo da conta...");
            App.jogadorlogado = null;
        }
    }

    public Jogador buscarJogadorPorNome(String nome) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                return jogador;
            }
        }
        return null;
    }

    public void proporTroca(String nomeJogador1, String nomeJogador2) {
        for (Jogador j : jogadores) {
            if(j.getNome().equals(nomeJogador1)) {
                for (Jogador jogador : jogadores) {
                    if (jogador.getNome().equals(nomeJogador2)) {
                        System.out.println("Qual item você quer deste jogador?");
                        String nome = in.nextLine();
                        if (jogador.buscaItemNome(nome)!=null) {
                            Item item2 = jogador.buscaItemNome(nome);
                            System.out.println("Qual item você está disposto a trocar?");
                            String nome2 = in.nextLine();
                            if (j.buscaItemNome(nome2)!=null) {
                                Item item1 = j.buscaItemNome(nome2);
                                PropostaTroca troca = new PropostaTroca(j, item1, jogador, item2);
                                jogador.mandaProposta(troca);
                                estatisticas.incrementarPropostasAguardando();
                                System.out.println("Proposta feita!");
                                return;
                            } else { System.out.println("Você não tem este item."); return;}
                        } else { System.out.println("O jogador não tem este item."); return;}
                    }
                }
            }
        } System.out.println("Erro: um dos nomes está incorreto.");
    }

    public int getTotalUsuarios() {
        return jogadores.size();
    }








}
