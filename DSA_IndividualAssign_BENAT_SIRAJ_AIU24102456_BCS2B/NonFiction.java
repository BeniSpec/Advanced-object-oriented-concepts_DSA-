/**
 * Task 3a - NonFiction (subclass of Book)
 *
 * All NonFiction books are priced at $37.99.
 */
public class NonFiction extends Book {

    // Fixed price for all NonFiction books
    private static final double NONFICTION_PRICE = 37.99;

    // ─── Constructor ──────────────────────────────────────────────────────────

    /**
     * Creates a NonFiction book and immediately sets its price.
     * @param title the book's title
     */
    public NonFiction(String title) {
        super(title);   // call Book constructor to store title
        setPrice();     // set the fixed NonFiction price
    }

    // ─── setPrice() ───────────────────────────────────────────────────────────

    /**
     * Sets the price of this NonFiction book to $37.99.
     * Implements the abstract method from Book.
     */
    @Override
    public void setPrice() {
        price = NONFICTION_PRICE;
    }

    // ─── display ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "[NonFiction]  Title: \"" + getTitle()
               + "\"  |  Price: $" + String.format("%.2f", getPrice());
    }
}
