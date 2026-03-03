public class RecursiveFibonacci {
    public static void main (String[] args) {
        System.out.println(fibRec(4));

    }

    public static int fibRec(int n) {
        if (n==0)
            return 1; // BASE CASE ("bottom of the stack")
        if (n==1)
            return 1; // BASE CASE ("bottom" of the stack")

        return fibRec(n-1)+fibRec(n-2);
        // This whole thing is a sum on the outside. Within, the stack "unwinds" from 4 until it hits a base case, then bubbles back up
        // and adds it all together

    }
}
