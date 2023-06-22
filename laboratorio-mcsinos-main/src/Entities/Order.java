package Entities;

import java.util.Arrays;

public class Order {
    protected Item[] ordered;

    public Order(Item[] ordered) {
        this.ordered = ordered;
    }

    public Item[] getOrdered() {
        return ordered;
    }

    @Override
    public String toString() {
        return Arrays.toString(ordered);
    }
}
