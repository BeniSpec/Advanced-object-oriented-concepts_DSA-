/**
 * Task 2 - UsePackage
 *
 * Driver program that demonstrates Package and InsuredPackage objects.
 * Creates >= 3 of each type with varied weights and shipping methods.
 */
public class UsePackage {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("         TASK 2 — Package Demo               ");
        System.out.println("==============================================\n");

        // ─── Regular Package objects (at least 3) ─────────────────────────
        System.out.println("============ REGULAR PACKAGES ================\n");

        Package p1 = new Package(5, 'A');   // 5 oz, Air     → $2.00
        Package p2 = new Package(12, 'T');  // 12 oz, Truck  → $2.35
        Package p3 = new Package(20, 'M');  // 20 oz, Mail   → $2.15
        Package p4 = new Package(8, 'M');   // 8 oz, Mail    → $0.50  (boundary)
        Package p5 = new Package(16, 'A');  // 16 oz, Air    → $3.00  (boundary)

        Package[] packages = {p1, p2, p3, p4, p5};
        String[]  pLabels  = {
            "Package 1 (5 oz, Air)",
            "Package 2 (12 oz, Truck)",
            "Package 3 (20 oz, Mail)",
            "Package 4 (8 oz, Mail)  [boundary]",
            "Package 5 (16 oz, Air)  [boundary]"
        };

        for (int i = 0; i < packages.length; i++) {
            System.out.println("--- " + pLabels[i] + " ---");
            packages[i].display();
            System.out.println();
        }

        // ─── InsuredPackage objects (at least 3) ──────────────────────────
        System.out.println("=========== INSURED PACKAGES =================\n");

        InsuredPackage ip1 = new InsuredPackage(4,  'M');  // Mail ≤8 → $0.50  + $2.45 = $2.95
        InsuredPackage ip2 = new InsuredPackage(10, 'T');  // Truck 9-16 → $2.35 + $3.95 = $6.30
        InsuredPackage ip3 = new InsuredPackage(25, 'A');  // Air ≥17 → $4.50 + $5.55 = $10.05
        InsuredPackage ip4 = new InsuredPackage(7,  'T');  // Truck ≤8 → $1.50 + $3.95 = $5.45

        InsuredPackage[] iPackages = {ip1, ip2, ip3, ip4};
        String[]         iLabels   = {
            "InsuredPackage 1 (4 oz, Mail)",
            "InsuredPackage 2 (10 oz, Truck)",
            "InsuredPackage 3 (25 oz, Air)",
            "InsuredPackage 4 (7 oz, Truck)"
        };

        for (int i = 0; i < iPackages.length; i++) {
            System.out.println("--- " + iLabels[i] + " ---");
            iPackages[i].display();
            System.out.println();
        }

        System.out.println("==============================================");
        System.out.println("          End of Task 2 Demo                 ");
        System.out.println("==============================================");
    }
}
