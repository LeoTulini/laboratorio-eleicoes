package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Queue {
    protected List<Order> orders  = new ArrayList<>();

    public Queue() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void add(Order order){
        this.orders.add(order);
    }

    public void deliverOldest(){
        this.orders.remove(this.orders.size() - 1);
    }

    // ToString devolver a fila formatadinha com os pedidos
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:\n");
        for (int i = 0; i < orders.size(); i++) {
            sb.append("Order ").append(i+1).append(": ").append(orders.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
