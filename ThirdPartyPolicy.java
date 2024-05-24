public class ThirdPartyPolicy extends InsurancePolicy {
    protected String comments;

    public ThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate,
            String comments) {
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.comments = comments;
    }

    @Override
    public double calcPremium(double flatRate) {
        return car.getPrice() / 100 + numberOfClaims * 200 + flatRate;
    }

    @Override
    public void print() {
        super.print();
        System.out.println(" Comments: " + comments);
    }

    @Override
    public String toString() {
        return super.toString() + " Comments: " + comments;
    }

    // lab 4:

    public ThirdPartyPolicy(ThirdPartyPolicy policy) {
        super(policy.policyHolderName, policy.policyID, policy.car, policy.numberOfClaims, new MyDate(policy.getExpiryDate()));
        this.comments = policy.comments;
    }
}
