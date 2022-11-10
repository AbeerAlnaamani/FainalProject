public class HourlyEmployee extends Employees {
    private double numOfHours,price;

    public HourlyEmployee(int id, String fName, String lName, int TelephoneNumber, double numOfHours, double price) {
        super(id, fName, lName,TelephoneNumber);
        this.numOfHours = numOfHours;
        this.price = price;
    }

    public double getNumOfHours() {
        return numOfHours;
    }

    public double getPrice() {
        return price;
    }

    public void setNumOfHours(double numOfHours) {
        this.numOfHours = numOfHours;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  super.toString()+"\t"+
                 numOfHours +"\t\t"+
                price +"\n" ;
    }


}

