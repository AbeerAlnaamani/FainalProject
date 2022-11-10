public  class SalariedEmployee extends Employees {
    private double annualSalary;

    public SalariedEmployee(int id, String fName, String lName, int TelephoneNumber, double annualSalary) {
        super(id, fName, lName, TelephoneNumber);
        this.annualSalary = annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }



    @Override
    public String toString() {
        return  super.toString()+"\t"+
                 annualSalary +
                "\n";
    }
}

