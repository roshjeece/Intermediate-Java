public class RecursivePalindrome {
    public static void main(String[] args) {
        // check if a number is a palindrome recursively

        String input = String.valueOf(1331);
        boolean result = palRec(input);

        System.out.println("Input: " + input);
        System.out.println("Is palindrome? " + result);
    }

    public static boolean palRec(String s) {
        if (s.isEmpty())
            return true;
        if(s.length() == 1)
            return true;

        return ((s.charAt(0) == s.charAt(s.length() - 1)) && palRec((s.substring(1, s.length() - 1))));

        // if first and last are equal, then it's a palindrome if the middle is ok
    }
}
