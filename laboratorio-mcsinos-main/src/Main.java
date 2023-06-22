import Entities.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu menu = createMenu();
        Queue queue = createQueue(menu);

//        System.out.printf("Bem vindo ao McSinos! Escolha os itens do cardápio e faça o seu pedido");
//        System.in
    }

    private static Menu createMenu(){
        Item item1 = new Item(Type.BURGUER, 2, "McSinos");
        Item item2 = new Item(Type.BURGUER, 10, "FeeCheddar");
        Item item3 = new Item(Type.BURGUER, 1, "BUFRGS");
        Item item4 = new Item(Type.BEVERAGE, 5, "Coca Gelada");
        Item item5 = new Item(Type.BEVERAGE, 4, "Cerveja velha");
        Item item6 = new Item(Type.BEVERAGE, 1, "Sobra de Ketchup");

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        return new Menu(items);
    }

    private static Queue createQueue(Menu menu){
        Queue queue = new Queue();

        List<Item> items1 = new ArrayList<>();
        items1.add(menu.getItems().get(0));
        items1.add(menu.getItems().get(5));

        List<Item> items2 = new ArrayList<>();
        items1.add(menu.getItems().get(1));
        items1.add(menu.getItems().get(4));

        List<Item> items3 = new ArrayList<>();
        items1.add(menu.getItems().get(2));
        items1.add(menu.getItems().get(3));

        Order order1 = new Order(items1.toArray(new Item[2]));
        Order order2 = new Order(items2.toArray(new Item[2]));
        Order order3 = new Order(items3.toArray(new Item[2]));

        queue.add(order1);
        queue.add(order2);
        queue.add(order3);

        return queue;
    }
}