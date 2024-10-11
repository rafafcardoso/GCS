public class Item {
    private String nome;
    private String categoria;
    private String description;
    public Item(String nome, String categoria, String description) {
        this.nome = nome;
        this.categoria = categoria;
        this.description = description;
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

    public String toString() {
        return "Nome: " + getNome() + " - Categoria: " + getCategoria() + " - Descrição: " + getDescription();
    }
}
