/**
 * Task 1 - Day Class
 * Represents a day of the week and supports operations like
 * getting next/previous day, and adding days.
 *
 * Algorithm:
 * - Store days as an array of strings indexed 0-6 (Sun=0, Mon=1, ..., Sat=6)
 * - Use modulo arithmetic (% 7) to wrap around the week
 */
public class Day {

    // Array of day abbreviations (index 0=Sunday ... index 6=Saturday)
    private static final String[] DAYS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    private int dayIndex; // internal index 0–6

    // ─── Constructor ───────────────────────────────────────────────────────────

    /**
     * Default constructor – sets day to Sunday.
     */
    public Day() {
        this.dayIndex = 0;
    }

    /**
     * Parameterised constructor – accepts a day abbreviation (e.g. "Mon").
     * @param day Three-letter day abbreviation
     */
    public Day(String day) {
        setDay(day);
    }

    // ─── a) Set the day ────────────────────────────────────────────────────────

    /**
     * Sets the current day using a three-letter abbreviation.
     * @param day e.g. "Sun", "Mon", ..., "Sat"
     */
    public void setDay(String day) {
        for (int i = 0; i < DAYS.length; i++) {
            if (DAYS[i].equalsIgnoreCase(day)) {
                this.dayIndex = i;
                return;
            }
        }
        // If not found, default to Sunday and warn
        System.out.println("Invalid day \"" + day + "\". Defaulting to Sunday.");
        this.dayIndex = 0;
    }

    // ─── b) Print the day ──────────────────────────────────────────────────────

    /**
     * Prints the current day to the console.
     */
    public void printDay() {
        System.out.println("Current day: " + DAYS[dayIndex]);
    }

    // ─── c) Return the day ─────────────────────────────────────────────────────

    /**
     * Returns the current day as a String.
     * @return day abbreviation, e.g. "Mon"
     */
    public String getDay() {
        return DAYS[dayIndex];
    }

    // ─── d) Return the next day ────────────────────────────────────────────────

    /**
     * Returns the next day (wraps Sunday→Monday correctly).
     * Algorithm: (dayIndex + 1) % 7
     * @return next day abbreviation
     */
    public String getNextDay() {
        return DAYS[(dayIndex + 1) % 7];
    }

    // ─── e) Return the previous day ────────────────────────────────────────────

    /**
     * Returns the previous day (wraps Sunday back to Saturday).
     * Algorithm: (dayIndex + 6) % 7  — adding 6 avoids negative modulo
     * @return previous day abbreviation
     */
    public String getPreviousDay() {
        return DAYS[(dayIndex + 6) % 7];
    }

    // ─── f) Add days ───────────────────────────────────────────────────────────

    /**
     * Returns the day obtained by adding a given number of days to the current day.
     * Algorithm: (dayIndex + n) % 7
     * Example: Monday (1) + 4 = 5 → Friday
     *          Tuesday (2) + 13 = 15 % 7 = 1 → Monday
     * @param n number of days to add (must be >= 0)
     * @return resulting day abbreviation
     */
    public String addDays(int n) {
        return DAYS[(dayIndex + n) % 7];
    }

    // ─── toString override ─────────────────────────────────────────────────────

    @Override
    public String toString() {
        return DAYS[dayIndex];
    }
}
