package lab;

import java.util.ArrayList;

import lab.Car.CarType;

public class App {
    public static final int flatRate = 100;

    public static void main(String[] args) {
        Car carOfFirstCostumer = new Car("something", 100, 2024, CarType.SED);
        ThirdPartyPolicy firstThirdPartyCase = new ThirdPartyPolicy("Karen", 1, carOfFirstCostumer, 2,
                "some dummy comment");
        Car carOfSecondCostumer = new Car("something else", 150, 2023, CarType.HATCH);
        ComprehensivePolicy firstComprehensiveCase = new ComprehensivePolicy("Karen2", 2, carOfSecondCostumer, 0, 18,
                1);

        ArrayList<InsurancePolicy> policies = new ArrayList<>();
        policies.add(firstComprehensiveCase);
        policies.add(firstThirdPartyCase);

        for (InsurancePolicy policy : policies)
            policy.printAttributes();

        for (InsurancePolicy policy : policies)
            System.out.println(policy);

        double totalPayment = 0;
        for (InsurancePolicy policy : policies)
            totalPayment += policy.calculatePayment(flatRate);

        System.out.println("The total payment is: " + totalPayment + " $");
    }
}
