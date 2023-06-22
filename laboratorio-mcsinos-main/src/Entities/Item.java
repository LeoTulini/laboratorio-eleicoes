package Entities;

public class Item {
    protected Type type;
    protected int quantity;
    protected String name;

    public Item(Type type, int quantity, String name) {
        validate(quantity);
        this.type = type;
        this.quantity = quantity;
        this.name = name;
    }

    @Override
    public String toString(){
        return
                "Tipo: {" + this.type + "}\r" +
                "Nome: {" + this.name + "}\r" +
                "Quantidade:{" + this.quantity + "}";
    }

    private void validate(int quantity){
        if (quantity <= 0){
            throw new IllegalArgumentException("A quantidade de itens não pode ser negativa.");
        }
    }
}
