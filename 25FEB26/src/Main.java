import java.util.Scanner;

public class Main {

    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Enter count of employees: ");
        int size = input.nextInt();
        Cohort cohort = new Cohort(size);

        do {
            cohort.displayMenu();
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    cohort.addEmployees();
                    break;
                case 2:
                    cohort.employeeAverages();
                    break;
                case 3:
                    cohort.threshold();
                    break;
                case 4:
                    System.out.println("Quitting!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input...");
            }
        } while (running);
    }
}