public class InsuredPackage extends Package {

    // ── Additional field 
    private double insuranceCost; // surcharge added to shippingCost

    // ── Constructor 
    public InsuredPackage(double weight, char shippingMethod) {
        super(weight, shippingMethod); // Step 1: parent init + base cost
        addInsurance();                // Step 2: append insurance premium
    }

    // ── addInsurance() 
    private void addInsurance() {
        double baseCost = shippingCost;  // capture before modification
        if (baseCost <= 1.00) {
            insuranceCost = 2.45;
        } else if (baseCost <= 3.00) {
            insuranceCost = 3.95;
        } else {
            insuranceCost = 5.55;
        }
        shippingCost += insuranceCost;   // update total in inherited field
    }

    // ── display() — overridden 
    @Override
    public void display() {
        System.out.println("  Weight          : " + weight + " oz");
        System.out.println("  Shipping Method : " + shippingMethod
                           + " (" + getMethodName() + ")");
        System.out.println("  Insurance Cost  : $" + String.format("%.2f", insuranceCost));
        System.out.println("  TOTAL Cost      : $" + String.format("%.2f", shippingCost));
    }

    // ── Getter 
    public double getInsuranceCost() { return insuranceCost; }
}
