import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        Dealership dealership = new Dealership();

        do {
            displayMainMenu();
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: dealership.addVehicleFromInput(); break;
                case 2:
                    System.out.println("Enter VIN of vehicle you want to remove: ");
                    Vehicle toRemove = dealership.findByVIN(input.nextLine());
                    if (toRemove == null) {
                        System.out.println("Vehicle does not exist");
                    }
                    else {
                        dealership.removeVehicle(toRemove);
                    }
                    break;
                case 3:
                    System.out.println("Enter VIN of vehicle you want to see: ");
                    Vehicle toSee = dealership.findByVIN(input.nextLine());
                    if (toSee == null) {
                        System.out.println("Vehicle does not exist");
                    }
                    else {
                        System.out.println(toSee);
                    }
                    break;
                case 4:
                    dealership.reportAscending();
                    break;
                case 5:
                    System.out.println("Enter maximum price: ");
                    dealership.reportBelowThreshold(input.nextDouble());
                    input.nextLine();
                    break;
                case 6:
                    System.out.println("Enter minimum vehicle range: ");
                    dealership.reportElectricThreshold(input.nextDouble());
                    input.nextLine();
                    break;
                case 7:
                    dealership.exportInventory();
                    break;
                case 8:
                    dealership.importInventory();
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (running);


        }

    static void displayMainMenu() {
        System.out.println("""
                Dealership Inventory Management
                1. Add New Vehicle
                2. Remove Vehicle
                3. Display Vehicle Details
                4. Display Inventory Ascending
                5. Display Vehicles Below Price Threshold
                6. Display Electric Cars Above Range
                7. Export Inventory to Text File
                8. Import Inventory From Text File
                9. Quit""");
    }


}

class Dealership {
    private final ArrayList<Vehicle> vehicles;
    private static final int MAX_CAPACITY = 50;

    public Dealership() {
        this.vehicles = new ArrayList<>();
    }

    void addVehicle (Vehicle v) {
        if (vehicles.size() >= MAX_CAPACITY) {
            System.out.println("Lot is full.");
        }
        else {
            vehicles.add(v);
        }
    }

    void addVehicleFromInput() {
        System.out.print("VIN: ");
        String vin = Main.input.nextLine();
        System.out.print("Make: ");
        String make = Main.input.nextLine();
        System.out.print("Price: ");
        double price = Main.input.nextDouble();
        Main.input.nextLine();

        System.out.println("Vehicle type:");
        System.out.println("1. ElectricTruck");
        System.out.println("2. GasTruck");
        System.out.println("3. HybridTruck");
        System.out.println("4. ElectricSUV");
        System.out.println("5. GasSUV");
        System.out.println("6. HybridSUV");
        System.out.println("7. ElectricMotorcycle");
        System.out.println("8. GasMotorcycle");
        System.out.println("9. HybridMotorcycle");
        int typeChoice = Main.input.nextInt();
        Main.input.nextLine();

        switch (typeChoice) {
            case 1:
                System.out.print("Range on charge: ");
                double range = Main.input.nextDouble();
                System.out.print("Towing capacity: ");
                int towing = Main.input.nextInt();
                Main.input.nextLine();
                addVehicle(new ElectricTruck(vin, make, price, range, towing));
                break;
            case 2:
                System.out.print("Horsepower: ");
                double hp = Main.input.nextDouble();
                System.out.print("Towing capacity: ");
                int towing2 = Main.input.nextInt();
                Main.input.nextLine();
                addVehicle(new GasTruck(vin, make, price, hp, towing2));
                break;
            case 3:
                System.out.print("MPG: ");
                double mpg = Main.input.nextDouble();
                System.out.print("Towing capacity: ");
                int towing3 = Main.input.nextInt();
                Main.input.nextLine();
                addVehicle(new HybridTruck(vin, make, price, mpg, towing3));
                break;
            case 4:
                System.out.print("Range on charge: ");
                double range2 = Main.input.nextDouble();
                System.out.print("Seats: ");
                int seats = Main.input.nextInt();
                Main.input.nextLine();
                addVehicle(new ElectricSUV(vin, make, price, range2, seats));
                break;
            case 5:
                System.out.print("Horsepower: ");
                double hp2 = Main.input.nextDouble();
                System.out.print("Seats: ");
                int seats2 = Main.input.nextInt();
                Main.input.nextLine();
                addVehicle(new GasSUV(vin, make, price, hp2, seats2));
                break;
            case 6:
                System.out.print("MPG: ");
                double mpg2 = Main.input.nextDouble();
                System.out.print("Seats: ");
                int seats3 = Main.input.nextInt();
                Main.input.nextLine();
                addVehicle(new HybridSUV(vin, make, price, mpg2, seats3));
                break;
            case 7:
                System.out.print("Range on charge: ");
                double range3 = Main.input.nextDouble();
                System.out.print("Top speed: ");
                int topSpeed = Main.input.nextInt();
                Main.input.nextLine();
                addVehicle(new ElectricMotorcycle(vin, make, price, range3, topSpeed));
                break;
            case 8:
                System.out.print("Horsepower: ");
                double hp3 = Main.input.nextDouble();
                System.out.print("Top speed: ");
                int topSpeed2 = Main.input.nextInt();
                Main.input.nextLine();
                addVehicle(new GasMotorcycle(vin, make, price, hp3, topSpeed2));
                break;
            case 9:
                System.out.print("MPG: ");
                double mpg3 = Main.input.nextDouble();
                System.out.print("Top speed: ");
                int topSpeed3 = Main.input.nextInt();
                Main.input.nextLine();
                addVehicle(new HybridMotorcycle(vin, make, price, mpg3, topSpeed3));
                break;
            default:
                System.out.println("Invalid vehicle type.");
        }
    }

    void removeVehicle (Vehicle v) {
        vehicles.remove(v);
    }

    Vehicle findByVIN(String vin) {
        for(Vehicle vehicle : vehicles) {
            if (Objects.equals(vin, vehicle.getVin())) {
                return vehicle;
            }
        }
        return null;
    }

    void reportAscending() {
        ArrayList<Vehicle> sorted = new ArrayList<>(vehicles);
        sorted.sort(Comparator.comparing(Vehicle::getPrice));
        for (Vehicle v : sorted) {
            System.out.println(v);
        }
    }

    void reportBelowThreshold(double threshold) {
        for (Vehicle v : vehicles) {
            if (v.getPrice() < threshold) {
                System.out.println(v);
            }
        }
    }

    void reportElectricThreshold(double threshold) {
        for (Vehicle v : vehicles) {
            if (v instanceof Electric e && e.getRangeOnCharge() > threshold) {
                System.out.println(v);
            }
        }
    }

    void exportInventory() {
        try {
            FileWriter myWriter = new FileWriter("inventory.txt");
            for (Vehicle vehicle : vehicles) {
                myWriter.write(vehicle.toFileString() + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void importInventory() {
        vehicles.clear();
        File myObj = new File("inventory.txt");

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                String type = parts[0];

                switch (type) {
                    case "ElectricTruck":
                        addVehicle(new ElectricTruck(
                                parts[1], parts[2],
                                Double.parseDouble(parts[3]),
                                Double.parseDouble(parts[4]),
                                Integer.parseInt(parts[5])
                        ));
                        break;
                    case "GasTruck":
                        addVehicle(new GasTruck(
                                parts[1], parts[2],
                                Double.parseDouble(parts[3]),
                                Double.parseDouble(parts[4]),
                                Integer.parseInt(parts[5])
                        ));
                        break;
                    case "HybridTruck":
                        addVehicle(new HybridTruck(
                                parts[1], parts[2],
                                Double.parseDouble(parts[3]),
                                Double.parseDouble(parts[4]),
                                Integer.parseInt(parts[5])
                        ));
                        break;
                    case "ElectricSUV":
                        addVehicle(new ElectricSUV(
                                parts[1], parts[2],
                                Double.parseDouble(parts[3]),
                                Double.parseDouble(parts[4]),
                                Integer.parseInt(parts[5])
                        ));
                        break;
                    case "GasSUV":
                        addVehicle(new GasSUV(
                                parts[1], parts[2],
                                Double.parseDouble(parts[3]),
                                Double.parseDouble(parts[4]),
                                Integer.parseInt(parts[5])
                        ));
                        break;
                    case "HybridSUV":
                        addVehicle(new HybridSUV(
                                parts[1], parts[2],
                                Double.parseDouble(parts[3]),
                                Double.parseDouble(parts[4]),
                                Integer.parseInt(parts[5])
                        ));
                        break;
                    case "ElectricMotorcycle":
                        addVehicle(new ElectricMotorcycle(
                                parts[1], parts[2],
                                Double.parseDouble(parts[3]),
                                Double.parseDouble(parts[4]),
                                Integer.parseInt(parts[5])
                        ));
                        break;
                    case "GasMotorcycle":
                        addVehicle(new GasMotorcycle(
                                parts[1], parts[2],
                                Double.parseDouble(parts[3]),
                                Double.parseDouble(parts[4]),
                                Integer.parseInt(parts[5])
                        ));
                        break;
                    case "HybridMotorcycle":
                        addVehicle(new HybridMotorcycle(
                                parts[1], parts[2],
                                Double.parseDouble(parts[3]),
                                Double.parseDouble(parts[4]),
                                Integer.parseInt(parts[5])
                        ));
                        break;
                    default :
                        System.out.println("Invalid entry.");
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}

class Vehicle {
    final private String vin;
    private final String make;
    private final double price;

    public String toString() {
        return getClass().getSimpleName() + " | VIN: " + vin + " | Make: " + make + " | Price: $" + price;
    }
    public String toFileString() {
        return getClass().getSimpleName() + "," + vin + "," + make + "," + price;
    }

    public String getVin() { return vin; }
    public double getPrice() { return price; }

    public Vehicle (String vin, String make, double price) {
        this.vin = vin;
        this.make = make;
        this.price = price;
    }


}

class ElectricTruck extends Vehicle implements Electric {
    double rangeOnCharge;
    int towingCapacity;

    public String toString() {
        return super.toString() + " | Range: " + rangeOnCharge + " | Towing: " + towingCapacity;
    }

    public String toFileString() {
        return super.toFileString() + "," + rangeOnCharge + "," + towingCapacity;
    }

    public ElectricTruck(String vin, String make, double price, double rangeOnCharge, int towingCapacity) {
        super(vin, make, price);
        this.rangeOnCharge = rangeOnCharge;
        this.towingCapacity = towingCapacity;
    }

    public double getRangeOnCharge() { return rangeOnCharge; }
    public int getTowingCapacity() { return towingCapacity; }
}

class GasTruck extends Vehicle implements Gas {
    double horsepower;
    int towingCapacity;

    public String toString() {
        return super.toString() + " | Horsepower: " + horsepower + " | Towing: " + towingCapacity;
    }

    public String toFileString() {
        return super.toFileString() + "," + horsepower + "," + towingCapacity;
    }

    public GasTruck(String vin, String make, double price, double horsepower, int towingCapacity) {
        super(vin, make, price);
        this.horsepower = horsepower;
        this.towingCapacity = towingCapacity;
    }

    public double getHorsepower() { return horsepower; }
    public int getTowingCapacity() { return towingCapacity; }
}

class HybridTruck extends Vehicle implements Hybrid {
    double mpg;
    int towingCapacity;

    public String toString() {
        return super.toString() + " | MPG: " + mpg + " | Towing: " + towingCapacity;
    }

    public String toFileString() {
        return super.toFileString() + "," + mpg + "," + towingCapacity;
    }

    public HybridTruck(String vin, String make, double price, double mpg, int towingCapacity) {
        super(vin, make, price);
        this.mpg = mpg;
        this.towingCapacity = towingCapacity;
    }

    public double getMpg() { return mpg; }
    public int getTowingCapacity() { return towingCapacity; }
}

class ElectricSUV extends Vehicle implements Electric {
    double rangeOnCharge;
    int seats;

    public String toString() {
        return super.toString() + " | Range: " + rangeOnCharge + " | Seats: " + seats;
    }

    public String toFileString() {
        return super.toFileString() + "," + rangeOnCharge + "," + seats;
    }

    public ElectricSUV(String vin, String make, double price, double rangeOnCharge, int seats) {
        super(vin, make, price);
        this.rangeOnCharge = rangeOnCharge;
        this.seats = seats;
    }

    public double getRangeOnCharge() { return rangeOnCharge; }
    public int getSeats() { return seats; }
}

class GasSUV extends Vehicle implements Gas {
    double horsepower;
    int seats;

    public String toString() {
        return super.toString() + " | Horsepower: " + horsepower + " | Seats: " + seats;
    }

    public String toFileString() {
        return super.toFileString() + "," + horsepower + "," + seats;
    }

    public GasSUV(String vin, String make, double price, double horsepower, int seats) {
        super(vin, make, price);
        this.horsepower = horsepower;
        this.seats = seats;
    }

    public double getHorsepower() { return horsepower; }
    public int getSeats() { return seats; }
}

class HybridSUV extends Vehicle implements Hybrid {
    double mpg;
    int seats;

    public String toString() {
        return super.toString() + " | MPG: " + mpg + " | Seats: " + seats;
    }

    public String toFileString() {
        return super.toFileString() + "," + mpg + "," + seats;
    }

    public HybridSUV(String vin, String make, double price, double mpg, int seats) {
        super(vin, make, price);
        this.mpg = mpg;
        this.seats = seats;
    }

    public double getMpg() { return mpg; }
    public int getSeats() { return seats; }
}

class ElectricMotorcycle extends Vehicle implements Electric {
    double rangeOnCharge;
    int topSpeed;

    public String toString() {
        return super.toString() + " | Range: " + rangeOnCharge + " | Top Speed: " + topSpeed;
    }

    public String toFileString() {
        return super.toFileString() + "," + rangeOnCharge + "," + topSpeed;
    }

    public ElectricMotorcycle(String vin, String make, double price, double rangeOnCharge, int topSpeed) {
        super(vin, make, price);
        this.rangeOnCharge = rangeOnCharge;
        this.topSpeed = topSpeed;
    }

    public double getRangeOnCharge() { return rangeOnCharge; }
    public int getTopSpeed() { return topSpeed; }
}

class GasMotorcycle extends Vehicle implements Gas {
    double horsepower;
    int topSpeed;

    public String toString() {
        return super.toString() + " | Horsepower: " + horsepower + " | Top Speed: " + topSpeed;
    }

    public String toFileString() {
        return super.toFileString() + "," + horsepower + "," + topSpeed;
    }

    public GasMotorcycle(String vin, String make, double price, double horsepower, int topSpeed) {
        super(vin, make, price);
        this.horsepower = horsepower;
        this.topSpeed = topSpeed;
    }

    public double getHorsepower() { return horsepower; }
    public int getTopSpeed() { return topSpeed; }
}

class HybridMotorcycle extends Vehicle implements Hybrid {
    double mpg;
    int topSpeed;

    public String toString() {
        return super.toString() + " | MPG: " + mpg + " | Top Speed: " + topSpeed;
    }

    public String toFileString() {
        return super.toFileString() + "," + mpg + "," + topSpeed;
    }

    public HybridMotorcycle(String vin, String make, double price, double mpg, int topSpeed) {
        super(vin, make, price);
        this.mpg = mpg;
        this.topSpeed = topSpeed;
    }

    public double getMpg() { return mpg; }
    public int getTopSpeed() { return topSpeed; }
}



interface Electric {
    double getRangeOnCharge();
}

interface Gas {
    double getHorsepower();
}

interface Hybrid {
    double getMpg();
}