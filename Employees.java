public abstract class   Employees {
    private int id;
    private String fName;
    private String lName;
    private int TelephoneNumber;

  //  public abstract double calculateSalary();
    public static int counter=0;

    public Employees(int id, String fName, String lName,  int telephoneNumber) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;

        this.TelephoneNumber = telephoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlname() {
        return lName;
    }



    public int getTelephoneNumber() {
        return TelephoneNumber;
    }

    public static int getCounter() {
        return counter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setLname(String lname) {
        this.lName = lname;
    }



    public void setTelephoneNumber(int telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }

    public static void setCounter(int counter) {
        Employees.counter = counter;
    }

    @Override
    public String toString() {
        return  id +
                "\t"+ fName + "\t" +
                 lName + "\t" +
                 TelephoneNumber +"\t"
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employee = (Employees) o;

        if (id != employee.id) return false;
        if (TelephoneNumber != employee.TelephoneNumber) return false;
        if (fName != null ? !fName.equals(employee.fName) : employee.fName != null) return false;
        return lName != null ? lName.equals(employee.lName) : employee.lName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + TelephoneNumber;

        return result;
    }



}

