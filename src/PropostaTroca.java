public class PropostaTroca {
    private Jogador jogador1;
    private Jogador jogador2;
    private Item itemJogador1;
    private Item itemJogador2;
    private long dataHoraTroca; // Registro da data e hora da troca em milissegundos

    // Construtor
    public PropostaTroca(Jogador jogador1, Item itemJogador1, Jogador jogador2, Item itemJogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.itemJogador1 = itemJogador1;
        this.itemJogador2 = itemJogador2;
        this.dataHoraTroca = System.currentTimeMillis(); // Data e hora no momento da proposta
    }

    // Método para exibir os detalhes da troca
    public void exibirProposta() {
        System.out.println("Proposta de Troca:");
        System.out.println("Jogador 1: " + jogador1.getNome() + " deseja trocar o item: " + itemJogador1.getNome());
        System.out.println("Jogador 2: " + jogador2.getNome() + " deseja trocar o item: " + itemJogador2.getNome());
        System.out.println("Data e Hora da Proposta (milissegundos desde 1970): " + dataHoraTroca);
    }

    public void confirmarTroca() {
        System.out.println("Troca confirmada entre " + jogador1.getNome() + " e " + jogador2.getNome());
        System.out.println(jogador1.getNome() + " recebeu o item: " + itemJogador2.getNome());
        System.out.println(jogador2.getNome() + " recebeu o item: " + itemJogador1.getNome());
        // Aqui você pode implementar a lógica para remover e adicionar itens dos inventários dos jogadores, se existir um inventário
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public Item getItemJogador1() {
        return itemJogador1;
    }

    public Item getItemJogador2() {
        return itemJogador2;
    }

    public long getDataHoraTroca() {
        return dataHoraTroca;
    }
}