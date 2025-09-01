public class Order extends Item {
    private int quantity;
    private double cost;

    public Order(String name, int quantity, double cost) {
        super(name);
        this.quantity = quantity;
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }
}
