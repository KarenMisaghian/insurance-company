public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDateValue() {
        return (this.year * 365) + (this.month * 30) + this.day; 
    }

    public Boolean isExpired(MyDate expiryDate) {
        int valueOfDate = this.getDateValue();
        int valueOfExpiryDate = expiryDate.getDateValue();
        return (valueOfDate < valueOfExpiryDate);
    }
}
