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
            System.out.println("3) Sair");
            System.out.println("4) Buscar Itens");
            System.out.println("5) Adicionar Item ao Jogador");
            System.out.println("6) Remover Item do Jogador");
            System.out.println("7) Mostrar Itens do Jogador");
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
                    aux = true;
                    break;
                case 4:
                    cadastroItens.buscaItens();
                    break;
                case 5:
                    adicionarItemAoJogador();
                    break;
                case 6:
                    removerItemDoJogador();
                    break;
                case 7:
                    mostrarItens();
                    break;
                default:
                    System.out.println("Opcão invalida, digite novamente");

            }
        }

    }
    public void mostrarItens(){
        if(jogadorlogado != null){
            jogadorlogado.getItens();
        } else System.out.println("Erro: o jogador deve estar logado!");
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
