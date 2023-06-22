package Entities;

import java.util.List;

public class Menu {
    protected List<Item> items;

    public Menu(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
