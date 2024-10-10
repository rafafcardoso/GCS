import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Item> itens; // Lista de itens do jogador
    private double avaliacao;
    private ArrayList<Integer> notas;

    public Jogador(String nome, String email, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.itens = new ArrayList<>(); // Inicializa a lista de itens
        this.notas = new ArrayList<>();
        this.avaliacao = 0;
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

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void calculaAvaliacao(int nota){
        notas.add(nota);
        int soma=0;
        for(int i=0; i<notas.size(); i++){
            soma += notas.get(i);
        }
        avaliacao = soma/notas.size();
        setAvaliacao(avaliacao);
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        System.out.println(item.getNome() + " adicionado ao jogador " + nome);
    }


    public void removerItem(Item item) {
        if (itens.remove(item)) {
            System.out.println(item.getNome() + " removido do jogador " + nome);
        } else {
            System.out.println("Item não encontrado na lista do jogador " + nome);
        }
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", itens=" + itens +
                ", avaliação=" + avaliacao +
                '}';
    }
}