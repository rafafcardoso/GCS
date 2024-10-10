import java.util.ArrayList;
import java.util.Scanner;

public class Jogador {
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Item> itens; // Lista de itens do jogador
    private ArrayList<PropostaTroca> propostas; // Lista de propostas de trocas
    private Scanner in = new Scanner(System.in);

    public Jogador(String nome, String email, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.itens = new ArrayList<>(); // Inicializa a lista de itens
        this.propostas = new ArrayList<>(); // Inicializa a lista de propostas
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Item> getItens() {
        return itens; // Retorna a lista de itens do jogador
    }

    public Item buscaItemNome(String nomeItem){
        for(Item item: itens){
            if(item.getNome().equals(nomeItem)){
                return item;
            }
        } return null;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }


    public void removerItem(Item item) {
        itens.remove(item);
    }

    public void mandaProposta(PropostaTroca proposta){
        propostas.add(proposta);
    }

    public void mostrarPropostas(){
        int cont=1;
        for(PropostaTroca proposta: propostas){
            System.out.println("Proposta " + cont);
            proposta.exibirProposta();
            cont++;
            System.out.println("Deseja aceitar a proposta?" + "\n1 - Sim" + "\n2 - Não");
            int resposta = in.nextInt();
            if(resposta == 1){
                proposta.confirmarTroca();
            } else if(resposta == 2){
                propostas.remove(proposta);
            } else System.out.println("Valor inválido.");
        }
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", itens=" + itens +
                '}';
    }
}