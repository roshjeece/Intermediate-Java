public class RecursiveAddDigits {
    public static void main(String[] args) {
//        write a program that will accept a number and then recursively add all its digits
        System.out.println(addDigits(1234));

    }
    public static int addDigits(int num) {

        // BASE CASE
        if (num == 0)
            return 0;

        // Recursive Case -- Express problem in term of itself
        return num%10 + addDigits(num/10); // extract last digit, add remaining

    }
}