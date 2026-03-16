import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CompanyXYZ {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;
        Company xyz = new Company(); // INSTANTIATION OF THE COMPANY

        do {
            displayMainMenu();
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    xyz.addEmployee(employeeAddMenu()); // display employee add menu, feed result into add employee within company
                    break;
                case 2:
                    System.out.println("Enter employee id you want to remove: ");
                    Employee toDelete = xyz.findById(input.nextInt());
                    if (toDelete == null) {
                        System.out.println("Employee does not exist");
                        break;
                    }
                    else xyz.deleteEmployee(toDelete);
                    break;
                case 3:
                    xyz.reportAll();
                    break;
                case 4:
                    System.out.println("""
                    Employee Reporting
                    1. Full-Time Salaried
                    2. Full-Time Hourly
                    3. Part-Time""");
                    int reportChoice = input.nextInt();
                    switch(reportChoice){
                        case 1: xyz.reportByType(SalariedFull.class); break;
                        case 2: xyz.reportByType(HourlyFull.class); break;
                        case 3: xyz.reportByType(PartTime.class); break;
                        default: System.out.println("Not a valid choice"); break;
                    }
                    break;
                case 5:
                    System.out.println("Enter pay threshold: ");
                    xyz.reportByThreshold(input.nextDouble());
                    break;
                case 6:
                    xyz.exportEmployeeList();
                    break;
                case 7:
                    xyz.importEmployeeList();
                    break;
                case 8:
                    running = false;
                    break;
                default:

            }

        } while (running);

    }

    static void displayMainMenu() {
        System.out.println("""
                XYZ Employee Management
                1: Add New Employee
                2: Delete Employee
                3: Report All Employees
                4: Report All Employees By Type
                5: Report All Employees By Pay Threshold
                6: Export All Employees To File
                7: Import Employee List From File
                8: Quit""");
    }

    static Employee employeeAddMenu() { // boilerplate employee creation
        int id;
        String name, address;
        System.out.println("Enter id: ");
        id = input.nextInt();
        System.out.println("Enter name: ");
        name = input.next();
        input.nextLine();
        System.out.println("Enter address: ");
        address = input.nextLine();
        System.out.println("""
                Select employee type:
                1. Full Time - Salaried
                2. Full Time - Hourly
                3. Part Time""");
        int choice = input.nextInt();

        switch (choice) { // creation of the employee objects by type
            case 1: {
                double benefit;
                double salary;
                System.out.println("Enter benefit: ");
                benefit = input.nextDouble();
                input.nextLine();
                System.out.println("Enter salary: ");
                salary = input.nextDouble();
                input.nextLine();
                return new SalariedFull(id, name, address, benefit, salary);
            }
            case 2: {
                double benefit, hours, rate;
                System.out.println("Enter benefit: ");
                benefit = input.nextDouble();
                input.nextLine();
                System.out.println("Enter hours: ");
                hours = input.nextDouble();
                input.nextLine();
                System.out.println("Enter rate: ");
                rate = input.nextDouble();
                input.nextLine();
                return new HourlyFull(id, name, address, benefit, hours, rate);
            }
            case 3: {
                double hours, rate;
                System.out.println("Enter hours: ");
                hours = input.nextDouble();
                input.nextLine();
                System.out.println("Enter rate: ");
                rate = input.nextDouble();
                input.nextLine();
                return new PartTime(id, name, address, hours, rate);
            }
            default: System.out.println("Not a valid choice"); break;
        }
        return null;
    }
}

class Company {
    ArrayList<Employee> employees; // class has field named employees of type ArrayList<Employee>

    public Company() {
        employees = new ArrayList<>(); // explicit initialization of the arraylist "employees"
    }

    void addEmployee(Employee e) { // funneling of newly created employee into the company
        employees.add(e);
    }

    void deleteEmployee(Employee e) { // removing of employee from company
        employees.remove(e);
    }

    Employee findById(int id) {
        for(Employee employee : employees) {
            if (id == employee.id) {
                return employee;
            }
        }
        return null;
    }

    void reportAll() {
        for (Employee employee : employees) employee.display();
    }

    void reportByType(Class<?> type) {
        for (Employee employee : employees)
            if (type.isInstance(employee)) employee.display();
    }

    void reportByThreshold(double threshold) {
        for (Employee employee : employees)
            if (employee.calculatePay() > threshold) employee.display();
    }

    void exportEmployeeList() {
        try {
            FileWriter myWriter = new FileWriter("employees.txt");
            for (Employee employee : employees) {
                myWriter.write(employee.toFileString() + "\n");
            };
            myWriter.close();
            System.out.println("Successfully wrote to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void importEmployeeList(){
        File myObj = new File("employees.txt");

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                String type = parts[0];

                switch (type) {
                    case "SalariedFull":
                        employees.add(
                                new SalariedFull(
                                        Integer.parseInt(parts[1]),
                                        parts[2],
                                        parts[3],
                                        Double.parseDouble(parts[4]),
                                        Double.parseDouble(parts[5])
                                ));
                        break;
                    case "HourlyFull":
                        employees.add(
                                new HourlyFull(
                                        Integer.parseInt(parts[1]),
                                        parts[2],
                                        parts[3],
                                        Double.parseDouble(parts[4]),
                                        Double.parseDouble(parts[5]),
                                        Double.parseDouble(parts[6])
                                ));
                        break;
                    case "PartTime":
                        employees.add(
                                new PartTime(
                                        Integer.parseInt(parts[1]),
                                        parts[2],
                                        parts[3],
                                        Double.parseDouble(parts[4]),
                                        Double.parseDouble(parts[5])

                                ));
                        break;
                    default:
                        System.out.println("Not a known employee type"); break;
                }
            }
        } catch (FileNotFoundException e) {
            // PRINT GENERIC ERROR MESSAGE TO THE TERMINAL
            System.out.println("An error occurred.");
            // PRINT FULL STACK TRACE TO HELP DIAGNOSE THE PROBLEM
            e.printStackTrace();
        }

    }

}

class Employee {
    int id;
    String name;
    String address;

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public double calculatePay() { // later this could be replaced by an abstract class
        return 0.0;
    }

    public void display() {
        System.out.println("ID: " + id +
                "\nName: " + name +
                "\nAddress: " + address);
    }

    public String toFileString() {
        return id + "," + name + "," + address;
    }
}

class PartTime extends Employee {
    double hours;
    double rate;

    public PartTime(int id, String name, String address, double hours, double rate) {
        super(id, name, address);
        this.hours = hours;
        this.rate = rate;
    }

    public double calculatePay() {
        return hours * rate;
    }

    public void display() {
        super.display();
        System.out.println("Hours: " + hours +
                "\nRate: " + rate + "\n");
    }

    public String toFileString() {
        return "PartTime," + super.toFileString() + "," + hours + "," + rate;
    }
}

class FullTime extends Employee {
    double benefit;

    public FullTime(int id, String name, String address, double benefit) {
        super(id, name, address);
        this.benefit = benefit;
    }

    public void display() {
        super.display();
        System.out.println("Benefit: " + benefit);
    }

    public String toFileString() {
        return super.toFileString() + "," + benefit;
    }
}

class SalariedFull extends FullTime {
    double salary;

    public SalariedFull(int id, String name, String address, double benefit, double salary) {
        super(id, name, address, benefit);
        this.salary = salary;
    }

    public double calculatePay() {
        return salary + benefit;
    }

    public void display() {
        super.display();
        System.out.println("Salary: " + salary + "\n");
    }

    public String toFileString() {
        return "SalariedFull," + super.toFileString() + "," + salary;
    }
}

class HourlyFull extends FullTime {
    double hours;
    double rate;

    public HourlyFull(int id, String name, String address, double benefit, double hours, double rate) {
        super(id, name, address, benefit);
        this.hours = hours;
        this.rate = rate;
    }

    public double calculatePay() {
        return benefit + (hours * rate);
    }

    public void display() {
        super.display();
        System.out.println("Hours: " + hours +
                "\nRate: " + rate + "\n");

    }

    public String toFileString() {
        return "HourlyFull," + super.toFileString() + "," + hours + "," + rate;
    }
}