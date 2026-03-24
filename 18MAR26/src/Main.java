import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();

        int n = 5;
        // push disks onto A (largest first so smallest is on top)
        for (int i = n; i >= 1; i--) a.push(i);

        ToH(n, a, c, b, () -> System.out.println("A: " + a + " B: " + b + " C: " + c));

    }

    public static void ToH(int n, Stack<Integer> src, Stack<Integer> dst, Stack<Integer> aux, Runnable print){

        if (n==0) return;

        ToH(n-1, src, aux, dst, print); // (n-1, a, b, c)
        dst.push(src.pop());
        print.run();


        System.out.println("-----");
        ToH(n-1, aux, dst, src, print); // (n-1, b, c, a)

    }
}