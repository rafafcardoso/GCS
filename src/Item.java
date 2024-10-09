import java.util.Random;
public class Item {
    private String nome;
    private String categoria;
    private String description;
    private String preco;
    private int Id;
    private Random gerador;
    public Item(String nome, String categoria, String description) {
        this.nome = nome;
        this.categoria = categoria;
        this.description = description;
        this.preco=preco;
        this.Id=Id;

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
    public String getPreco(){return preco;}
    public int getId(){return Id;}
    public void setPreco(String preco){this.preco=preco;}
    public void setId(int Id){this.Id=Id;}
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setDescription(String description) {
        this.description = description;
    }
//Adicionados os atributos preço e Id.
}
