public class Main {
    public static void main (String[] args) {
        Vehicle v = new Vehicle();
        Car c = new Car();
        Hybrid h = new Hybrid();

        System.out.println(v instanceof Vehicle);
    }
}

class Vehicle { // Parent class or Superclass


}

class Car extends Vehicle{ // Child class or Subclass, inherits all from the parent class


}

class Hybrid extends Car{


}