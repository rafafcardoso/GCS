import java.util.Scanner;


public class App {
    private Sistema system = new Sistema();
    private Scanner in = new Scanner(System.in);


    public void executar(){

        int op;
        boolean aux = false;

        while (!aux){
            System.out.println("MENU");
            System.out.println("1) Cadastrar novo jogador");
            System.out.println("2) Login");
            System.out.println("3) Sair");
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
                default:
                    System.out.println("Opcao invalida, digite novamente");

            }
        }
    }
}
