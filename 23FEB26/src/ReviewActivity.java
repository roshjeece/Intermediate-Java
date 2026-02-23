// Review Activity from End of Intro to Java Course:
// Utilizing switch, do-while loops, and overloaded functions
// Task was to create a program

import java.util.Scanner;

public class ReviewActivity {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double days;
        double rate;
        double charges;
        double meds;
        System.out.println("Hospital Stay Calculator. Enter '1' for inpatient or '2' for outpatient: ");

        int stayOption = input.nextInt();

        switch (stayOption) {
            case 1:
                System.out.println("Inpatient\n" +
                        "Enter days spent at hospital. ");
                days = userInputAndVerify();
                System.out.println("Enter the daily rate. ");
                rate = userInputAndVerify();
                System.out.println("Enter charges for hospital services. ");
                charges = userInputAndVerify();
                System.out.println("Enter medication charges. ");
                meds = userInputAndVerify();
                // Overloaded function call
                System.out.println("Total charge for inpatient stay: " + calculateCharges(days, rate, charges, meds));

                break;
            case 2:
                System.out.println("Outpatient\n" +
                        "Enter charges for hospital services.");
                charges = userInputAndVerify();
                System.out.println("Enter medication charges. ");
                meds = userInputAndVerify();
                System.out.println("Total charge for outpatient stay: " + calculateCharges(charges, meds));
                break;
            default:
                System.out.println("Not a valid entry.");
        }


    }

    public static double userInputAndVerify () {
        Scanner scanner = new Scanner(System.in);
        double input;
        do {
            System.out.println("Ensure you enter a non-negative value ( >= 0 ): ");
            input = scanner.nextDouble();
            scanner.nextLine();
        } while (input < 0);

        return input;
    }

    private static double calculateCharges(double days, double rate, double charges, double meds) {
        return ((days * rate) + charges + meds);
    }

    private static double calculateCharges(double charges, double meds) {
        return (charges + meds);
    }
}