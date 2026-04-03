import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer[] unsortedArray = {10, 5, 7, 12, 3};
        bubbleSort(unsortedArray);

        String[] wordArray = {"Acura", "Toyota", "Nissan", "BMW"};
        bubbleSort(wordArray);

        Employee ceo = new Employee(20, 40);
        Employee loser = new Employee(50, 99);
        Employee middleman = new Employee(35, 70);

        Employee[] employees = {ceo, loser, middleman};
        bubbleSort(employees);
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {

        for (int x = 0; x < array.length - 1; x++) {
            for (int y = 0; y < array.length - 1 - x; y++){
                if (array[y].compareTo(array[y + 1]) > 0) {
                    T temp = array[y];
                    array[y] = array[y+1];
                    array[y+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

class Employee implements Comparable<Employee> {
    int age;
    int hours;

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", hours=" + hours +
                '}';
    }

    public Employee(int age, int hours) {
        this.age = age;
        this.hours = hours;
    }


    public int compareTo(Employee obj) {
        return age - obj.age;
    }
}