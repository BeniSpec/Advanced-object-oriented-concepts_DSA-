import java.util.Scanner;

public class TestDay {

    // ── Shared scanner (closed on exit) 
    private static final Scanner sc = new Scanner(System.in);

    // ── Colour-like separators for clarity 
    private static final String LINE  = "=".repeat(52);
    private static final String DLINE = "-".repeat(52);

    // ── Entry point 
    public static void main(String[] args) {

        printBanner();

        Day today = new Day("Sunday"); // default starting day
        boolean running = true;

        while (running) {
            printMenu(today);
            System.out.print("  Enter choice : ");
            String input = sc.nextLine().trim();

            System.out.println(DLINE);

            switch (input) {
                case "1": menuSetDay(today);          break;
                case "2": menuPrintDay(today);        break;
                case "3": menuNextDay(today);         break;
                case "4": menuPrevDay(today);         break;
                case "5": menuAddDays(today);         break;
                case "6": runDemonstration();         break;
                case "0":
                    System.out.println("  Goodbye! Exiting Task 1.");
                    running = false;
                    break;
                default:
                    System.out.println("  [!] Invalid choice. Please enter 0-6.");
            }
            System.out.println();
        }

        sc.close();
    }

    // ── Menu print 

    private static void printBanner() {
        System.out.println(LINE);
        System.out.println("   TASK 1 — Day Class Interactive Demo");
        System.out.println(LINE);
        System.out.println("  Valid day names: Sunday, Monday, Tuesday,");
        System.out.println("                   Wednesday, Thursday, Friday, Saturday");
        System.out.println(LINE);
    }

    private static void printMenu(Day d) {
        System.out.println(LINE);
        System.out.println("  Current Day : " + d.getDay());
        System.out.println(DLINE);
        System.out.println("  [1] Set the day");
        System.out.println("  [2] Print the day");
        System.out.println("  [3] Get the NEXT day");
        System.out.println("  [4] Get the PREVIOUS day");
        System.out.println("  [5] Add / subtract N days");
        System.out.println("  [6] Run test cases");
        System.out.println("  [0] Exit");
        System.out.println(DLINE);
    }

    // ── Menu handlers 

    /** Menu option 1 — set the day */
    private static void menuSetDay(Day d) {
        System.out.print("  Enter day name (e.g. Friday) : ");
        String name = sc.nextLine().trim();
        boolean ok = d.setDay(name);
        if (ok) System.out.println("  Day set to : " + d.getDay());
    }

    /** Menu option 2 — print / view the day */
    private static void menuPrintDay(Day d) {
        System.out.println("  [b] printDay() called :");
        d.printDay();
        System.out.println("  [c] getDay()  returned : " + d.getDay());
    }

    /** Menu option 3 — next day */
    private static void menuNextDay(Day d) {
        System.out.println("  Current day  : " + d.getDay());
        System.out.println("  Next day [d] : " + d.getNextDay());
    }

    /** Menu option 4 — previous day */
    private static void menuPrevDay(Day d) {
        System.out.println("  Current day      : " + d.getDay());
        System.out.println("  Previous day [e] : " + d.getPreviousDay());
    }

    /** Menu option 5 — add / subtract days */
    private static void menuAddDays(Day d) {
        System.out.print("  Enter number of days to add (can be negative) : ");
        try {
            int n = Integer.parseInt(sc.nextLine().trim());
            String result = d.addDays(n);
            System.out.println("  Current day  : " + d.getDay());
            System.out.println("  Days to add  : " + n);
            System.out.println("  Result   [f] : " + result);
        } catch (NumberFormatException e) {
            System.out.println("  [!] Please enter a whole number.");
        }
    }

    // ── Built-in demonstration ─
    private static void runDemonstration() {
        System.out.println("  *** BUILT-IN DEMONSTRATION ***");
        System.out.println();

        // a) Set the day
        Day d = new Day();
        System.out.println("  [a] setDay(\"Wednesday\")");
        d.setDay("Wednesday");

        // b) Print the day
        System.out.println("  [b] printDay()");
        d.printDay();

        // c) Return the day
        System.out.println("  [c] getDay() returned : " + d.getDay());
        System.out.println();

        // d) Next day
        System.out.println("  [d] getNextDay()");
        System.out.println("      Current : " + d.getDay() + "  →  Next : " + d.getNextDay());

        // Edge case: Saturday → Sunday
        Day sat = new Day("Saturday");
        System.out.println("      Edge case | Saturday → Next : " + sat.getNextDay());
        System.out.println();

        // e) Previous day
        System.out.println("  [e] getPreviousDay()");
        System.out.println("      Current : " + d.getDay() + "  →  Prev : " + d.getPreviousDay());

        // Edge case: Sunday → Saturday
        Day sun = new Day("Sunday");
        System.out.println("      Edge case | Sunday   → Prev : " + sun.getPreviousDay());
        System.out.println();

        // f) addDays — assignment examples
        System.out.println("  [f] addDays(n) — Assignment examples");
        Day mon = new Day("Monday");
        System.out.println("      Monday  + 4  days = " + mon.addDays(4)
                           + "  (expected: Friday)");

        Day tue = new Day("Tuesday");
        System.out.println("      Tuesday + 13 days = " + tue.addDays(13)
                           + "  (expected: Monday)");

        // Negative test
        Day fri = new Day("Friday");
        System.out.println("      Friday  - 2  days = " + fri.addDays(-2)
                           + "  (expected: Wednesday)");

        // Invalid input
        System.out.println();
        System.out.println("  [a] Invalid input test:");
        new Day("Holiday");  // triggers warning message

        System.out.println();
        System.out.println("  *** END OF TEST CASES ***");
    }
}
