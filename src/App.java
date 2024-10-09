import java.util.Scanner;


public class App {
    private Sistema system = new Sistema();
    private CadastroItens cadastroItens = new CadastroItens();
    private Scanner in = new Scanner(System.in);


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
                    break;
                case 4:
                    cadastroItens.buscaItens();
                    break;
                default:
                    System.out.println("Opcão invalida, digite novamente");

            }
        }
    }
}
