/**
 * Task 1 - TestDay
 * Driver program to demonstrate all operations of the Day class.
 *
 * Operations demonstrated:
 *   a) Set the day
 *   b) Print the day
 *   c) Return the day
 *   d) Return the next day
 *   e) Return the previous day
 *   f) Add days and return the resulting day
 */
public class TestDay {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("         TASK 1 — Day Class Demo             ");
        System.out.println("==============================================\n");

        // ── Create a Day object using default constructor ──────────────────
        Day day1 = new Day();
        System.out.println("--- Default Constructor (no argument) ---");
        day1.printDay();                                      // b) print
        System.out.println("getDay()         : " + day1.getDay());    // c) return

        System.out.println();

        // ── a) setDay() ────────────────────────────────────────────────────
        System.out.println("--- a) setDay(\"Wed\") ---");
        day1.setDay("Wed");
        day1.printDay();

        System.out.println();

        // ── b) printDay() ──────────────────────────────────────────────────
        System.out.println("--- b) printDay() ---");
        day1.printDay();

        System.out.println();

        // ── c) getDay() ────────────────────────────────────────────────────
        System.out.println("--- c) getDay() ---");
        System.out.println("Returned value   : " + day1.getDay());

        System.out.println();

        // ── d) getNextDay() ────────────────────────────────────────────────
        System.out.println("--- d) getNextDay() ---");
        System.out.println("Current day      : " + day1.getDay());
        System.out.println("Next day         : " + day1.getNextDay());

        // Edge case: Saturday → should wrap to Sunday
        Day day2 = new Day("Sat");
        System.out.println("\nEdge case  Sat → next : " + day2.getNextDay());

        System.out.println();

        // ── e) getPreviousDay() ────────────────────────────────────────────
        System.out.println("--- e) getPreviousDay() ---");
        System.out.println("Current day      : " + day1.getDay());
        System.out.println("Previous day     : " + day1.getPreviousDay());

        // Edge case: Sunday → should wrap to Saturday
        Day day3 = new Day("Sun");
        System.out.println("\nEdge case  Sun → prev : " + day3.getPreviousDay());

        System.out.println();

        // ── f) addDays() ───────────────────────────────────────────────────
        System.out.println("--- f) addDays(n) ---");

        // Example 1 from assignment: Monday + 4 = Friday
        Day day4 = new Day("Mon");
        System.out.println("Current day      : " + day4.getDay());
        System.out.println("Add 4 days       : " + day4.addDays(4) + "  (expected: Fri)");

        // Example 2 from assignment: Tuesday + 13 = Monday
        Day day5 = new Day("Tue");
        System.out.println("\nCurrent day      : " + day5.getDay());
        System.out.println("Add 13 days      : " + day5.addDays(13) + "  (expected: Mon)");

        // Extra example: Sunday + 0 = Sunday
        Day day6 = new Day("Sun");
        System.out.println("\nCurrent day      : " + day6.getDay());
        System.out.println("Add 0 days       : " + day6.addDays(0) + "  (expected: Sun)");

        System.out.println();

        // ── Invalid input handling ─────────────────────────────────────────
        System.out.println("--- Invalid input handling ---");
        Day day7 = new Day("Holiday"); // should print warning and default to Sun

        System.out.println("\n==============================================");
        System.out.println("            End of Task 1 Demo              ");
        System.out.println("==============================================");
    }
}
