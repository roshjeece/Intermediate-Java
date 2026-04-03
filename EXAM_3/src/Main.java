public class Main {
    public static void main(String[] args) {

        Integer[] unsortedNumArray = {5, 12, 83, 6, 59, 31, 74, 22, 90, 47};
        quickSort(unsortedNumArray, 0, unsortedNumArray.length - 1);

        String[] unsortedStringArray = {"Zulu", "Foxtrot", "Alpha", "Oscar", "Papa", "Victor"};
        quickSort(unsortedStringArray, 0, unsortedStringArray.length - 1);

        for (int j : unsortedNumArray) System.out.println(j);
        for (String j : unsortedStringArray) System.out.println(j);

        Employee emp1 = new Employee(20, "John");
        Employee emp2 = new Employee(50, "Paul");
        Employee emp3 = new Employee(35, "George");
        Employee emp4 = new Employee(67, "Ringo");

        Employee[] employees = {emp1, emp2, emp3, emp4};
        quickSort(employees, 0, employees.length - 1);

        for (Employee j : employees) System.out.println(j.toString());

    }

    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {

        // BASE CASE
        if (low >= high) return;

        T pivot = array[high];

        int i = low - 1;

        for(int j = low; j< high; j++) {
            if(array[j].compareTo(pivot) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        T temp = array[i];
        array[i] = array[high];
        array[high] = temp;

        quickSort(array, low, i - 1);
        quickSort(array, i + 1, high);
    }
}

class Employee implements Comparable<Employee> {
    int age;
    String name;


    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return age - o.age;
    }
}