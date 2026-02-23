import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int employeeCount = 0;
        int userChoice;
        int firstEmployee, secondEmployee, thirdEmployee, fourthEmployee, fifthEmployee;

        System.out.println("""
                Employee Management
                Enter 1 to add an employee
                Enter 2 to average the age of 1-5 employees
                Enter 3 to find all employees above a specified age
                Enter 4 to quit""");

        userChoice = input.nextInt();

        switch (userChoice) {
            case 1:
                enterAge(employeeCount);
                break;
            case 2:
                averageAge();
                break;
            case 3:
                employeesAboveAge();
                break;
        }



    }


    static int enterAge(int employeeCount) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the age of your employee: ");
        while (employeeCount <= 5) {
            switch (employeeCount) {
                case 0:
                    employeeCount--;

            }
        }

    }

    static void averageAge() {

    }
    static void employeesAboveAge() {

    }
}
