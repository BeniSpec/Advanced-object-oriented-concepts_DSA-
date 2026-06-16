/**
 * Task 3a - Fiction (subclass of Book)
 *
 * All Fiction books are priced at $24.99.
 */
public class Fiction extends Book {

    // Fixed price for all Fiction books
    private static final double FICTION_PRICE = 24.99;

    // ─── Constructor ──────────────────────────────────────────────────────────

    /**
     * Creates a Fiction book and immediately sets its price.
     * @param title the book's title
     */
    public Fiction(String title) {
        super(title);   // call Book constructor to store title
        setPrice();     // set the fixed Fiction price
    }

    // ─── setPrice() ───────────────────────────────────────────────────────────

    /**
     * Sets the price of this Fiction book to $24.99.
     * Implements the abstract method from Book.
     */
    @Override
    public void setPrice() {
        price = FICTION_PRICE;
    }

    // ─── display ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "[Fiction]  Title: \"" + getTitle()
               + "\"  |  Price: $" + String.format("%.2f", getPrice());
    }
}
