import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do{
            System.out.println("What type of patient... 1 for in-patient, 2 for out-patient: ");
            choice = input.nextInt();
        }while((choice != 1) && (choice != 2));

        if(choice == 1)
            manageInPatient();
        else
            manageOutPatient();

    }

    public static void manageInPatient(){
        Scanner input = new Scanner(System.in);
        System.out.println("inpatient");
        int days;
        double dailyRate;
        double hospitalCharges;
        double hospitalMedication;

        do{
            System.out.print("Enter how many days: ");
            days = input.nextInt();
        }while(!validate(days));

        do{
            System.out.print("Enter how much is the daily rate: ");
            dailyRate = input.nextInt();
        }while(!validate(dailyRate));

        do{
            System.out.print("Enter the hospital charges: ");
            hospitalCharges = input.nextInt();
        }while(!validate(hospitalCharges));

        do{
            System.out.print("Enter the hospital medication: ");
            hospitalMedication = input.nextInt();
        }while(!validate(hospitalMedication));

        calculateCharges(days, dailyRate, hospitalCharges, hospitalMedication);
    }

    public static void manageOutPatient(){
        System.out.println("outpatient");
    }

    public static boolean validate(double num) {
        return num >= 0.0;
    }

    public static void calculateCharges(int days, double dailyRate, double hospitalCharges, double hospitalMedication){
        double totalCharges = days * dailyRate + hospitalCharges + hospitalMedication;

        System.out.println("Total charges is: " + totalCharges);
    }
}