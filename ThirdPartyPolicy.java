package lab;

public class ThirdPartyPolicy extends InsurancePolicy {
    protected String comments;

    public ThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, String comments) {
        super(policyHolderName, id, car, numberOfClaims);
        this.comments = comments;
    }

    @Override
    public void printAttributes() {
        super.printAttributes();
        System.out.println(" Comments: " + comments);
    }

    @Override
    public String toString() {
        return super.toString() + " Comments: " + comments;
    }

    @Override
    public double calculatePayment(int flatRate) {
        return (car.getPrice() / 100 + numberOfClaims * 200 + flatRate);
    }
}
