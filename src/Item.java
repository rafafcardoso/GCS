public class Item {
    private String nome;
    private String categoria;
    private String description;

    private int preco;
    public Item(String nome, String categoria, String description, int preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.description = description;
        this.preco = preco;

    }
    public String getNome() {
        return nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getDescription() {
        return description;
    }

    public int getPreco() {return preco;}


    public String toString() {
        return "Nome: " + getNome() + " - Categoria: " + getCategoria() + " - Descrição: " + getDescription();
    }
}
