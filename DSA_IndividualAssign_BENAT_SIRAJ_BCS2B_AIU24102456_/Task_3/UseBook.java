import java.util.Scanner;

public class UseBook {

    private static final Scanner sc    = new Scanner(System.in);
    private static final String  LINE  = "=".repeat(54);
    private static final String  DLINE = "-".repeat(54);

    public static void main(String[] args) {

        printBanner();

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("  Enter choice : ");
            String input = sc.nextLine().trim();
            System.out.println(DLINE);

            switch (input) {
                case "1": menuCreateFiction();     break;
                case "2": menuCreateNonFiction();  break;
                case "3": runDemonstration();      break;
                case "0":
                    System.out.println("  Goodbye! Exiting Task 3a.");
                    running = false;
                    break;
                default:
                    System.out.println("  [!] Invalid choice. Enter 0-3.");
            }
            System.out.println();
        }
        sc.close();
    }

    // Menu layout
    private static void printBanner() {
        System.out.println(LINE);
        System.out.println("  TASK 3a — Book Class Interactive Demo");
        System.out.println(LINE);
        System.out.println("  Fiction books    → $24.99  |  NonFiction → $37.99");
        System.out.println(LINE);
    }

    private static void printMenu() {
        System.out.println(LINE);
        System.out.println("  [1] Create a Fiction book");
        System.out.println("  [2] Create a NonFiction book");
        System.out.println("  [3] Run test cases");
        System.out.println("  [0] Exit");
        System.out.println(DLINE);
    }

    // Input handlers
    private static void menuCreateFiction() {
        System.out.print("  Enter book title : ");
        String title = sc.nextLine().trim();
        Fiction f = new Fiction(title);
        System.out.println();
        System.out.println("  " + f);
        System.out.println("  getTitle() : " + f.getTitle());
        System.out.println("  getPrice() : $" + String.format("%.2f", f.getPrice()));
    }

    private static void menuCreateNonFiction() {
        System.out.print("  Enter book title : ");
        String title = sc.nextLine().trim();
        NonFiction nf = new NonFiction(title);
        System.out.println();
        System.out.println("  " + nf);
        System.out.println("  getTitle() : " + nf.getTitle());
        System.out.println("  getPrice() : $" + String.format("%.2f", nf.getPrice()));
    }

    // Built-in automated showcase
    private static void runDemonstration() {
        System.out.println("  *** BUILT-IN DEMONSTRATION ***");
        System.out.println();

        Fiction f1 = new Fiction("The Great Gatsby");
        Fiction f2 = new Fiction("To Kill a Mockingbird");

        System.out.println("  --- Fiction Books ---");
        System.out.println("  " + f1);
        System.out.println("    getTitle() : " + f1.getTitle());
        System.out.println("    getPrice() : $" + String.format("%.2f", f1.getPrice()));
        System.out.println();
        System.out.println("  " + f2);
        System.out.println("    getTitle() : " + f2.getTitle());
        System.out.println("    getPrice() : $" + String.format("%.2f", f2.getPrice()));
        System.out.println();

        NonFiction nf1 = new NonFiction("A Brief History of Time");
        NonFiction nf2 = new NonFiction("Sapiens");

        System.out.println("  --- NonFiction Books ---");
        System.out.println("  " + nf1);
        System.out.println("    getTitle() : " + nf1.getTitle());
        System.out.println("    getPrice() : $" + String.format("%.2f", nf1.getPrice()));
        System.out.println();
        System.out.println("  " + nf2);
        System.out.println("    getTitle() : " + nf2.getTitle());
        System.out.println("    getPrice() : $" + String.format("%.2f", nf2.getPrice()));

        System.out.println();
        System.out.println("  *** END OF DEMONSTRATION ***");
    }
}