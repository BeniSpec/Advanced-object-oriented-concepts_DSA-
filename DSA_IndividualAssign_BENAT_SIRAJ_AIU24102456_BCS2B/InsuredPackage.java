/**
 * Task 2 - InsuredPackage (subclass of Package)
 *
 * Adds an insurance surcharge on top of the base shipping cost.
 *
 * Insurance table (based on shippingCost BEFORE insurance):
 *   Shipping Cost   Additional Insurance
 *   $0 – $1.00      $2.45
 *   $1.01 – $3.00   $3.95
 *   $3.01 and over  $5.55
 */
public class InsuredPackage extends Package {

    // ─── Additional field ─────────────────────────────────────────────────────
    private double insuranceCost;

    // ─── Constructor ──────────────────────────────────────────────────────────

    /**
     * Creates an InsuredPackage. Calls the parent constructor first
     * (which runs calculateCost()), then adds insurance via addInsurance().
     * @param weight         weight in ounces
     * @param shippingMethod 'A', 'T', or 'M'
     */
    public InsuredPackage(double weight, char shippingMethod) {
        super(weight, shippingMethod); // runs Package.calculateCost()
        addInsurance();                // add insurance on top
    }

    // ─── addInsurance() ───────────────────────────────────────────────────────

    /**
     * Calculates and adds the insurance cost to shippingCost.
     *
     * Algorithm:
     *   Look at the base shippingCost:
     *     <= 1.00        → insuranceCost = 2.45
     *     1.01 – 3.00    → insuranceCost = 3.95
     *     > 3.00         → insuranceCost = 5.55
     *   Then: shippingCost += insuranceCost
     */
    private void addInsurance() {
        double baseCost = shippingCost; // capture before modification
        if (baseCost <= 1.00) {
            insuranceCost = 2.45;
        } else if (baseCost <= 3.00) {
            insuranceCost = 3.95;
        } else {
            insuranceCost = 5.55;
        }
        shippingCost += insuranceCost; // update total cost in parent field
    }

    // ─── Overridden display() ─────────────────────────────────────────────────

    /**
     * Displays all Package fields PLUS insurance cost and total cost.
     */
    @Override
    public void display() {
        System.out.println("  Weight          : " + weight + " oz");
        System.out.println("  Shipping Method : " + shippingMethod
                           + " (" + methodName() + ")");
        System.out.println("  Insurance Cost  : $" + String.format("%.2f", insuranceCost));
        System.out.println("  TOTAL Cost      : $" + String.format("%.2f", shippingCost));
    }

    // ─── Helper (duplicated here to keep display() working) ──────────────────
    private String methodName() {
        switch (shippingMethod) {
            case 'A': return "Air";
            case 'T': return "Truck";
            case 'M': return "Mail";
            default : return "Unknown";
        }
    }
}
