import java.util.ArrayList;

public abstract class InsurancePolicy {
    protected String policyHolderName;
    protected int id;
    protected Car car;
    protected int numberOfClaims;
    protected MyDate expiryDate;

    public InsurancePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate) {
        this.policyHolderName = policyHolderName;
        this.id = id;
        this.car = car;
        this.numberOfClaims = numberOfClaims;
        this.expiryDate = expiryDate;
    }

    public void setPolicyHolderName(String name) {
        this.policyHolderName = name;
    }

    public void setCarModel(String model) {
        this.car.setModel(model);
    }

    public void print() {
        System.out.print("Name of the policy holder: " + policyHolderName + " ID: " + id + " Number of claims: "
                + numberOfClaims + " Car: ");
        car.print();
    }

    // lab 2 starts here:

    public static void printPolicies(ArrayList<InsurancePolicy> policies) {
        for (InsurancePolicy policy : policies)
            policy.print();
    }

    public static double calcTotalPayments(ArrayList<InsurancePolicy> policies, int flatRate) {
        double totalPayment = 0;
        for (InsurancePolicy policy : policies)
            totalPayment += policy.calculatePayment(flatRate);
        return totalPayment;
    }

    public double priceRise(double rise) {
        double price = this.car.getPrice();
        price *= (1 + rise);
        this.car.setPrice(price);
        return price;
    }

    public void carPriceRise(double risePercent) {
        this.priceRise(risePercent);
    }

    public static void carPriceRiseAll(ArrayList<InsurancePolicy> policies, double risePercent) {
        for (InsurancePolicy policy : policies){
            policy.carPriceRise(risePercent);
        }
    }

    public static ArrayList<InsurancePolicy> filterByCarModel(ArrayList<InsurancePolicy> policies, String carModel) {
        ArrayList<InsurancePolicy> filteredPolicies = new ArrayList<>();
        for (InsurancePolicy policy : policies) {
            if (policy.car.getModel().equals(carModel))
                filteredPolicies.add(policy);
        }
        return filteredPolicies;
    }

    public String toString() {
        return "Name of the policy holder: " + policyHolderName + " ID: " + id
                + " Number of claims: " + numberOfClaims + " Car: " + car;
    }

    public abstract double calculatePayment(int flatRate);
}
