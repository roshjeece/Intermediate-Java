public class Main {
    public static void main(String[] args) {

    }
}


abstract class Base {
    abstract public void func1();
    abstract public void func2();
    abstract public void func3();
}

abstract class Child extends Base {

    public void func1(){

    }
}

abstract class GrandChild extends Child {
    public void func2(){

    }

}

class GreatGrandChild extends GrandChild {
    public void func3() {

    }
}