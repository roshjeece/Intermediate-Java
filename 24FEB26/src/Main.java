import java.util.Scanner;

public class Main {

    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 0;
        boolean running = true;

        System.out.println("Enter count of employees: ");
        int size = input.nextInt(); // Size of array
        Employee[] employees = new Employee[size];

        do{
            displayMenu();
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();

            switch(choice){
                case 1:
                    count = addEmployees(count, size, employees);
                    break;
                case 2:
                    employeeAverages(employees, count);
                    break;
                    // The limitations of this enhanced for loop is that you can only step through in one direction
                case 3:
                    threshold(employees, count);
                    break;

                case 4:
                    System.out.println("Quitting!");
                    running = false;
                    break;

                default: System.out.println("Invalid input...");

            }
        }while(running);

    }

    static void displayMenu() {
        System.out.println("""
                Employee Management
                Enter 1 to add all employees
                Enter 2 to average and salary of all employees
                Enter 3 to find all employees above a specified age
                Enter 4 to quit""");
    }

    static int addEmployees(int count, int size, Employee[] employees) {
        if (count >= size) {
            System.out.println("All employees have already been added.");
            return count;
        }
        while (count < size) {
            System.out.println("Enter age: ");
            int age = input.nextInt();

            System.out.println("Enter salary: ");
            double salary = input.nextDouble();
            input.nextLine();

            employees[count++] = new Employee(age, salary); // Added ++ as an improvement to simplify
        }


        return count;
    }

    static void employeeAverages(Employee[] employees, int count) {
        if (count == 0){
            System.out.println("No employees have been added yet");
            return;
        }

        double totalAge = 0;
        double totalSalary = 0;
        for(int i = 0; i < count; i++) { // This declares the loop variable as an Employee (x), and iterates over the array
            totalAge += employees[i].getAge();
            totalSalary += employees[i].getSalary();
        }

        System.out.println("The average age is: " + totalAge / count);
        System.out.println("The average salary is: " + totalSalary / count);
    }

    static void threshold(Employee[] employees, int count) {
        if (count == 0) {
            System.out.println("No employees have been added yet.");
            return;
        }

        System.out.println("What age do you want to consider?");
        int ageThreshold = input.nextInt();
        System.out.println("What salary do you want to consider?");
        double salaryThreshold = input.nextDouble();
        input.nextLine();

        for(int i = 0; i < count; i++) {
            if (employees[i].getAge() >= ageThreshold && employees[i].getSalary() >= salaryThreshold)
                System.out.println(employees[i]);
        }
    }

}