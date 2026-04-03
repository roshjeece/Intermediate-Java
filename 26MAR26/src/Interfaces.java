public class Interfaces {
    public static void main(String[] args) {

        Math.func2();
        System.out.println(Math.a);
    }
}

class Numbers extends ABC implements Math {

    public void add() {

    }


    public void sub() {

    }

    public void mul(){

    };

    public void div(){

    };

}

class ABC {
    private int a;

    @Override
    public String toString() {
        return "ABC{" +
                "a=" + a +
                '}';
    }
}

interface Math {

    int a = 10;

    public void add();

    public void sub();

    default void func1(){
        func2();
    }

    public static void func2(){
        System.out.println("hello");
    }
}