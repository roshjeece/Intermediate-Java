import java.util.Scanner;

public class IterativeFibonacci {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the # of the fibonacci sequence you wish to see: ");

        int seq = input.nextInt();
        int left = 0;
        int right = 1;

        for(int i = 0; i < seq; i++) {
            int next = left + right;
            left = right;
            right = next;
        }

        System.out.println(right);

    }
}