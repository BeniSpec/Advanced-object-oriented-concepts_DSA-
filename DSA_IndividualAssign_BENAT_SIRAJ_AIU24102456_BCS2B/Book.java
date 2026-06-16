/**
 * Task 3a - Abstract Book Class
 *
 * Abstract base class for all book types.
 * Concrete subclasses (Fiction, NonFiction) must implement setPrice().
 */
public abstract class Book {

    // ─── Fields ───────────────────────────────────────────────────────────────
    private String title;   // book title
    protected double price; // accessible by subclasses for setPrice()

    // ─── Constructor ──────────────────────────────────────────────────────────

    /**
     * Creates a Book with a given title.
     * Price is NOT set here — setPrice() in each subclass handles it.
     * @param title the book's title
     */
    public Book(String title) {
        this.title = title;
        // setPrice() will be called from each subclass constructor
    }

    // ─── Abstract method ──────────────────────────────────────────────────────

    /**
     * Abstract method — must be implemented by every subclass.
     * Each subclass assigns its own fixed price.
     */
    public abstract void setPrice();

    // ─── Getter: title ────────────────────────────────────────────────────────

    /**
     * Returns the book's title.
     * @return title string
     */
    public String getTitle() {
        return title;
    }

    // ─── Getter: price ────────────────────────────────────────────────────────

    /**
     * Returns the book's price.
     * @return price as double
     */
    public double getPrice() {
        return price;
    }

    // ─── toString ─────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Book{title='" + title + "', price=$" + String.format("%.2f", price) + "}";
    }
}
