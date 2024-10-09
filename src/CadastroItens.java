import java.util.ArrayList;
import java.util.Scanner;

public class CadastroItens {
    public ArrayList<Item> itens = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    public void buscaItens() {
        boolean on = true;
        System.out.println("Iniciando busca items...");
        while (on) {
            ArrayList<Item> resultados = new ArrayList<>();

            System.out.println("Escolha uma opção: \n 1 - Busca por nome \n 2 - Busca por descrição \n 3 - Busca por categoria \n 0 - Sair");
            int op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Digite o nome para buscar: ");
                    String nome = scanner.nextLine();
                    resultados = buscarPorNome(nome, itens);
                    break;
                case 2:
                    System.out.println("Digite a descrição para buscar: ");
                    String desc = scanner.nextLine();
                    resultados = buscarPorDesc(desc, itens);
                    break;
                case 3:
                    System.out.println("Digite a categoria para buscar: ");
                    String categoria = scanner.nextLine();
                    resultados = buscarPorCategoria(categoria, itens);
                    break;
                case 0:
                    on = false;
                    break;
                default:
                    System.out.print("Opção Inválida");
            }
            if (resultados.isEmpty()) {
                System.out.println("Nenhum item encontrado.");
            } else {
                System.out.println("Itens encontrados:");
                for (Item item : resultados) {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public ArrayList<Item> buscarPorNome(String nome, ArrayList<Item> itens) {
        ArrayList<Item> resultados = new ArrayList<>();

        for (Item item : itens) {
            if (item.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultados.add(item);
            }
        }

        return resultados;
    }

    // Método para buscar itens por tipo
    public ArrayList<Item> buscarPorCategoria(String tipo, ArrayList<Item> itens) {
        ArrayList<Item> resultados = new ArrayList<>();

        for (Item item : itens) {
            if (item.getCategoria().toLowerCase().contains(tipo.toLowerCase())) {
                resultados.add(item);
            }
        }

        return resultados;
    }

    public ArrayList<Item> buscarPorDesc(String categoria, ArrayList<Item> itens) {
        ArrayList<Item> resultados = new ArrayList<>();

        for (Item item : itens) {
            if (item.getDescription().toLowerCase().contains(categoria.toLowerCase())) {
                resultados.add(item);
            }
        }

        return resultados;
    }

    //Itens Fixos
    public void itensFixos() {
        //nome,categoria,descricao
        Item espadadodivino = new Item("Espada do Divino", "Espada", "Dano Crítico");
        Item manopladoburaconegro = new Item("Manopla do Buraco Negro", "Manopla", "Tanque");
        Item decapitador = new Item("Decapitador", "Espada", "Dano de Ultimate");
        Item forcadovendaval = new Item("Forca Do Vendaval", "Arco", "Dano por Segundo");
        Item comecarne = new Item("Come Carne", "Adaga", "Dano e Cura");
        Item sedentaporsange = new Item("Sedenta por Sangue", "Espada", "Dano e Roubo de Vida");
        Item virtuderadiante = new Item("Virtude Radiante", "Armadura", "Tanque e Cura");
        Item laminadamiragem = new Item("Lamina da Miragem", "Adaga", "Dano e Velocidade de Ataque");
        Item mascaragemea = new Item("Máscara Gêmea", "Armadura", "Dano, Vida, Velocidade de Ataque e Vida");
        Item reverberacao = new Item("Reverberação", "Armadura", "Vida e Resistência");
        Item eclipse = new Item("Eclipse", "Adaga", "Dano e Escudo");
        Item medalhaodesolari = new Item("Medalhão de Solari", "Escudo", "Escudo e Resistência");
        Item capuzdamortederabadon = new Item("Capuz da Morte de Rabadon", "Armadura", "Dano");
        Item glacieterno = new Item("Glacieterno", "Artefato", "Dano e Controle de Grupo");
        Item arcoescudoimortal = new Item("Arco Escudo Imortal", "Arco", "Dano, Escudo e Roubo de Vida");
        Item Insulina = new Item("Insulina", "Remédio", "Mantém o Fellas vivo");
        itens.add(espadadodivino);
        itens.add(manopladoburaconegro);
        itens.add(decapitador);
        itens.add(forcadovendaval);
        itens.add(comecarne);
        itens.add(sedentaporsange);
        itens.add(virtuderadiante);
        itens.add(laminadamiragem);
        itens.add(mascaragemea);
        itens.add(reverberacao);
        itens.add(eclipse);
        itens.add(medalhaodesolari);
        itens.add(capuzdamortederabadon);
        itens.add(glacieterno);
        itens.add(arcoescudoimortal);
        itens.add(Insulina);
    }
}

