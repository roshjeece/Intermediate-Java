import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        /*
        create an array list for students
        add some objects to it
        then sort based on age
         */

        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student(13, 2.00));
        students.add(new Student(15, 3.00));
        students.add(new Student(17, 4.00));
        students.add(new Student(19, 3.50));
        students.add(new Student(12, 3.70));
        students.add(new Student(16, 4.01));


        Collections.sort(students);

        System.out.println(students);

    }

}