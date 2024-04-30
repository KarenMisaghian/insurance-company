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
        if(policy == null) {
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

        addAccountToUser(user1, comprehensivePolicy2);
        addAccountToUser(user1, comprehensivePolicy1);
        addAccountToUser(user1, thirdPartyPolicy1);
        addAccountToUser(user1, thirdPartyPolicy2);

        user1.print();

        System.out.println(user1);

        InsurancePolicy searchedPolicy1 = findPolicy(user1, 5); //false id case...
        InsurancePolicy searchedPolicy2 =findPolicy(user1, 2); //valid id case...

        searchedPolicy2.print();
        searchedPolicy2.carPriceRise(0.1);
        searchedPolicy2.print();

        String newName = "Robert";
        searchedPolicy2.setPolicyHolderName(newName);

        String newModel = "Toyota Camry 2018";
        searchedPolicy2.setCarModel(newModel);

        String newCity = "Wollongong";
        user1.setCity(newCity);

        Address testAddress = getAddressOfUser();
        user1.setAddress(testAddress);

        System.out.println(user1);

        System.out.println("total premium is: " + user1.calcTotalPremiums(flatRate));

        user1.carPriceRiseAll(0.1);

        System.out.println("new total premium is: " + user1.calcTotalPremiums(flatRate));
        

        String model = getCarModel();
        ArrayList<InsurancePolicy> filteredPolicies = user1.filterByCarModel(model);

        InsurancePolicy.printPolicies(filteredPolicies);
    }
}
