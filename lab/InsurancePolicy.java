package lab;

public abstract class InsurancePolicy {
    protected String policyHolderName;
    protected int id;
    protected Car car;
    protected int numberOfClaims;

    public InsurancePolicy(String policyHolderName, int id, Car car, int numberOfClaims) {
        this.policyHolderName = policyHolderName;
        this.id = id;
        this.car = car;
        this.numberOfClaims = numberOfClaims;
    }

    public void printAttributes() {
        System.out.print("Name of the policy holder: " + policyHolderName + " ID: " + id + " Number of claims: "
                + numberOfClaims + " Car: ");
        car.print();
    }

    public String toString() {
        return "Name of the policy holder: " + policyHolderName + " ID: " + id
                + " Number of claims: " + numberOfClaims + " Car: " + car;
    }

    public abstract double calculatePayment(int flatRate);
}
