import java.util.ArrayList;

public class User {
    private String name;
    private int userID;
    private Address address;
    private ArrayList<InsurancePolicy> policies; 

    public User(String name, int userID, Address address) {
        this.name = name;
        this.address = address;
        this.userID = userID;
        this.policies = new ArrayList<InsurancePolicy>();
    }

    public void setCity(String city) {
        this.address.setCity(city);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public InsurancePolicy findPolicy(int policyID) {
        for (InsurancePolicy insurancePolicy : policies) {
            if (insurancePolicy.id == policyID)
                return insurancePolicy;
        }
        return null;
    }

    public boolean addPolicy(InsurancePolicy policy) {
        if (findPolicy(policy.id) == null) {
            policies.add(policy);
            return true;
        }
        return false;
    }

    public void print() {
        System.out.print("Name: " + this.name + "ID: " + this.userID);
        address.print();
        printPolicies(Program.flatRate);
    }

    public void printPolicies(int flatRate) {
        int i = 1;
        for (InsurancePolicy insurancePolicy : policies) {
            System.out.print(i + ": ");
            insurancePolicy.print();
            System.out.println("Payment: " + insurancePolicy.calculatePayment(flatRate));
            i++;
        }
    }

    public String toString() {
        String finalStr = "";
        finalStr += "Name: " + name + "ID: " + userID + this.address + "\nPolicies: " + "\n";
        int i = 1;
        for (InsurancePolicy insurancePolicy : policies) {
            finalStr += i + ": " + insurancePolicy + "\n";
            i++;
        }
        return finalStr;
    }

    public double calcTotalPremiums(int flatRate) {
        double totalPremium = 0;
        for (InsurancePolicy insurancePolicy : policies) {
            totalPremium += insurancePolicy.calculatePayment(flatRate);
        }
        return totalPremium;
    }

    public void carPriceRiseAll(double risePercent) {
        for (InsurancePolicy insurancePolicy : policies) {
            insurancePolicy.carPriceRise(risePercent);
        }
    }

    public ArrayList<InsurancePolicy> filterByCarModel(String carModel) {
        return InsurancePolicy.filterByCarModel(policies, carModel);
    }
}
