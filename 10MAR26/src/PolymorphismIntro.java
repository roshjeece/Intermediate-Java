public class PolymorphismIntro {
    public static void main(String[] args) {

        Vehicle v = new Vehicle();
        Car c = new Car();
        Hybrid h = new Hybrid();
        Vehicle n = new Hybrid(); // This will output as hybrid

        h.display();
    }

}

class Vehicle {
    public void display(){
        System.out.println("I am in the parent");
    }
}

class Car extends Vehicle {

    public void display(){
        System.out.println("in the car display");
    }
}

class Hybrid extends Car {
    public void display(String s) {
        System.out.println("I am in the hybrid display");
    }
}