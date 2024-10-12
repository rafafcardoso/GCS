import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private Sistema system = new Sistema();
    private CadastroItens cadastroItens = new CadastroItens();
    private Scanner in = new Scanner(System.in);
    public static Jogador jogadorlogado;
    private Estatisticas estatisticas = new Estatisticas();


    public void executar() {

        int op;
        boolean aux = false;
        cadastroItens.itensFixos();
        while (!aux) {
            System.out.println("-=-=-=-=- MENU -=-=-=-=-");
            System.out.println("1. Cadastrar novo jogador");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Sair");
            System.out.println("5. Buscar Itens");
            System.out.println("6. Adicionar Item ao Jogador");
            System.out.println("7. Remover Item do Jogador");
            System.out.println("8. Mostrar Itens do Jogador");
            System.out.println("9. Propor troca para alguém");
            System.out.println("10. Mostrar histórico de trocas");
            System.out.println("11. Mostrar estatísticas gerais");

            op = in.nextInt();
            in.nextLine();


            switch (op) {
                case 1:
                    system.cadastrarJogador();
                    break;
                case 2:
                    system.login();
                    break;
                case 3:
                    system.logout();
                    break;
                case 4:
                    aux = true;
                    break;
                case 5:
                    cadastroItens.buscaItens();
                    break;
                case 6:
                    adicionarItemAoJogador();
                    break;
                case 7:
                    removerItemDoJogador();
                    break;
                case 8:
                    mostrarItens();
                    break;
                case 9:
                    troca();
                    break;
                case 10:
                    historico();
                    break;
                case 11:
                    mostrarEstatisticas();
                    break;
                case 12:
                    listarItensJogadorLogadoPorAlfabeto();
                    break;
                case 13:
                    metodoOrganizador();
                    break;
                default:
                    System.out.println("Opcão invalida, digite novamente");

            }
        }

    }


    public void troca() {
        System.out.println("Digite seu nome de usuário:");
        String nome = in.nextLine();
        System.out.println("Digite o nome do jogador com quem você quer trocar:");
        String jogador = in.nextLine();
        system.proporTroca(nome, jogador);
    }

    public void historico() {
        if (jogadorlogado == null) {
            System.out.println("Você precisa estar logado.");
            return;
        }
        jogadorlogado.mostrarHistoricoTroca();
    }

    public void mostrarItens() {
        if (jogadorlogado != null) {
            ArrayList<Item> itens = jogadorlogado.getItens();
            if (itens.isEmpty()) {
                System.out.println("O jogador não possui itens.");
            } else {
                System.out.println("Itens do jogador:");
                for (Item item : itens) {
                    System.out.println(item.toString());
                }
            }
        } else {
            System.out.println("Você precisa estar logado.");
        }

    }

    private void adicionarItemAoJogador() {
        System.out.print("Digite o nome do jogador: ");
        String nomeJogador = in.nextLine();
        Jogador jogador = system.buscarJogadorPorNome(nomeJogador);

        if (jogador == null) {
            System.out.println("Jogador não encontrado.");
            return;
        }

        System.out.print("Digite o nome do item a ser adicionado: ");
        String nomeItem = in.nextLine();
        Item item = cadastroItens.buscarPorNomeUnico(nomeItem);

        if (item == null) {
            System.out.println("Item não encontrado.");
            return;
        }
        jogador.adicionarItem(item);
    }

    private void removerItemDoJogador() {
        System.out.print("Digite o nome do jogador: ");
        String nomeJogador = in.nextLine();
        Jogador jogador = system.buscarJogadorPorNome(nomeJogador);

        if (jogador == null) {
            System.out.println("Jogador não encontrado.");
            return;
        }

        System.out.print("Digite o nome do item a ser removido: ");
        String nomeItem = in.nextLine();
        Item item = jogador.getItens().stream()
                .filter(i -> i.getNome().equalsIgnoreCase(nomeItem))
                .findFirst()
                .orElse(null);

        if (item == null) {
            System.out.println("Item não encontrado no inventário do jogador.");
            return;
        }

        jogador.removerItem(item);
    }

    private void mostrarEstatisticas() {
        System.out.println("Total de usuários: " + system.getTotalUsuarios());
        System.out.println("Total de itens: " + cadastroItens.getTotalItens());
        System.out.println("Quantidade de propostas aceitas: " + estatisticas.getPropostasAceitas());
        System.out.println("Quantidade de propostas negadas: " + estatisticas.getPropostasNegadas());
        System.out.println("Quantidade de propostas aguardadas: " + estatisticas.getPropostasAguardando());
    }


    public void listarItensJogadorLogadoPorAlfabeto() {
        if (jogadorlogado == null) {
            System.out.println("Você precisa estar logado.");
            return;
        }

        ArrayList<Item> itens = jogadorlogado.getItens();
        if (itens.isEmpty()) {
            System.out.println("O jogador não possui itens.");
        } else {
            for (int i = 0; i < itens.size() - 1; i++) {
                for (int j = i + 1; j < itens.size(); j++) {
                    if (itens.get(i).getNome().compareToIgnoreCase(itens.get(j).getNome()) > 0) {
                        Item temp = itens.get(i);
                        itens.set(i, itens.get(j));
                        itens.set(j, temp);
                    }
                }
            }

            System.out.println("Itens do jogador em ordem alfabética:");
            for (Item item : itens) {
                System.out.println(item.getNome());
            }
        }

    }


    public void metodoOrganizador() {
        system.organizaPorPreçodeOutrosPlayers(jogadorlogado);
    }
}









