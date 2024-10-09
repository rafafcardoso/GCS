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
                break;
            }
        }
        if (!aux) {
            System.out.println("Email ou senha errados.");
        }




    }
    public Jogador buscarJogadorPorNome(String nome) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                return jogador; // Retorna o jogador se o nome coincidir
            }
        }
        return null; // Retorna null se o jogador não for encontrado
    }


}
