import java.util.ArrayList;
public class Jogador {
    private String nome;
    private String email;
    private String senha;
    private Inventario inventario;

    public Jogador(String nome, String email, String senha){
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.inventario = new Inventario(new ArrayList<>());
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

    public Inventario getInventario() {return inventario;}
    public void setInventario(Inventario inventario) {this.inventario = inventario;}

    @Override
    public String toString() {
        return "Jogador{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }





}
