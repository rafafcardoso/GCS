import java.util.ArrayList;
import java.util.Scanner;

public class Jogador {
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Item> itens;
    private ArrayList<PropostaTroca> propostas;
    private Scanner in = new Scanner(System.in);
    private ArrayList<Item> historico;
    private ArrayList<Integer> notas;
    private double avaliacao;
    private Estatisticas estatisticas = new Estatisticas();

    public Jogador(String nome, String email, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.itens = new ArrayList<>(); 
        this.propostas = new ArrayList<>(); 
        this.notas = new ArrayList<>();
        this.historico = new ArrayList<>();
        this.avaliacao = 0;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public ArrayList<Item> getItens() {
        return itens;
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
        for(PropostaTroca proposta: propostas) {
            System.out.println("Proposta " + cont);
            proposta.exibirProposta();
            cont++;
            System.out.println("Deseja aceitar a proposta?" + "\n1 - Sim" + "\n2 - Não");
            int resposta = in.nextInt();
            if (resposta == 1) {
                proposta.confirmarTroca();
                estatisticas.incrementarPropostasAceitas();
            } else if (resposta == 2) {
                propostas.remove(proposta);
                estatisticas.incrementarPropostasNegadas();
            } else {
                System.out.println("Valor inválido.");
            }
        }
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

    public void addHistoricoTroca(Item item){
        historico.add(item);
    }

    public void mostrarHistoricoTroca(){
        for(int i=0; i<historico.size(); i++){
            System.out.println((historico.get(i)).toString());
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