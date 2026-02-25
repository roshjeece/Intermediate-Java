```Java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] x = {3, 10, 20, 40};

        // System.out.print(x[0]); --> prints '3'


        for(int i=0; i<x.length; i++) // --> prints 3, 10, 20, 40
            System.out.println(x[i]);

        x[0] = 100;

        for(int i=0; i<x.length; i++)
            System.out.println(x[i]);

        x[4] = 10; // Once you define a variable, you cannot touch it

    }
}
```