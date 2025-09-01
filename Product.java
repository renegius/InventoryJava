public class Product extends Item {
    private int quantity;
    private final double price;

    public Product(String name, int quantity, double price) {
        super(name);
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void addQuantity(int amount) {
        quantity += amount;
    }

    public boolean reduceQuantity(int amount) {
        if (amount > quantity) {
            return false;
        }
        quantity -= amount;
        return true;
    }
}
