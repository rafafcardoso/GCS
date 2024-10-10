import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item>Invent;

    public Inventario(ArrayList<Item> invent) {
        this.Invent= new ArrayList<>();
    }
    //metodo que adiciona itens a lista.
    public void addItem(Item item){
        Invent.add(item);
        }

        //metodo que ordena os itens da lista em ordem alfabetica usando ordenação.
        public void OrdenarPorAlfabeto(){
        for(int i=0; i<Invent.size()-1; i++){
            for(int j=i+1; j<Invent.size(); j++){
                if(Invent.get(i).getNome().compareTo(Invent.get(j).getNome()) > 0){
                        Item aux = Invent.get(i);
                        Invent.set(i, Invent.get(j));
                        Invent.set(j, aux);
                    }
                }
            }
            System.out.println("Ordenando Itens...");
        for(Item item : Invent){
            System.out.println(item.getNome());
        }

        }
            public void OrganizaPorPreçodeOutrosPlayers(ArrayList<Jogador> jogadores, Jogador jogadorAtual){
                ArrayList<Item> itensDeOutrosJogadores = new ArrayList<>();
                for(Jogador jogador : jogadores){
                    if(!jogador.equals(jogadorAtual)){
                        itensDeOutrosJogadores.addAll(jogador.getInventario().Invent);
                    }
                }
                for(int i=0; i<itensDeOutrosJogadores.size()-1; i++){
                    for(int j=i+1; j<itensDeOutrosJogadores.size(); j++){
                        double preco1=Double.parseDouble(itensDeOutrosJogadores.get(i).getPreco().replace(",","."));
                        double preco2=Double.parseDouble(itensDeOutrosJogadores.get(j).getPreco().replace(",","."));
                        if(preco1>preco2){
                            Item aux=itensDeOutrosJogadores.get(i);
                            itensDeOutrosJogadores.set(i, itensDeOutrosJogadores.get(j));
                            itensDeOutrosJogadores.set(j, aux);
                        }
                    }
                }
                System.out.println("ordenando itens por preço do jogador....");
                for(Item item : itensDeOutrosJogadores){
                    System.out.println(item.getNome()+"- Preço: "+item.getPreco());
                }
            }
        }




