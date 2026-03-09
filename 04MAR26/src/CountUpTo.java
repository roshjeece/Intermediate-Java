public class CountUpTo {
    public static void main (String[] args) {

        int current = 0;
        int target = 5;
        countUp(target, current);

    }

    public static int countUp(int target, int current) {

        // BASE CASE
        if (current > target)
            return target;


        // RECURSIVE CASE
        System.out.println(current);
        return (countUp(target, current + 1));
    }

}