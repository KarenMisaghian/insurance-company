package lab;

public class ComprehensivePolicy extends InsurancePolicy {
    protected int ageOfDriver;
    protected int level;

    public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, int age, int level) {
        super(policyHolderName, id, car, numberOfClaims);
        this.ageOfDriver = age;
        this.level = level;
    }

    @Override
    public void printAttributes() {
        super.printAttributes();
        System.out.println(" Driver's age: " + ageOfDriver + " Level: " + level);
    }

    @Override
    public String toString() {
        return super.toString() + " Driver's age: " + ageOfDriver + " Level: " + level;
    }

    @Override
    public double calculatePayment(int flatRate) {
        double basePrice = (car.getPrice() / 50 + numberOfClaims * 200 + flatRate);
        if (ageOfDriver < 30)
            return (basePrice + (30 - ageOfDriver) * 50);
        else
            return basePrice;
    }
}
