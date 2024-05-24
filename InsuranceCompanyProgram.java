import java.util.ArrayList;

public class InsuranceCompanyProgram {
    public static void addAccountToUser(User user, InsurancePolicy policy) {
        if (user.addPolicy(policy)) {
            System.out.println("Policy added successfully!");
        } else {
            System.out.println("Policy not added!");
        }
    }

    public static void addUser(User user, InsuranceCompany company) {
        if (company.addUser(user))
            System.out.println("User added successfully!");
        else
            System.out.println("Adding user failed, try again...");
    }

    // lab 4:
    public static void testCopies(InsuranceCompany company) throws CloneNotSupportedException {
        Car car1 = new Car("207", 1000, 2024, CarType.SED);
        Car car2 = new Car("L90", 500, 2014, CarType.SED);
        Car car3 = new Car("2008", 2300, 2018, CarType.SUV);
        Car car4 = new Car("Sandro", 1000, 2018, CarType.SED);
        Car car5 = new Car("VolksWagen", 700, 2005, CarType.SED);
        Car car6 = new Car("S5", 1000, 2017, CarType.SUV);
        Car car7 = new Car("K7", 1700, 2024, CarType.SED);
        Car car8 = new Car("J7", 1700, 2024, CarType.SUV);
        Car car9 = new Car("K7", 1500, 2023, CarType.SED);
        Car car10 = new Car("L90", 600, 2017, CarType.SED);
        Car car11 = new Car("X33", 550, 2012, CarType.SUV);
        Car car12 = new Car("L90", 700, 2020, CarType.SED);
        Car car13 = new Car("207", 800, 2022, CarType.SED);

        Address address1 = new Address(4, "Hemmat", "Ghasrodasht", "Shiraz");
        Address address2 = new Address(23, "Azadi", "Azadi", "Yazd");
        Address address3 = new Address(15, "Daryush", "Daryush", "Kerman");
        Address address4 = new Address(7, "Eram", "Eram", "Rafsanjan");
        Address address5 = new Address(5, "Hor", "Arya", "Shiraz");

        User Karen = new User("Karen", address1, "1234");
        User Sahba = new User("Sahba", address1, "1234");
        User Pedram = new User("Pedram", address1, "1234");
        User Mahnaz = new User("Mahnaz", address2, "1234");
        User Pashootan = new User("Pashootan", address3, "1234");
        User Hooshang = new User("Hooshang", address4, "1234");
        User Nazila = new User("Nazila", address4, "1234");
        User Samira = new User("Samira", address2, "1234");
        User Pegah = new User("Pegah", address5, "1234");
        User Payam = new User("Payam", address5, "1234");

        MyDate date1 = new MyDate(2024, 5, 5);
        MyDate date2 = new MyDate(2024, 10, 10);
        MyDate date3 = new MyDate(2024, 8, 23);
        MyDate date4 = new MyDate(2024, 8, 23);
        MyDate date5 = new MyDate(2024, 5, 5);
        MyDate date6 = new MyDate(2024, 10, 10);
        MyDate date7 = new MyDate(2024, 12, 12);
        MyDate date8 = new MyDate(2024, 7, 7);
        MyDate date9 = new MyDate(2024, 6, 6);
        MyDate date10 = new MyDate(2025, 2, 2);
        MyDate date11 = new MyDate(2025, 3, 3);
        MyDate date12 = new MyDate(2024, 11, 11);
        MyDate date13 = new MyDate(2025, 1, 1);
        MyDate date14 = new MyDate(2024, 9, 9);
        MyDate date15 = new MyDate(2025, 2, 5);
        MyDate date16 = new MyDate(2025, 10, 10);

        InsurancePolicy policyOfKaren1 = new ComprehensivePolicy("Karen", 1, car1, 1, date1, 18, 1);
        InsurancePolicy policyOfKaren2 = new ThirdPartyPolicy("Karen", 2, car1, 0, date2, "first comment");
        InsurancePolicy policyOfPedram1 = new ThirdPartyPolicy("Pedram", 1, car2, 0, date3, "second comment");
        InsurancePolicy policyOfPedram2 = new ComprehensivePolicy("Pedram", 2, car1, 5, date4, 45, 5);
        InsurancePolicy policyOfPedram3 = new ComprehensivePolicy("Pedram", 3, car3, 2, date5, 45, 4);
        InsurancePolicy policyOfPedram4 = new ThirdPartyPolicy("Pedram", 4, car3, 0, date6, "third comment");
        InsurancePolicy policyOfMahnaz1 = new ComprehensivePolicy("Mahnaz", 1, car4, 1, date7, 70, 6);
        InsurancePolicy policyOfPashootan1 = new ThirdPartyPolicy("Pashootan", 1, car5, 0, date8, "forth comment");
        InsurancePolicy policyOfHooshang1 = new ThirdPartyPolicy("Hooshang", 1, car6, 2, date9, "fifth comment");
        InsurancePolicy policyOfHooshang2 = new ComprehensivePolicy("Hooshang", 2, car7, 4, date10, 70, 7);
        InsurancePolicy policyOfHooshang3 = new ThirdPartyPolicy("Hooshang", 3, car8, 3, date11, "sixth comment");
        InsurancePolicy policyOfHooshang4 = new ComprehensivePolicy("Hooshang", 4, car9, 0, date12, 70, 4);
        InsurancePolicy policyOfSamira1 = new ComprehensivePolicy("Samira", 1, car10, 1, date13, 40, 2);
        InsurancePolicy policyOfPegah1 = new ThirdPartyPolicy("Pegah", 1, car11, 7, date14, "7th comment");
        InsurancePolicy policyOfPayam1 = new ComprehensivePolicy("Payam", 1, car12, 10, date15, 37, 2);
        InsurancePolicy policyOfPayam2 = new ThirdPartyPolicy("Payam", 2, car13, 6, date16, "8th comment");

        addAccountToUser(Karen, policyOfKaren1);
        addAccountToUser(Karen, policyOfKaren2);
        addAccountToUser(Pedram, policyOfPedram1);
        addAccountToUser(Pedram, policyOfPedram2);
        addAccountToUser(Pedram, policyOfPedram3);
        addAccountToUser(Pedram, policyOfPedram4);
        addAccountToUser(Mahnaz, policyOfMahnaz1);
        addAccountToUser(Pashootan, policyOfPashootan1);
        addAccountToUser(Hooshang, policyOfHooshang1);
        addAccountToUser(Hooshang, policyOfHooshang2);
        addAccountToUser(Hooshang, policyOfHooshang3);
        addAccountToUser(Hooshang, policyOfHooshang4);
        addAccountToUser(Pegah, policyOfPegah1);
        addAccountToUser(Payam, policyOfPayam1);
        addAccountToUser(Payam, policyOfPayam2);
        addAccountToUser(Samira, policyOfSamira1);

        addUser(Karen, company);
        addUser(Pedram, company);
        addUser(Sahba, company);
        addUser(Mahnaz, company);
        addUser(Payam, company);
        addUser(Pashootan, company);
        addUser(Hooshang, company);
        addUser(Nazila, company);
        addUser(Samira, company);

        ArrayList<InsurancePolicy> shallowCopy = Karen.shallowCopyPolicies();
        ArrayList<InsurancePolicy> deepCopy = Karen.deepCopyPolicies();

        Karen.setCity("NewYork");
        InsurancePolicy policyOfKaren3 = new ThirdPartyPolicy("Karen", 3, car1, 4, date2, "first comment");
        addAccountToUser(Karen, policyOfKaren3);

        ArrayList<InsurancePolicy> sortedPolicy = Karen.sortPoliciesByDate();

        System.out.println("shallow copy list: ");
        for (InsurancePolicy policy : shallowCopy)
            System.out.println(policy);

        System.out.println("*******************************************************************");
        System.out.println("deep copy list: ");
        for (InsurancePolicy policy : deepCopy)
            System.out.println(policy);

        System.out.println("*******************************************************************");
        System.out.println("policies of user: ");
        for (InsurancePolicy policy : sortedPolicy)
            System.out.println(policy);

        ArrayList<User> usersShallowCopy = company.shallowCopyUsers();
        ArrayList<User> usersDeepCopy = company.deepCopyUsers();

        addUser(Pegah, company);

        ArrayList<User> users = company.sortUsers();

        System.out.println("*******************************************************************");
        System.out.println("shallow copy list: ");
        for (User user : usersShallowCopy)
            System.out.println(user);

        System.out.println("*******************************************************************");
        System.out.println("deep copy list: ");
        for (User user : usersDeepCopy)
            System.out.println(user);

        System.out.println("*******************************************************************");
        System.out.println("company users: ");
        for (User user : users)
            System.out.println(user);

        InsuranceCompany companyDeepCopy = company.clone();
        InsuranceCompany companyShallowCopy = company;
        company.addUser(new User("New User", address5, "12345"));

        System.out.println("*******************************************************************");
        System.out.println("original company: ");
        System.out.println(company);

        System.out.println("*******************************************************************");
        System.out.println("deep copy: ");
        System.out.println(companyDeepCopy);

        System.out.println("*******************************************************************");
        System.out.println("shallow copy: ");
        System.out.println(companyShallowCopy);
    }

    public static void main(String[] args) {
        InsuranceCompany company = new InsuranceCompany("HoomanCompany", "admin", "admin", 12);
        // UserInterface.mainMenu(insuranceCompany);
        try {
            testCopies(company);
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
    }
}
