import java.util.Scanner;

public class Cohort {

    public static final Scanner input = new Scanner(System.in);
    private final Employee[] employees;
    private int count;
    private final int size;

    public Cohort(int size) {
        this.size = size;
        this.employees = new Employee[size];
        this.count = 0;
    }

    public void displayMenu() {
        System.out.println("""
                Employee Management
                Enter 1 to add all employees
                Enter 2 to average age and salary of all employees
                Enter 3 to find all employees above a specified age and salary
                Enter 4 to quit""");
    }

    public void addEmployees() {
        if (count >= size) {
            System.out.println("All employees have already been added.");
            return;
        }
        while (count < size) {
            System.out.println("Enter age: ");
            int age = input.nextInt();

            System.out.println("Enter salary: ");
            double salary = input.nextDouble();
            input.nextLine();

            employees[count++] = new Employee(age, salary);
        }
    }

    public void employeeAverages() {
        if (count == 0) {
            System.out.println("No employees have been added yet.");
            return;
        }
        double totalAge = 0;
        double totalSalary = 0;
        for (int i = 0; i < count; i++) {
            totalAge += employees[i].getAge();
            totalSalary += employees[i].getSalary();
        }
        System.out.println("The average age is: " + totalAge / count);
        System.out.println("The average salary is: " + totalSalary / count);
    }

    public void threshold() {
        if (count == 0) {
            System.out.println("No employees have been added yet.");
            return;
        }
        System.out.println("What age do you want to consider?");
        int ageThreshold = input.nextInt();
        System.out.println("What salary do you want to consider?");
        double salaryThreshold = input.nextDouble();
        input.nextLine();

        for (int i = 0; i < count; i++) {
            if (employees[i].getAge() >= ageThreshold && employees[i].getSalary() >= salaryThreshold)
                System.out.println(employees[i]);
        }
    }
}