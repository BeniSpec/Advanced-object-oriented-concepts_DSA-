public class NonFiction extends Book {

    private static final double NONFICTION_PRICE = 37.99;

    // Constructor sets title and price
    public NonFiction(String title) {
        super(title);  
        setPrice();    
    }

    // Sets the fixed price for nonfiction books
    @Override
    public void setPrice() {
        price = NONFICTION_PRICE;
    }

    // Custom string format for display
    @Override
    public String toString() {
        return "[NonFiction]  Title: \"" + getTitle()
               + "\"  |  Price: $" + String.format("%.2f", getPrice());
    }
}