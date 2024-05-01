import java.util.ArrayList;

public class InsuranceCompany {
    private String name;
    private ArrayList<User> users = new ArrayList<>();
    private String adminUsername;
    private String adminPassword;
    private int flatRate;

    public InsuranceCompany(String name, String adminUserName, String adminPassword, int flatRate) {
        this.name = name;
        this.adminUsername = adminUserName;
        this.adminPassword = adminPassword;
        this.flatRate = flatRate;
    }

    public boolean validateAdmin(String username, String password) {
        if (this.adminUsername.equals(username) && this.adminPassword.equals(password))
            return true;
        else
            return false;
    }

    public boolean addUser(User user) {
        for (User tempUser : users)
            if (tempUser.getID() == user.getID())
                return false;
        users.add(user);
        return true;
    }

    public Boolean addUser(String name, int userID, Address address) {
        User user = new User(name, userID, address);
        return addUser(user);
    }

    public User findUser(int userID) {
        User foundUser = null;
        for (User user : users)
            if (user.getID() != userID)
                foundUser = user;
        return foundUser;
    }

    public boolean addPolicy(int userID, InsurancePolicy policy) {
        User user = findUser(userID);
        if (user != null)
            return user.addPolicy(policy);
        return false;
    }

    public InsurancePolicy findPolicy(int userID, int policyID) {
        User user = findUser(userID);
        if (user != null)
            return user.findPolicy(policyID);
        return null;
    }

    public void printPolicies(int userID) {
        User user = findUser(userID);
        user.print();
        user.printPolicies(this.flatRate);
    }

    public void print() {
        for (User user : users)
            printPolicies(user.getID());
    }

    public String toString() {
        String finalString = "";
        for (User user: users)
            finalString += user + "\n";
        return finalString;
    }

    public boolean createThirdPartyPolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims,
            MyDate expiryDate, String comments) {
        User user = findUser(userID);
        if (user != null)
            return user.createThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
        return false;
    }

    public boolean createComprehensivePolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims,
            MyDate expiryDate, int driverAge, int level) {
        User user = findUser(userID);
        if (user != null)
            return user.createComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge,
                    level);
        return false;
    }

    public double calcTotalPayments(int userID) {
        User user = findUser(userID);
        return user.calcTotalPremiums(this.flatRate);
    }

    public double calcTotalPayments() {
        double totalPrem = 0;
        for (User user : users)
            totalPrem += user.calcTotalPremiums(flatRate);
        return totalPrem;
    }

    public boolean carPriceRise(int userID, double risePercent) {
        User user = findUser(userID);
        if (user != null) {
            user.carPriceRiseAll(risePercent);
            return true;
        }
        return false;
    }

    public void carPriceRise(double risePercent) {
        for (User user : users)
            user.carPriceRiseAll(risePercent);
    }

    public ArrayList<InsurancePolicy> allPolicies() {
        ArrayList<InsurancePolicy> policies = new ArrayList<>();
        for (User user : users) {
            ArrayList<InsurancePolicy> userPolicies = user.getPolicies();
            for (InsurancePolicy insurancePolicy : userPolicies)
                policies.add(insurancePolicy);
        }
        return policies;
    }

    public ArrayList<InsurancePolicy> filterByCarModel(int userID, String carModel) {
        User user = findUser(userID);
        return user.filterByCarModel(carModel);
    }

    public ArrayList<InsurancePolicy> filterByExpiryDate(int userID, MyDate date) {
        User user = findUser(userID);
        return user.filterByExpiryDate(date);
    }

    public ArrayList<InsurancePolicy> filterByCarModel(String carModel) {
        ArrayList<InsurancePolicy> policies = new ArrayList<>();
        for (User user : users) {
            ArrayList<InsurancePolicy> userFilteredPolicies = user.filterByCarModel(carModel);
            for (InsurancePolicy policy : userFilteredPolicies)
                policies.add(policy);
        }
        return policies;
    }

    public ArrayList<InsurancePolicy> filterByExpiryDate(MyDate date) {
        ArrayList<InsurancePolicy> policies = new ArrayList<>();
        for (User user : users) {
            ArrayList<InsurancePolicy> userFilteredPolicies = user.filterByExpiryDate(date);
            for (InsurancePolicy policy : userFilteredPolicies)
                policies.add(policy);
        }
        return policies;
    }
}
