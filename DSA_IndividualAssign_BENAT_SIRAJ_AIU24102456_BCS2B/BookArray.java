/**
 * Task 3b - BookArray
 *
 * Creates an array of 10 Book objects (mix of Fiction and NonFiction)
 * and displays all of them using a for loop.
 *
 * Key concept: Polymorphism — the array type is Book (abstract parent),
 * but actual objects are Fiction or NonFiction. The correct toString()
 * is called at runtime via dynamic dispatch.
 */
public class BookArray {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("       TASK 3b — BookArray Demo              ");
        System.out.println("==============================================\n");

        // ─── Array of 10 Book references ─────────────────────────────────
        // Mix of Fiction (F) and NonFiction (NF)
        Book[] books = new Book[10];

        books[0]  = new Fiction   ("The Hobbit");
        books[1]  = new NonFiction("Brief History of Time");
        books[2]  = new Fiction   ("1984");
        books[3]  = new NonFiction("Thinking, Fast and Slow");
        books[4]  = new Fiction   ("Harry Potter and the Sorcerer's Stone");
        books[5]  = new NonFiction("Sapiens");
        books[6]  = new Fiction   ("The Alchemist");
        books[7]  = new NonFiction("Educated");
        books[8]  = new Fiction   ("Dune");
        books[9]  = new NonFiction("The Body: A Guide for Occupants");

        // ─── Display all books using a for loop ───────────────────────────
        System.out.println("All 10 Books in the Array:\n");
        System.out.printf("%-4s %-12s %-42s %s%n", "No.", "Type", "Title", "Price");
        System.out.println("-".repeat(70));

        for (int i = 0; i < books.length; i++) {
            // Determine type label using instanceof
            String type = (books[i] instanceof Fiction) ? "Fiction" : "NonFiction";
            System.out.printf("%-4d %-12s %-42s $%.2f%n",
                              (i + 1),
                              type,
                              books[i].getTitle(),
                              books[i].getPrice());
        }

        System.out.println("-".repeat(70));
        System.out.println("\nAll prices set automatically by each subclass's setPrice().");
        System.out.println("  Fiction    → $24.99");
        System.out.println("  NonFiction → $37.99");

        System.out.println("\n==============================================");
        System.out.println("         End of Task 3b Demo                 ");
        System.out.println("==============================================");
    }
}
