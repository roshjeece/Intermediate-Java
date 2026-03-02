import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter number of students: ");
        int size = input.nextInt();
        Student[] students = new Student[size];

        addStudents(size, students);
        sortStudents(students);
        binaryAgeSearch(students);

    }

    static void addStudents(int size, Student[] students) {
        int count = 0;

        while (count < size) {
            System.out.println("Enter age: ");
            int age = input.nextInt();

            System.out.println("Enter GPA: ");
            double gpa = input.nextDouble();
            input.nextLine();

            students[count++] = new Student(age, gpa);
        }

    }

    static void sortStudents(Student[] students) {


        for (int pass = 0; pass < students.length - 1; pass++) {
            for (int i = 0; i < students.length - 1 - pass; i++) {
                if (students[i].getAge() > students[i+1].getAge()) {
                    Student temp = students[i];
                    students[i] = students[i+1];
                    students[i+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(students));
    }

    static void binaryAgeSearch(Student[] students) {
        System.out.println("What age do you want to search for: ");
        int targetAge = input.nextInt();

        int lowIndex = 0;
        int highIndex = students.length - 1;

        while (lowIndex <= highIndex) {
            int midIndex = lowIndex + (highIndex - lowIndex) / 2;
            int guessNumber = students[midIndex].getAge();

            if (guessNumber == targetAge) {
                System.out.println("Found at index: " + midIndex);
                return;
            }

            else if (guessNumber > targetAge) {
                highIndex = midIndex - 1;
            }

            else {
                lowIndex = midIndex + 1;
            }
        }
        System.out.println("Not found");
    }

}
