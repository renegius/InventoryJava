import java.util.Scanner;

public class InventoryManagementSystem {
    private static final Inventory inventory = new Inventory();
    private static final InventoryReport report = new InventoryReport();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    handleAddProduct();
                    break;
                case 2:
                    handleProcessSale();
                    break;
                case 3:
                    handleRestockProduct();
                    break;
                case 4:
                    handleViewReports();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
        System.out.println("Exiting IMS.");
    }

    private static void printMenu() {
        System.out.println("\nInventory Management System");
        System.out.println("1. Add product");
        System.out.println("2. Process sale");
        System.out.println("3. Restock product");
        System.out.println("4. View reports");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void handleAddProduct() {
        System.out.print("Product name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        inventory.addProduct(new Product(name, qty, price));
    }

    private static void handleProcessSale() {
        System.out.print("Product name: ");
        String name = scanner.nextLine();
        Product p = inventory.getProduct(name);
        if (p == null) {
            System.out.println("Product not found.");
            return;
        }
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Sale type (1=Cash, 2=Credit): ");
        int type = Integer.parseInt(scanner.nextLine());
        Sale sale = (type == 1) ? new CashSale(p, qty) : new CreditSale(p, qty);
        try {
            inventory.processSale(sale);
            System.out.println("Sale processed: " + sale.getType());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleRestockProduct() {
        System.out.print("Product name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Cost per item: ");
        double cost = Double.parseDouble(scanner.nextLine());
        try {
            inventory.restock(name, qty, cost);
            System.out.println("Restocked " + name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleViewReports() {
        System.out.print(report.stockLevels(inventory));
        System.out.print(report.salesSummary(inventory));
        System.out.print(report.purchaseHistory(inventory));
    }
}
