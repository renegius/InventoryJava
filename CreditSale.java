public class CreditSale extends Sale {
    public CreditSale(Product product, int quantity) {
        super(product, quantity);
    }

    @Override
    public String getType() {
        return "Credit";
    }
}
