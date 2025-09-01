import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products = new HashMap<>();
    private final List<Sale> sales = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

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
        } else {
            throw new IllegalArgumentException("Insufficient stock for " + p.getName());
        }
    }

    public void restock(String name, int quantity, double cost) {
        Product p = products.get(name);
        if (p != null) {
            p.addQuantity(quantity);
            orders.add(new Order(name, quantity, cost));
        } else {
            throw new IllegalArgumentException("Product not found: " + name);
        }
    }

    public Collection<Product> getProducts() {
        return Collections.unmodifiableCollection(products.values());
    }

    public List<Sale> getSales() {
        return Collections.unmodifiableList(sales);
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}
