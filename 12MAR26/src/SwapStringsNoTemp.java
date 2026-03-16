public class SwapStringsNoTemp {
    public static void main(String[] args) {

        String x = "short";
        System.out.println("Variable x = " + x);
        String y = "IAMVERYLONG";
        System.out.println("Variable y = " + y);

        x += y;
        System.out.println(x);

        y = x.substring(0, x.length() - y.length());
        x = x.substring(y.length());

        System.out.println("Variable x = " + x);
        System.out.println("Variable y = " + y);

    }
}