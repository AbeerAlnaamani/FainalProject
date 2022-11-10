import java.io.FileNotFoundException;
import java.util.Scanner;

public class View {
    Management m;
    Scanner in;

    public View() throws FileNotFoundException {
        m = new Management();
        in = new Scanner(System.in);
    }

    public void start() throws FileNotFoundException {
        int num, num2;
        System.out.println("select entry type\n1-Admen\n2-casher");
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        if (num == 1) {
            System.out.println("select entry type\n1-Salaried Employee\n2-HourlyEmployee");
            num2 = in.nextInt();
            if (num2 == 1) {
                System.out.println("_________________________");
                System.out.println("    Salaried  Employees System");
                System.out.println("_________________________");

                while (true) {
                    System.out.println("1: Add New Employees \t\t2:View All Employees\n" +
                            "3: search For Employees\t\t4:Delete Employees\n0:Exit");
                    int choice = in.nextInt();
                    if (choice == 1)
                        addNewEmployees();
                    if (choice == 2)
                        view();
                    if (choice == 3)
                        find();
                    if (choice == 4)
                        delete();
                    if (choice == 0) {
                        m.writeEmployeesFile();
                        System.out.println("Good Bye");
                        System.exit(0);
                    }
                }
            }
            if (num2 == 2) {
                System.out.println("_________________________");
                System.out.println("    Hourly  Employees System");
                System.out.println("_________________________");

                while (true) {
                    System.out.println("1: Add New Employees \t\t2:View All Employees\n" +
                            "3: search For Employees\t\t4:Delete Employees\n0:Exit");
                    int choice = in.nextInt();
                    if (choice == 1)
                        addNewEmployeesH();
                    if (choice == 2)
                        viewH();
                    if (choice == 3)
                        findH();
                    if (choice == 4)
                        deleteH();
                    if (choice == 0) {
                        m.writeEmployeesHFile();
                        System.out.println("Good Bye");
                        System.exit(0);
                    }
                }
            } else System.out.println("Wrong number,enter again");
        }
        if (num == 2) {
            System.out.println("_________________________");
            System.out.println("    products System");
            System.out.println("_________________________");

            while (true) {
                System.out.println("1: Add New Producer \t\t2:View All products\n" +
                        "3: search For Producer\t\t4:Delete Producer\n0:Exit");
                int choice = in.nextInt();
                if (choice == 1)
                    addNewflavor();
                if (choice == 2)
                    viewF();
                if (choice == 3)
                    findF();
                if (choice == 4)
                    deleteF();
                if (choice == 0) {
                    m.writeflavorFile();
                    System.out.println("Good Bye");
                    System.exit(0);
                }
            }
        } else System.out.println("Wrong number,enter again");

    }

        public void addNewEmployees () {
            int id, TelephoneNumber;
            String fname, lName;
            double annualSalary;
            System.out.println("ID\tFirst Name\tLast Name\tTelephone Number\tSalary");
            id = in.nextInt();
            fname = in.next();
            lName = in.next();
            TelephoneNumber = in.nextInt();
            annualSalary = in.nextDouble();
            boolean duplicated = m.checkForDuplicate(new SalariedEmployee(id, fname, lName, TelephoneNumber, annualSalary) {
            //    @Override
              //  public double calculateSalary() {
                //    return 0;
               // }
            });
            if (duplicated)
                System.out.println("there is already Employees with this data");
            else {
                boolean added = m.addNewEmployees(id, fname, lName, TelephoneNumber, annualSalary);
                if (added)
                    System.out.println("added successfully");
                else
                    System.out.println("too mutch Employees ");
            }
        }

        public void view () {
            SalariedEmployee[] all = m.viewAllEmployees();
            System.out.println("ID\tFirst Name\tLast Name\tTelephone Number\tSalary");
            for (int i = 0; i < all.length; i++) {
                if (all[i] != null) {
                    System.out.println(all[i].toString());
                }
            }
        }

        public void find () {
            System.out.println(" input Employees ID to find");
            int id = in.nextInt();
            SalariedEmployee e = m.searchForEmployees(id);
            if (m != null) {
                System.out.println(e.getId() + "\t" + e.getfName()
                        + "\t" + e.getlname() + "\t" + e.getTelephoneNumber() + "\t" + e.getAnnualSalary());
            } else
                System.out.println("no Employee with this ID");
        }

        public void delete () {
            System.out.println("input Employee ID to delete");
            int id = in.nextInt();
            boolean deleted = m.deleteEmployees(id);

            if (deleted)

                System.out.println("deleted successfully");
            else
                System.out.println("no Student with this ID");

        }
        //////////////////////////////////////////////////////////////////
        public void addNewEmployeesH() {
            int id, TelephoneNumber;
            String fname, lName;
            double numOfHours, price;
            System.out.println("ID\tFirst Name\tLast Name\tTelephone Number\tnum Of Hours\tprice");
            id = in.nextInt();
            fname = in.next();
            lName = in.next();
            TelephoneNumber = in.nextInt();
            numOfHours = in.nextDouble();
            price = in.nextDouble();
            boolean duplicated = m.checkForDuplicate(new HourlyEmployee(id, fname, lName, TelephoneNumber, numOfHours, price) {
//            @Override
//            public double calculateSalary() {
//                return 0;
//            }
            });
            if (duplicated)
                System.out.println("there is already Employees with this data");
            else {
                boolean added = m.addNewEmployeesH(id, fname, lName, TelephoneNumber, numOfHours, price);
                if (added)
                    System.out.println("added successfully");
                else
                    System.out.println("too mutch Employees ");
            }
        }

        public void viewH() {
            HourlyEmployee[] all = m.viewAllEmployeesH();
            System.out.println("ID\tFirst Name\tLast Name\tTelephone Number\tnum Of Hours\tprice");
            for (int i = 0; i < all.length; i++) {
                if (all[i] != null) {
                    System.out.println(all[i].toString());
                }
            }
        }

        public void findH() {
            System.out.println(" input Employees ID to find");
            int id = in.nextInt();
            HourlyEmployee h = m.searchForEmployeesH(id);
            if (m != null) {
                System.out.println(h.getId() + "\t" + h.getfName()
                        + "\t" + h.getlname() + "\t" + h.getTelephoneNumber() + "\t" + h.getNumOfHours() + "\t" + h.getPrice());
            } else
                System.out.println("no Employee with this ID");
        }

        public void deleteH() {
            System.out.println("input Employee ID to delete");
            int id = in.nextInt();
            boolean deleted = m.deleteEmployeesH(id);

            if (deleted)

                System.out.println("deleted successfully");
            else
                System.out.println("no Student with this ID");

        }
        ///////////////////////////////////////////////////////////////////////////////////////

        public void addNewflavor() {
            int idF;
            String lavorss;
            double price;
            System.out.println("ID\tFlavor name\tprice");
            idF = in.nextInt();
            lavorss = in.next();
            price = in.nextDouble();
            FlavorAndPrice x= new FlavorAndPrice(idF, lavorss, price);
            boolean duplicated = m.checkForDuplicate(x);

            if (duplicated)
                System.out.println("there is already producer with this data");
            else {
                boolean added = m.addflavor(idF, lavorss, price);
                if (added)
                    System.out.println("added successfully");
                else
                    System.out.println("too much Employees ");
            }
        }

        public void viewF() {
            FlavorAndPrice[] all = m.viewAllflavor();
            System.out.println("ID\tFlavor name\tprice");
            for (int i = 0; i < all.length; i++) {
                if (all[i] != null) {
                    System.out.println(all[i].toString());
                }
            }
        }

        public void findF() {
            System.out.println(" input flavor ID to find");
            int idF = in.nextInt();
            FlavorAndPrice f = m.searchForflavor(idF);
            if (m != null) {
                System.out.println(f.getidF() + "\t" + f.getLavorss()
                        + "\t" + f.getPrice());
            } else
                System.out.println("no producer with this ID");
        }

        public void deleteF() {
            System.out.println("input producer ID to delete");
            int idF = in.nextInt();
            boolean deleted = m.deleteflavor(idF);

            if (deleted)

                System.out.println("deleted successfully");
            else
                System.out.println("no producer with this ID");

        }


    }







