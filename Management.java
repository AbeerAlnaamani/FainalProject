import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Management {
    public String name="1";
    public String pass="1";


    private SalariedEmployee[] allEmployees;
    private HourlyEmployee[] allEmployeesH;

    private FlavorAndPrice [] alllavorss;
    private int numOfEmployees;
    private int numOfEmployeesH;

    private int numOflavorss;

    public Management() throws FileNotFoundException {

        allEmployees = new SalariedEmployee[100];
    //    numOfEmployees = 0;
        readEmployeesFile();
       // writeEmployeesFile();

        allEmployeesH = new HourlyEmployee[100];
        //numOfEmployees = 0;
        readEmployeesHFile();
       // writeEmployeesHFile();

        alllavorss = new FlavorAndPrice[100];
        numOflavorss= 0;
        readflavorFile();
       // writeflavorFile();
    }

    public boolean addNewEmployees(int id, String fName, String lName, int telephoneNumber, double annualSalary) {
        if (numOfEmployees < allEmployees.length) {
            SalariedEmployee e = new SalariedEmployee(id, fName, lName, telephoneNumber, annualSalary);
            allEmployees[numOfEmployees] = e;
            numOfEmployees++;
            Employees.counter++;
            Arrays.toString(allEmployees);
            return true;
        } else
            return false;
    }
    public boolean addNewEmployeesH(int id, String fName, String lName, int telephoneNumber, double numOfHours,double price) {
        if (numOfEmployees < allEmployeesH.length) {
            HourlyEmployee h = new HourlyEmployee(id, fName, lName, telephoneNumber, numOfHours,price);
            allEmployeesH[numOfEmployeesH] = h;
            numOfEmployeesH++;
            Employees.counter++;
            return true;
        } else
            return false;
    }
    public boolean addflavor(int idF, String lavorss, double price) {
        if (numOflavorss < alllavorss.length) {
            FlavorAndPrice f = new FlavorAndPrice(idF, lavorss, price);
            alllavorss[numOflavorss] = f;
            numOflavorss++;
            FlavorAndPrice.counter1++;
            return true;
        } else
            return false;
    }
    public SalariedEmployee[] viewAllEmployees() {
        return allEmployees;
    }
    public HourlyEmployee[] viewAllEmployeesH() {
        return allEmployeesH;
    }

    public FlavorAndPrice[] viewAllflavor() {
        return alllavorss;
    }

    public SalariedEmployee searchForEmployees(int id) {
        boolean found = false;
        int i = 0;
        while (!found && i < allEmployees.length) {
            if(allEmployees[i]!=null) {
                if (allEmployees[i].getId() == id)
                    found = true;
                else i++;
            }
            else
                i++;
        }
        if (i < allEmployees.length)
            return allEmployees[i];
        else
            return null;
    }

    public int searchForEmployeesIndex(int id) {
        boolean found = false;
        int i = 0;
        while (!found && i < allEmployees.length) {
            if (allEmployees[i].getId() == id)
                found = true;
            else
                i++;
        }
        if (i < allEmployees.length)
            return i;
        else
            return -1;
    }
    public HourlyEmployee searchForEmployeesH(int id) {
        boolean found = false;
        int i = 0;
        while (!found && i < allEmployeesH.length) {
            if (allEmployeesH[i].getId() == id)
                found = true;
            else
                i++;
        }
        if (i < allEmployeesH.length)
            return allEmployeesH[i];
        else
            return null;
    }

    public int searchForEmployeesHIndex(int id) {
        boolean found = false;
        int i = 0;
        while (!found && i < allEmployeesH.length) {
            if (allEmployeesH[i].getId() == id)
                found = true;
            else
                i++;
        }
        if (i < allEmployeesH.length)
            return i;
        else
            return -1;
    }

    public FlavorAndPrice searchForflavor(int idF) {
        boolean found = false;
        int i = 0;
        while (!found && i < alllavorss.length) {
            if(alllavorss[i]!=null) {
                if (alllavorss[i].getidF() == idF)
                    found = true;
                else i++;
            }
            else
                i++;
        }
        if (i < alllavorss.length)
            return alllavorss[i];
        else
            return null;
    }

    public int searchForflavorIndex(int idF) {
        boolean found = false;
        int i = 0;
        while (!found && i < alllavorss.length) {
            if (alllavorss[i].getidF() == idF)
                found = true;
            else
                i++;
        }
        if (i < alllavorss.length)
            return i;
        else
            return -1;
    }

    public boolean deleteEmployees(int id) {
        int index = searchForEmployeesIndex(id);
        if (index != -1) {
            allEmployees[index] = null;
            return true;

        } else
            return false;

    }
    public boolean deleteEmployeesH(int id) {
        int index = searchForEmployeesHIndex(id);
        if (index != -1) {
            allEmployeesH[index] = null;
            return true;

        } else
            return false;

    }

    public boolean deleteflavor(int idF) {
        int index = searchForflavorIndex(idF);
        if (index != -1) {
            alllavorss[index] = null;
            return true;

        } else
            return false;

    }
    public boolean checkForDuplicate(SalariedEmployee e) {
        for (int i = 0; i < numOfEmployees; i++) {
            if (Objects.equals(allEmployees[i], e))
                return true;
        }
        return false;
    }
    public boolean checkForDuplicate(HourlyEmployee h) {
        for (int i = 0; i < numOfEmployeesH; i++) {
            if (allEmployeesH[i].equals(h))
                return true;
        }
        return false;
    }

    public boolean checkForDuplicate(FlavorAndPrice f) {
        for (int i = 0; i < numOflavorss; i++) {
            if (Objects.equals(alllavorss[i], f))
                return true;
        }
        return false;
    }
    public void readEmployeesFile() throws FileNotFoundException {
        Scanner in = new Scanner(new File("D:\\EmployeesFile.txt"));
        in.useLocale(Locale.US);
        while (in.hasNext()) {
            int i = in.nextInt();
            String f = in.next();
            String l = in.next();
            int t = in.nextInt();
            double a = in.nextDouble();
            addNewEmployees(i, f, l,  t,a);
        }
        in.close();
    }
    public void readEmployeesHFile() throws FileNotFoundException {
        Scanner in = new Scanner(new File("D:\\EmployeesHFile.txt"));
        in.useLocale(Locale.US);
        while (in.hasNext()) {
            int i = in.nextInt();
            String f = in.next();
            String l = in.next();
            int t = in.nextInt();
            double n = in.nextDouble();
            double p = in.nextDouble();
            addNewEmployeesH(i, f, l,t,n,p);
        }
        in.close();
    }

    public void readflavorFile() throws FileNotFoundException {
        Scanner in = new Scanner(new File("D:\\flavor.txt"));
        in.useLocale(Locale.US);
        while (in.hasNext()) {
            int i = in.nextInt();
            String f = in.next();
            double p = in.nextDouble();
            addflavor(i, f, p);
        }
        in.close();
    }

    public void writeEmployeesFile() throws FileNotFoundException {
        PrintWriter w = new PrintWriter(new File("D:\\EmployeesFile.txt"));
        for (int i = 0; i < numOfEmployees; i++) {
            if(allEmployees[i]!=null)
            w.write(allEmployees[i].getId() + " " + allEmployees[i].getfName() + " " +
                    allEmployees[i].getlname() + " " + allEmployees[i].getTelephoneNumber() + " "+allEmployees[i].getAnnualSalary()+"\n");

        }
        w.close();
    }
    public void writeEmployeesHFile() throws FileNotFoundException {
        PrintWriter w = new PrintWriter(new File("D:\\EmployeesHFile.txt"));
        for (int i = 0; i < numOfEmployeesH; i++) {
            if(allEmployeesH[i]!=null)
            w.write(allEmployeesH[i].getId() + " " + allEmployeesH[i].getfName() + " " +
                    allEmployeesH[i].getlname() + " " + allEmployeesH[i].getTelephoneNumber() + " "+
                    allEmployeesH[i].getNumOfHours()+ " " + allEmployeesH[i].getPrice()+ "\n"
            );

        }
        w.close();
    }

    public void writeflavorFile() throws FileNotFoundException {
        PrintWriter w = new PrintWriter(new File("D:\\flavor.txt"));
        for (int i = 0; i < numOflavorss; i++) {
            if(alllavorss[i]!=null)
            w.write(alllavorss[i].getidF() + " " + alllavorss[i].getLavorss() + " " +
                    alllavorss[i].getPrice() +"\n");

        }
        w.close();
    }

}

