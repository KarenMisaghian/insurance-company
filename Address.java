public class Address {
    private int streetNum;
    private String street;
    private String suburb;
    private String city;

    public Address(int streetNum, String street, String suburb, String city) {
        this.city = city;
        this.street = street;
        this.streetNum = streetNum;
        this.suburb = suburb;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public String getSuburb() {
        return suburb;
    }
    
    public void print() {
        System.out.print("Street number: " + this.streetNum + "City: " + this.city + "Suburb: " + this.suburb
                + "Street number: " + this.streetNum);
    }

    public String toString() {
        return "Street number: " + this.streetNum + "City: " + this.city + "Suburb: " + this.suburb
                + "Street number: " + this.streetNum;
    }
}
