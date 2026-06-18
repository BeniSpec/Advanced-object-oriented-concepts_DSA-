public class Package {

    // ── Fields (protected → accessible by InsuredPackage) ──────────────────
    protected double weight;         // weight in ounces
    protected char   shippingMethod; // 'A' = Air, 'T' = Truck, 'M' = Mail
    protected double shippingCost;   // computed by calculateCost()

    // ── Constructor 
    public Package(double weight, char shippingMethod) {
        this.weight         = weight;
        this.shippingMethod = Character.toUpperCase(shippingMethod);
        calculateCost();  // call on construction
    }

    // ── calculateCost() 
    protected void calculateCost() {
        if (weight <= 8) {
            // Tier 1: 1–8 oz
            switch (shippingMethod) {
                case 'A': shippingCost = 2.00; break;
                case 'T': shippingCost = 1.50; break;
                case 'M': shippingCost = 0.50; break;
                default:  shippingCost = 0.00;
            }
        } else if (weight <= 16) {
            // Tier 2: 9–16 oz
            switch (shippingMethod) {
                case 'A': shippingCost = 3.00; break;
                case 'T': shippingCost = 2.35; break;
                case 'M': shippingCost = 1.50; break;
                default:  shippingCost = 0.00;
            }
        } else {
            // Tier 3: 17 oz and over
            switch (shippingMethod) {
                case 'A': shippingCost = 4.50; break;
                case 'T': shippingCost = 3.25; break;
                case 'M': shippingCost = 2.15; break;
                default:  shippingCost = 0.00;
            }
        }
    }

    // ── display() ───────────────────────────────────────────────────────────

    public void display() {
        System.out.println("  Weight          : " + weight + " oz");
        System.out.println("  Shipping Method : " + shippingMethod
                           + " (" + getMethodName() + ")");
        System.out.println("  Shipping Cost   : $" + String.format("%.2f", shippingCost));
    }

    // ── Getters ─────────────────────────────────────────────────────────────

    public double getWeight()         { return weight; }
    public char   getShippingMethod() { return shippingMethod; }
    public double getShippingCost()   { return shippingCost; }

    // ── Helper ──────────────────────────────────────────────────────────────

    /** Returns the full English name of the shipping method. */
    protected String getMethodName() {
        switch (shippingMethod) {
            case 'A': return "Air";
            case 'T': return "Truck";
            case 'M': return "Mail";
            default : return "Unknown";
        }
    }
}
