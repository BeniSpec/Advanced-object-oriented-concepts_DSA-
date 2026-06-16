/**
 * Task 3a - UseBook
 *
 * Demonstrates creating Fiction and NonFiction objects
 * and printing their fields.
 */
public class UseBook {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("       TASK 3a — Book Class Demo             ");
        System.out.println("==============================================\n");

        // ─── Create Fiction book ──────────────────────────────────────────
        Fiction f1 = new Fiction("The Great Gatsby");
        Fiction f2 = new Fiction("To Kill a Mockingbird");

        System.out.println("--- Fiction Books ---");
        System.out.println(f1);
        System.out.println("  getTitle() : " + f1.getTitle());
        System.out.println("  getPrice() : $" + String.format("%.2f", f1.getPrice()));
        System.out.println();
        System.out.println(f2);
        System.out.println("  getTitle() : " + f2.getTitle());
        System.out.println("  getPrice() : $" + String.format("%.2f", f2.getPrice()));
        System.out.println();

        // ─── Create NonFiction book ───────────────────────────────────────
        NonFiction nf1 = new NonFiction("A Brief History of Time");
        NonFiction nf2 = new NonFiction("Sapiens");

        System.out.println("--- NonFiction Books ---");
        System.out.println(nf1);
        System.out.println("  getTitle() : " + nf1.getTitle());
        System.out.println("  getPrice() : $" + String.format("%.2f", nf1.getPrice()));
        System.out.println();
        System.out.println(nf2);
        System.out.println("  getTitle() : " + nf2.getTitle());
        System.out.println("  getPrice() : $" + String.format("%.2f", nf2.getPrice()));

        System.out.println("\n==============================================");
        System.out.println("         End of Task 3a Demo                 ");
        System.out.println("==============================================");
    }
}
