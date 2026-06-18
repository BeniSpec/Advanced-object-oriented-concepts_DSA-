import java.util.Scanner;

public class UsePackage {

    private static final Scanner sc    = new Scanner(System.in);
    private static final String  LINE  = "=".repeat(54);
    private static final String  DLINE = "-".repeat(54);

    // ── Entry point ─────────────────────────────────────────────────────────

    public static void main(String[] args) {

        printBanner();

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("  Enter choice : ");
            String input = sc.nextLine().trim();
            System.out.println(DLINE);

            switch (input) {
                case "1": menuCreatePackage();         break;
                case "2": menuCreateInsuredPackage();  break;
                case "3": runDemonstration();          break;
                case "0":
                    System.out.println("  Goodbye! Exiting Task 2.");
                    running = false;
                    break;
                default:
                    System.out.println("  [!] Invalid choice. Enter 0–3.");
            }
            System.out.println();
        }
        sc.close();
    }

    // ── Menu ────────────────────────────────────────────────────────────────

    private static void printBanner() {
        System.out.println(LINE);
        System.out.println("  TASK 2 — Package Logistics System");
        System.out.println(LINE);
        System.out.println("  Shipping Methods: A = Air | T = Truck | M = Mail");
        System.out.println(LINE);
    }

    private static void printMenu() {
        System.out.println(LINE);
        System.out.println("  [1] Create a regular Package");
        System.out.println("  [2] Create an InsuredPackage");
        System.out.println("  [3] Run test cases");
        System.out.println("  [0] Exit");
        System.out.println(DLINE);
    }

    // ── Menu handlers ───────────────────────────────────────────────────────

    private static void menuCreatePackage() {
        System.out.print("  Enter weight (oz) : ");
        double w = readDouble();
        System.out.print("  Enter method (A/T/M) : ");
        char m = readMethod();
        System.out.println();
        System.out.println("  --- Package ---");
        new Package(w, m).display();
    }

    private static void menuCreateInsuredPackage() {
        System.out.print("  Enter weight (oz) : ");
        double w = readDouble();
        System.out.print("  Enter method (A/T/M) : ");
        char m = readMethod();
        System.out.println();
        System.out.println("  --- InsuredPackage ---");
        new InsuredPackage(w, m).display();
    }

    // ── Built-in demonstration ───────────────────────────────────────────────

    private static void runDemonstration() {
        System.out.println("  *** BUILT-IN DEMONSTRATION ***");
        System.out.println();

        // ─── Regular Packages ───────────────────────────────────────────
        System.out.println("  ============ REGULAR PACKAGES ============");
        System.out.println();

        Package[] packages = {
            new Package(5,  'A'),   //  5 oz Air   → $2.00
            new Package(12, 'T'),   // 12 oz Truck → $2.35
            new Package(20, 'M'),   // 20 oz Mail  → $2.15
            new Package(8,  'M'),   //  8 oz Mail  → $0.50 (boundary)
            new Package(16, 'A')    // 16 oz Air   → $3.00 (boundary)
        };
        String[] pLabels = {
            "Package 1 —  5 oz, Air    (expected $2.00)",
            "Package 2 — 12 oz, Truck  (expected $2.35)",
            "Package 3 — 20 oz, Mail   (expected $2.15)",
            "Package 4 —  8 oz, Mail   (boundary $0.50)",
            "Package 5 — 16 oz, Air    (boundary $3.00)"
        };

        for (int i = 0; i < packages.length; i++) {
            System.out.println("  --- " + pLabels[i] + " ---");
            packages[i].display();
            System.out.println();
        }

        // ─── Insured Packages ────────────────────────────────────────────
        System.out.println("  =========== INSURED PACKAGES =============");
        System.out.println();

        InsuredPackage[] iPackages = {
            new InsuredPackage(4,  'M'),  //  4 oz Mail  base $0.50  + $2.45 = $2.95
            new InsuredPackage(10, 'T'),  // 10 oz Truck base $2.35  + $3.95 = $6.30
            new InsuredPackage(25, 'A'),  // 25 oz Air   base $4.50  + $5.55 = $10.05
            new InsuredPackage(7,  'T')   //  7 oz Truck base $1.50  + $3.95 = $5.45
        };
        String[] iLabels = {
            "InsuredPackage 1 —  4 oz, Mail  (base $0.50  + $2.45 = $2.95)",
            "InsuredPackage 2 — 10 oz, Truck (base $2.35  + $3.95 = $6.30)",
            "InsuredPackage 3 — 25 oz, Air   (base $4.50  + $5.55 = $10.05)",
            "InsuredPackage 4 —  7 oz, Truck (base $1.50  + $3.95 = $5.45)"
        };

        for (int i = 0; i < iPackages.length; i++) {
            System.out.println("  --- " + iLabels[i] + " ---");
            iPackages[i].display();
            System.out.println();
        }

        System.out.println("  *** END OF DEMONSTRATION ***");
    }

    // ── Input helpers ────────────────────────────────────────────────────────
    private static double readDouble() {
        while (true) {
            try {
                double v = Double.parseDouble(sc.nextLine().trim());
                if (v > 0) return v;
                System.out.print("  [!] Weight must be positive. Try again : ");
            } catch (NumberFormatException e) {
                System.out.print("  [!] Please enter a number. Try again : ");
            }
        }
    }

    private static char readMethod() {
        while (true) {
            String s = sc.nextLine().trim().toUpperCase();
            if (s.length() == 1 && "ATM".contains(s)) return s.charAt(0);
            System.out.print("  [!] Enter A, T, or M : ");
        }
    }
}
