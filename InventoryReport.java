public class InventoryReport {
    public String stockLevels(Inventory inventory) {
        StringBuilder sb = new StringBuilder("Current Stock:\n");
        for (Product p : inventory.getProducts()) {
            sb.append(p.getName())
              .append(": ")
              .append(p.getQuantity())
              .append(" units at $")
              .append(p.getPrice())
              .append('\n');
        }
        return sb.toString();
    }

    public String salesSummary(Inventory inventory) {
        StringBuilder sb = new StringBuilder("Sales Summary:\n");
        for (Sale s : inventory.getSales()) {
            sb.append(s.getType())
              .append(" sale - ")
              .append(s.getProduct().getName())
              .append(": ")
              .append(s.getQuantity())
              .append(" units totaling $")
              .append(s.getTotal())
              .append('\n');
        }
        return sb.toString();
    }

    public String purchaseHistory(Inventory inventory) {
        StringBuilder sb = new StringBuilder("Purchase History:\n");
        for (Order o : inventory.getOrders()) {
            sb.append(o.getName())
              .append(": ")
              .append(o.getQuantity())
              .append(" units costing $")
              .append(o.getCost())
              .append('\n');
        }
        return sb.toString();
    }
}
