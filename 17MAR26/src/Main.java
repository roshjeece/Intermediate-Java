public class Main {
    public static void main(String[] args) throws MyException {

        throw new MyException("This is my exception");

    }


    public static class MyException extends Exception {
        public MyException(String message) {  // constructor: no return type, capital M
            super(message);
        }
    }
}