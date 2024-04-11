package lab;

public class Car {
    public enum CarType {
        SUV,
        HATCH,
        SED,
        LUX
    }

    private String model;
    private double price;
    private int manufacturingYear;
    private CarType carType;

    public Car(String model, double price, int manufacturingYear, CarType carType) {
        this.carType = carType;
        this.manufacturingYear = manufacturingYear;
        this.model = model;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return " Model: " + model + " Price: " + price + " Type of car: " + carType + " Manufacturing year: "
                + manufacturingYear;
    }

    public void print() {
        System.out.print(" Model: " + model + " Price: " + price + " Type of car: " + carType
                + " Manufacturing year: " + manufacturingYear);
    }
}
