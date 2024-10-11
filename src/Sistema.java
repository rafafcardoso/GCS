import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {
    private ArrayList<Jogador> jogadores;
    private Scanner in;

    public Sistema(){
        jogadores = new ArrayList<>();
        in = new Scanner(System.in);
    }


    public void cadastrarJogador(){
        System.out.println("Iniciando cadastro de jogadores...");
        System.out.print("Nome: ");
        String nome = in.nextLine();

        System.out.print("Email: ");
        String email = in.nextLine();

        System.out.print("Senha: ");
        String senha = in.nextLine();

        Jogador j = new Jogador(nome, email, senha);
        jogadores.add(j);
        System.out.println("Jogador cadastrado com sucesso!");

    }

    public void login(){
        System.out.println("Iniciando login...");
        System.out.print("Email: ");
        String email = in.nextLine();

        System.out.print("Senha: ");
        String senha = in.nextLine();


        boolean aux = false;
        for (Jogador j : jogadores){
            if (j.getEmail().equals(email) && j.getSenha().equals(senha)){
                System.out.println("Login com sucesso! Seja bem-vindo " + j.getNome());
                aux = true;
                App.jogadorlogado = j;
                j.mostrarPropostas();

                break;
            }
        }
        if (!aux) {
            System.out.println("Email ou senha errados.");
        }
    }
  
    public void logout(){
        App.jogadorlogado = null;
        System.out.println("Saindo da conta...");
    }

    public Jogador buscarJogadorPorNome(String nome) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                return jogador; // Retorna o jogador se o nome coincidir
            }
        }
        return null; // Retorna null se o jogador não for encontrado
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
                                System.out.println("Proposta feita!");
                                return;
                            } else { System.out.println("Você não tem este item."); return;}
                        } else { System.out.println("O jogador não tem este item."); return;}
                    }
                }
            }
        } System.out.println("Erro: um dos nomes está incorreto.");
    }
}
