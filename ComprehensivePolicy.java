public class ComprehensivePolicy extends InsurancePolicy {
    protected int ageOfDriver;
    protected int level;

    public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int age, int level) {
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.ageOfDriver = age;
        this.level = level;
    }

    @Override
    public void print() {
        super.print();
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
