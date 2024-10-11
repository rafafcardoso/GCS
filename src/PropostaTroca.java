import java.util.Scanner;

public class PropostaTroca {
    private Jogador jogador1;
    private Jogador jogador2;
    private Item itemJogador1;
    private Item itemJogador2;
    private long dataHoraTroca;

    public PropostaTroca(Jogador jogador1, Item itemJogador1, Jogador jogador2, Item itemJogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.itemJogador1 = itemJogador1;
        this.itemJogador2 = itemJogador2;
        this.dataHoraTroca = System.currentTimeMillis();
    }

    public void exibirProposta() {
        System.out.println("Jogador: " + jogador1.getNome() + " deseja trocar o item: " + itemJogador1.getNome() +
                " por: " + itemJogador2.getNome());
        System.out.println("Data e Hora da Proposta: " + dataHoraTroca);
    }

    public void confirmarTroca() {
        System.out.println("Troca confirmada entre " + jogador1.getNome() + " e " + jogador2.getNome());
        System.out.println(jogador1.getNome() + " recebeu o item: " + itemJogador2.getNome());
        System.out.println(jogador2.getNome() + " recebeu o item: " + itemJogador1.getNome());

        jogador1.removerItem(itemJogador1);
        jogador1.adicionarItem(itemJogador2);

        jogador2.removerItem(itemJogador2);
        jogador2.adicionarItem(itemJogador1);

        jogador1.addHistoricoTroca(itemJogador1);
        jogador2.addHistoricoTroca(itemJogador2);

        System.out.println("Qual sua nota (1 a 5) para o " + jogador2.getNome() + "?");
        Scanner in = new Scanner(System.in);
        int nota = in.nextInt();
            if(nota <1 || nota > 5){
                do {
                    System.out.println("Número inválido! Digite novamente:");
                    nota = in.nextInt();
                } while(nota < 1 || nota > 5);
            }
        jogador2.calculaAvaliacao(nota);

    }
}