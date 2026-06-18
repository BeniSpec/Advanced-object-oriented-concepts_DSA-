public class Fiction extends Book {

    private static final double FICTION_PRICE = 24.99;

    // Constructor sets title and price
    public Fiction(String title) {
        super(title);  
        setPrice();    
    }

    // Sets the fixed price for fiction books
    @Override
    public void setPrice() {
        price = FICTION_PRICE;
    }

    // Custom string format for display
    @Override
    public String toString() {
        return "[Fiction]     Title: \"" + getTitle()
               + "\"  |  Price: $" + String.format("%.2f", getPrice());
    }
}