public class Day {

    // ── Constants 
    /** Full day names, indexed Sun=0 … Sat=6 */
    public static final String[] DAYS = {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };

    // ── Internal state 
    /** Current day index (0–6). private → enforces encapsulation */
    private int dayIndex;

    // ── Constructors 
    /** Default constructor — initialises day to Sunday (index 0). */
    public Day() {
        this.dayIndex = 0;
    }

    public Day(String day) {
        setDay(day);
    }

    // ── a) Set the day 
    public boolean setDay(String day) {
        for (int i = 0; i < DAYS.length; i++) {
            if (DAYS[i].equalsIgnoreCase(day)) {
                this.dayIndex = i;
                return true;
            }
        }
        // Invalid input — default to Sunday
        System.out.println("  [Warning] \"" + day + "\" is not a valid day. Defaulting to Sunday.");
        this.dayIndex = 0;
        return false;
    }

    // ── b) Print the day 
    /** Prints the current day to the console. */
    public void printDay() {
        System.out.println("  Current day : " + DAYS[dayIndex]);
    }

    // ── c) Return the day 
  
    public String getDay() {
        return DAYS[dayIndex];
    }

    // ── d) Return the next day 
    public String getNextDay() {
        return DAYS[(dayIndex + 1) % 7];
    }

    // ── e) Return the previous day 


    public String getPreviousDay() {
        return DAYS[(dayIndex + 6) % 7];
    }

    // ── f) Add / subtract days ──────────────────────────────────────────────

    public String addDays(int n) {
        int newIndex = ((dayIndex + n) % 7 + 7) % 7; // safe for negative n
        return DAYS[newIndex];
    }

    // ── Utility 
    /** Returns the numeric index of the current day (0 = Sunday … 6 = Saturday). */
    public int getDayIndex() {
        return dayIndex;
    }

    @Override
    public String toString() {
        return DAYS[dayIndex];
    }
}
