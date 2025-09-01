import java.util.*;

public class Inventory {
    private Map<String, Product> products = new HashMap<>();
    private List<Sale> sales = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public void processSale(Sale sale) {
        Product p = sale.getProduct();
        if (p.reduceQuantity(sale.getQuantity())) {
            sales.add(sale);
            System.out.println("Sale processed: " + sale.getType());
        } else {
            System.out.println("Insufficient stock.");
        }
    }

    public void restock(String name, int quantity, double cost) {
        Product p = products.get(name);
        if (p != null) {
            p.addQuantity(quantity);
            orders.add(new Order(name, quantity, cost));
            System.out.println("Restocked " + name);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void printStockLevels() {
        System.out.println("Current Stock:");
        for (Product p : products.values()) {
            System.out.println(p.getName() + ": " + p.getQuantity() + " units at $" + p.getPrice());
        }
    }

    public void printSalesSummary() {
        System.out.println("Sales Summary:");
        for (Sale s : sales) {
            System.out.println(s.getType() + " sale - " + s.getProduct().getName() + ": " + s.getQuantity() + " units totaling $" + s.getTotal());
        }
    }

    public void printPurchaseHistory() {
        System.out.println("Purchase History:");
        for (Order o : orders) {
            System.out.println(o.getName() + ": " + o.getQuantity() + " units costing $" + o.getCost());
        }
    }
}
