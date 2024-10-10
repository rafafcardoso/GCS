import java.util.Scanner;


public class App {
    private Sistema system = new Sistema();
    private CadastroItens cadastroItens = new CadastroItens();
    private Scanner in = new Scanner(System.in);
    public static Jogador jogadorlogado;


    public void executar(){

        int op;
        boolean aux = false;
        cadastroItens.itensFixos();//cria os itens fixos
        while (!aux){
            System.out.println("MENU");
            System.out.println("1) Cadastrar novo jogador");
            System.out.println("2) Login");
            System.out.println("3) Logout");
            System.out.println("4) Sair");
            System.out.println("5) Buscar Itens");
            System.out.println("6) Adicionar Item ao Jogador");
            System.out.println("7) Remover Item do Jogador");
            System.out.println("8) Mostrar Itens do Jogador");
            System.out.println("9) Propor troca para alguém");
            op = in.nextInt();
            in.nextLine();


            switch (op){
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
                default:
                    System.out.println("Opcão invalida, digite novamente");

            }
        }

    }

    public void troca(){
        System.out.println("Digite seu nome de usuário:");
        String nome = in.nextLine();
        System.out.println("Digite o nome do jogador com quem você quer trocar:");
        String jogador = in.nextLine();
        system.proporTroca(nome, jogador);
    }

    public void mostrarItens(){
        jogadorlogado.getItens();
    }
    private void adicionarItemAoJogador() {
        // Solicitar nome do jogador
        System.out.print("Digite o nome do jogador: ");
        String nomeJogador = in.nextLine();
        Jogador jogador = system.buscarJogadorPorNome(nomeJogador);

        if (jogador == null) {
            System.out.println("Jogador não encontrado.");
            return;
        }

        // Solicitar nome do item
        System.out.print("Digite o nome do item a ser adicionado: ");
        String nomeItem = in.nextLine();
        Item item = cadastroItens.buscarPorNomeUnico(nomeItem);

        if (item == null) {
            System.out.println("Item não encontrado.");
            return;
        }

        // Adicionar o item ao jogador
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

        // Solicitar nome do item a ser removido
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

        // Remover o item do jogador
        jogador.removerItem(item);
    }

}
