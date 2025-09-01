public class CashSale extends Sale {
    public CashSale(Product product, int quantity) {
        super(product, quantity);
    }

    @Override
    public String getType() {
        return "Cash";
    }
}
