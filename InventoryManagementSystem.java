import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add product");
            System.out.println("2. Process sale");
            System.out.println("3. Restock product");
            System.out.println("4. View reports");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Quantity: ");
                    int qty = Integer.parseInt(scanner.nextLine());
                    System.out.print("Price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    inventory.addProduct(new Product(name, qty, price));
                    break;
                case 2:
                    System.out.print("Product name: ");
                    name = scanner.nextLine();
                    Product p = inventory.getProduct(name);
                    if (p == null) {
                        System.out.println("Product not found.");
                        break;
                    }
                    System.out.print("Quantity: ");
                    qty = Integer.parseInt(scanner.nextLine());
                    System.out.print("Sale type (1=Cash, 2=Credit): ");
                    int type = Integer.parseInt(scanner.nextLine());
                    Sale sale = (type == 1) ? new CashSale(p, qty) : new CreditSale(p, qty);
                    inventory.processSale(sale);
                    break;
                case 3:
                    System.out.print("Product name: ");
                    name = scanner.nextLine();
                    System.out.print("Quantity: ");
                    qty = Integer.parseInt(scanner.nextLine());
                    System.out.print("Cost per item: ");
                    double cost = Double.parseDouble(scanner.nextLine());
                    inventory.restock(name, qty, cost);
                    break;
                case 4:
                    inventory.printStockLevels();
                    inventory.printSalesSummary();
                    inventory.printPurchaseHistory();
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
}
