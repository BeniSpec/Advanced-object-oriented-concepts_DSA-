/**
 * Task 2 - Package Class
 *
 * Stores: weight (oz), shipping method ('A'/'T'/'M'), shipping cost.
 * Constructor calls calculateCost() automatically.
 *
 * Shipping cost table:
 *   Weight (oz)   Air($)  Truck($)  Mail($)
 *   1–8            2.00     1.50     0.50
 *   9–16           3.00     2.35     1.50
 *   17 and over    4.50     3.25     2.15
 */
public class Package {

    // ─── Fields ───────────────────────────────────────────────────────────────
    protected double weight;          // weight in ounces
    protected char   shippingMethod;  // 'A' = Air, 'T' = Truck, 'M' = Mail
    protected double shippingCost;    // calculated by calculateCost()

    // ─── Constructor ──────────────────────────────────────────────────────────

    /**
     * Creates a Package and immediately calculates its shipping cost.
     * @param weight         weight in ounces (must be > 0)
     * @param shippingMethod 'A', 'T', or 'M'
     */
    public Package(double weight, char shippingMethod) {
        this.weight         = weight;
        this.shippingMethod = Character.toUpperCase(shippingMethod);
        calculateCost();  // automatically set cost on construction
    }

    // ─── calculateCost() ──────────────────────────────────────────────────────

    /**
     * Determines shippingCost based on weight and shippingMethod.
     *
     * Algorithm (decision table):
     *   if weight <= 8  → tier 1  (Air 2.00 / Truck 1.50 / Mail 0.50)
     *   elif weight <=16 → tier 2 (Air 3.00 / Truck 2.35 / Mail 1.50)
     *   else             → tier 3 (Air 4.50 / Truck 3.25 / Mail 2.15)
     */
    protected void calculateCost() {
        if (weight <= 8) {
            switch (shippingMethod) {
                case 'A': shippingCost = 2.00; break;
                case 'T': shippingCost = 1.50; break;
                case 'M': shippingCost = 0.50; break;
                default : shippingCost = 0.00;
            }
        } else if (weight <= 16) {
            switch (shippingMethod) {
                case 'A': shippingCost = 3.00; break;
                case 'T': shippingCost = 2.35; break;
                case 'M': shippingCost = 1.50; break;
                default : shippingCost = 0.00;
            }
        } else {
            // 17 oz and over
            switch (shippingMethod) {
                case 'A': shippingCost = 4.50; break;
                case 'T': shippingCost = 3.25; break;
                case 'M': shippingCost = 2.15; break;
                default : shippingCost = 0.00;
            }
        }
    }

    // ─── display() ────────────────────────────────────────────────────────────

    /**
     * Displays all four fields: weight, method, method name, and cost.
     */
    public void display() {
        System.out.println("  Weight          : " + weight + " oz");
        System.out.println("  Shipping Method : " + shippingMethod
                           + " (" + methodName() + ")");
        System.out.println("  Shipping Cost   : $" + String.format("%.2f", shippingCost));
    }

    // ─── Helper ───────────────────────────────────────────────────────────────

    /** Returns the full name of the shipping method. */
    private String methodName() {
        switch (shippingMethod) {
            case 'A': return "Air";
            case 'T': return "Truck";
            case 'M': return "Mail";
            default : return "Unknown";
        }
    }
}
