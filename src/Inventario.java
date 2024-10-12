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


}







