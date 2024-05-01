import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static final int flatRate = 100;
    static Scanner inputReader = new Scanner(System.in);

    public static void addAccountToUser(User user, InsurancePolicy policy) {
        if (user.addPolicy(policy)) {
            System.out.println("Policy added successfully!");
        } else {
            System.out.println("Policy not added!");
        }
    }

    public static InsurancePolicy findPolicy(User user, int id) {
        InsurancePolicy policy = user.findPolicy(id);
        if (policy == null) {
            System.out.println("Policy has not been found");
        } else {
            System.out.println(policy);
        }
        return policy;
    }

    public static Address getAddressOfUser() {
        System.out.println("Please enter the street number: ");
        int streetNum = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("Please enter the street: ");
        String streetName = inputReader.nextLine();

        System.out.println("Please enter the suburb: ");
        String suburb = inputReader.nextLine();

        System.out.println("Please enter the city: ");
        String city = inputReader.nextLine();

        Address address = new Address(streetNum, streetName, suburb, city);

        return address;
    }

    public static String getCarModel() {
        System.out.println("Please enter the desired car model: ");
        String model = inputReader.nextLine();

        return model;
    }

    public static void loginToCompany(String userName, String Password, InsuranceCompany company) {
        boolean isValid = company.validateAdmin(userName, Password);

        if (isValid)
            System.out.println("Logged in successfully to company's account");
        else
            System.out.println("Wrong credentials, please try again...");
    }

    public static void addUser(User user, InsuranceCompany company) {
        if (company.addUser(user))
            System.out.println("User added successfully!");
        else
            System.out.println("Adding user failed, try again...");
    }

    public static void addUser(String name, int ID, Address address, InsuranceCompany company) {
        if (company.addUser(name, ID, address))
            System.out.println("Logged in successfully to company's account");
        else
            System.out.println("Wrong credentials, please try again...");
    }

    public static void addPolicy(int ID, InsurancePolicy policy, InsuranceCompany company) {
        if (company.addPolicy(ID, policy))
            System.out.println("Policy added to the user successfully!");
        else
            System.out.println("Could not add policy, please try again...");
    }

    public static void createThirdPartyPolicy(int ID, String policyHolderName, int id, Car car, int numberOfClaims,
            MyDate expiryDate, String comments, InsuranceCompany company) {
        if (company.createThirdPartyPolicy(ID, policyHolderName, id, car, numberOfClaims, expiryDate, comments))
            System.out.println("Policy added to the user successfully!");
        else
            System.out.println("Could not add policy, please try again...");
    }

    public static void createComprehensivePolicy(int ID, String policyHolderName, int id, Car car, int numberOfClaims,
            MyDate expiryDate, int driverAge, int level, InsuranceCompany company) {
        if (company.createComprehensivePolicy(ID, policyHolderName, id, car, numberOfClaims, expiryDate, driverAge,
                level))
            System.out.println("Policy added to the user successfully!");
        else
            System.out.println("Could not add policy, please try again...");
    }

    public static int getUserID() {
        System.out.println("please enter your desired User ID: ");
        int ID = inputReader.nextInt();
        inputReader.nextLine();

        return ID;
    }

    public static void printUser(InsuranceCompany company) {
        int ID = getUserID();
        company.printPolicies(ID);
    }

    public static int getPolicyID() {
        System.out.println("please enter your desired Policy ID: ");
        int ID = inputReader.nextInt();
        inputReader.nextLine();

        return ID;
    }

    public static void printPolicy(InsuranceCompany company) {
        int userID = getUserID();
        int policyID = getPolicyID();

        InsurancePolicy policy = company.findPolicy(userID, policyID);

        policy.print();
    }

    public static MyDate getDate() {
        System.out.println("Please enter the year: ");
        int year = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("Please enter the month: ");
        int month = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("Please enter the date: ");
        int day = inputReader.nextInt();
        inputReader.nextLine();

        MyDate createdDate = new MyDate(year, month, day);

        return createdDate;
    }
    public static void main(String[] args) {
        Car car1 = new Car("something", 100, 2024, Car.CarType.SED);
        MyDate date1 = new MyDate(2024, 5, 20);
        ThirdPartyPolicy thirdPartyPolicy1 = new ThirdPartyPolicy("Karen", 1, car1, 2, date1, "some dummy comment");

        Car car2 = new Car("something else", 150, 2023, Car.CarType.SED);
        MyDate date2 = new MyDate(2024, 6, 20);
        ThirdPartyPolicy thirdPartyPolicy2 = new ThirdPartyPolicy("Karen m", 2, car2, 2, date2,
                "some other dummy comment");

        Car car3 = new Car("another thing", 200, 2024, Car.CarType.SED);
        MyDate date3 = new MyDate(2024, 7, 20);
        ComprehensivePolicy comprehensivePolicy1 = new ComprehensivePolicy("Karen M", 3, car3, 0, date3, 18,
                1);

        Car car4 = new Car("another thing", 200, 2024, Car.CarType.SED);
        MyDate date4 = new MyDate(2024, 7, 20);
        ComprehensivePolicy comprehensivePolicy2 = new ComprehensivePolicy("Karen Mi", 4, car4, 2, date4, 37,
                2);

        Address address1 = new Address(5, "DUMMY_STREET", "DUMMY_SUBURB", "DUMMY_CITY");
        User user1 = new User("Karen", 1, address1);
        Address address2 = new Address(6, "DUMMY_STREET", "DUMMY_SUBURB", "DUMMY_CITY");
        User user2 = new User("SOME_NAME", 2, address2);
        Address address3 = new Address(6, "OTHER_DUMMY_STREET", "DUMMY_SUBURB", "DUMMY_CITY");
        User user3 = new User("SOME_OTHER_NAME", 3, address3);
        Address address4 = new Address(6, "DIFFERENT_DUMMY_STREET", "OTHER_DUMMY_SUBURB", "DUMMY_CITY");
        User user4 = new User("SOME_DIFFERENT_NAME", 4, address4);

        // addAccountToUser(user1, comprehensivePolicy2);
        // addAccountToUser(user1, comprehensivePolicy1);
        // addAccountToUser(user1, thirdPartyPolicy1);
        // addAccountToUser(user1, thirdPartyPolicy2);

        // user1.print();

        // System.out.println(user1);

        // InsurancePolicy searchedPolicy1 = findPolicy(user1, 5); //false id case...
        // InsurancePolicy searchedPolicy2 = findPolicy(user1, 2); // valid id case...

        // searchedPolicy2.print();
        // searchedPolicy2.carPriceRise(0.1);
        // searchedPolicy2.print();

        // String newName = "Robert";
        // searchedPolicy2.setPolicyHolderName(newName);

        // String newModel = "Toyota Camry 2018";
        // searchedPolicy2.setCarModel(newModel);

        // String newCity = "Wollongong";
        // user1.setCity(newCity);

        // Address testAddress = getAddressOfUser();
        // user1.setAddress(testAddress);

        // System.out.println(user1);

        // System.out.println("total premium is: " + user1.calcTotalPremiums(flatRate));

        // user1.carPriceRiseAll(0.1);

        // System.out.println("new total premium is: " + user1.calcTotalPremiums(flatRate));

        // String model = getCarModel();
        // ArrayList<InsurancePolicy> filteredPolicies = user1.filterByCarModel(model);

        // InsurancePolicy.printPolicies(filteredPolicies);

        // lab 3 tests start here:

        InsuranceCompany company = new InsuranceCompany("DUMMY_COMPANY", "name", "1234", flatRate);

        loginToCompany("DUMMY_NAME", "1234", company);
        loginToCompany("WRONG_NAME", "1234", company);

        addUser(user1, company);
        addUser(user2, company);
        addUser(user3, company);
        addUser(user4, company);
        addUser("KarenM", 2, address4, company);

        addPolicy(1, comprehensivePolicy1, company);
        addPolicy(2, comprehensivePolicy1, company);
        addPolicy(1, comprehensivePolicy2, company);
        addPolicy(4, comprehensivePolicy1, company);
        addPolicy(1, thirdPartyPolicy1, company);
        addPolicy(3, comprehensivePolicy2, company);
        addPolicy(23, comprehensivePolicy1, company);
        addPolicy(1, comprehensivePolicy1, company);

        createComprehensivePolicy(1, "name", 1, car1, 2, date1, 20, 2, company);
        createComprehensivePolicy(2, "other name", 2, car2, 3, date2, 40, 1, company);
        createThirdPartyPolicy(3, "another name", 3, car3, 0, date3, "no comment", company);
        createThirdPartyPolicy(4, "another dummy name", 4, car4, 5, date4, "no comment yet", company);
        createThirdPartyPolicy(111, "another name", 3, car3, 0, date3, "no comment", company);
        createThirdPartyPolicy(3, "another name here", 3, car3, 0, date3, "no comment", company);

        // testing get user info: 
        printUser(company);

        // testing findPolicy: 
        printPolicy(company);

        // testing printAllUsers:
        company.print();

        // testing risePriceAll: 
        company.carPriceRise(0.1);
        company.print();

        // testing calcTotalPayment:
        company.calcTotalPayments(1);
        
        // testing printing calcTotalPaymentOfAllUsers: 
        company.calcTotalPayments();

        // testing allPolicies:
        ArrayList<InsurancePolicy> testListAll = company.allPolicies();
        InsurancePolicy.printPolicies(testListAll);

        // testing filtering by expiry date:
        ArrayList<InsurancePolicy> testListDate = company.filterByExpiryDate(1, date4);
        InsurancePolicy.printPolicies(testListDate);

        // testing filtering by car model:
        ArrayList<InsurancePolicy> testListModel = company.filterByCarModel("Toyota Camry 2018");
        InsurancePolicy.printPolicies(testListModel);

        MyDate testDate = getDate();
        ArrayList<InsurancePolicy> testListDate2 = company.filterByExpiryDate(1, testDate);
        InsurancePolicy.printPolicies(testListDate2);

        User testUser = company.findUser(2);
        Address testAddress3 = getAddressOfUser();
        testUser.setAddress(testAddress3);
    }
}
