package carRentalAgency;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class VehicleMain {
    private static List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Create a Car");
            System.out.println("2. Create a Motorcycle");
            System.out.println("3. Create a Truck");
            System.out.println("4. View all vehicles");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        Car car = createCar(scanner);
                        vehicles.add(car);
                        displayVehicleDetails(car);
                        break;
                    case 2:
                        Motorcycle motorcycle = createMotorcycle(scanner);
                        vehicles.add(motorcycle);
                        displayVehicleDetails(motorcycle);
                        break;
                    case 3:
                        Truck truck = createTruck(scanner);
                        vehicles.add(truck);
                        displayVehicleDetails(truck);
                        break;
                    case 4:
                        viewAllVehicles();
                        break;
                    case 0:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine();  // Clear the invalid input
                choice = -1;  // Reset the choice to force another iteration
            }
        } while (choice != 0);

        scanner.close();
    }

    public static Car createCar(Scanner scanner) {
        System.out.println("Enter car make:");
        String make = scanner.nextLine();
        System.out.println("Enter car model:");
        String model = scanner.nextLine();
        System.out.println("Enter car year:");
        int year = getValidYear(scanner);

        Car car = new Car(make, model, year);

        System.out.println("Enter number of doors:");
        int numDoors = getValidNumber(scanner, "Enter a valid number of doors:");
        car.setNumDoors(numDoors);

        System.out.println("Enter fuel type (petrol, diesel, or electric):");
        String fuelType = getValidFuelType(scanner);
        car.setFuelType(fuelType);

        return car;
    }

    public static Motorcycle createMotorcycle(Scanner scanner) {
        System.out.println("Enter motorcycle make:");
        String make = scanner.nextLine();
        System.out.println("Enter motorcycle model:");
        String model = scanner.nextLine();
        System.out.println("Enter motorcycle year:");
        int year = getValidYear(scanner);

        Motorcycle motorcycle = new Motorcycle(make, model, year);

        System.out.println("Enter number of wheels:");
        int numWheels = getValidNumber(scanner, "Enter a valid number of wheels:");
        motorcycle.setNumWheels(numWheels);

        System.out.println("Enter motorcycle type (sport, cruiser, or off-road):");
        String type = getValidMotorcycleType(scanner);
        motorcycle.setMotorcycleType(type);

        return motorcycle;
    }

    public static Truck createTruck(Scanner scanner) {
        System.out.println("Enter truck make:");
        String make = scanner.nextLine();
        System.out.println("Enter truck model:");
        String model = scanner.nextLine();
        System.out.println("Enter truck year:");
        int year = getValidYear(scanner);

        Truck truck = new Truck(make, model, year);

        System.out.println("Enter cargo capacity (in tons):");
        double cargoCapacity = getValidCargoCapacity(scanner);
        truck.setCargoCapacity(cargoCapacity);

        System.out.println("Enter transmission type (manual or automatic):");
        String transmissionType = getValidTransmissionType(scanner);
        truck.setTransmissionType(transmissionType);

        return truck;
    }

    public static void viewAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to display.");
        } else {
            System.out.println("All Vehicles:");
            for (Vehicle vehicle : vehicles) {
                displayVehicleDetails(vehicle);
            }
        }
    }

    public static void displayVehicleDetails(Vehicle vehicle) {
        System.out.println("Vehicle Details:");
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year: " + vehicle.getYear());

        if (vehicle instanceof CarVehicle) {
            CarVehicle car = (CarVehicle) vehicle;
            System.out.println("Number of Doors: " + car.getNumDoors());
            System.out.println("Fuel Type: " + car.getFuelType());
        } else if (vehicle instanceof MotorVehicle) {
            MotorVehicle motorcycle = (MotorVehicle) vehicle;
            System.out.println("Number of Wheels: " + motorcycle.getNumWheels());
            System.out.println("Motorcycle Type: " + motorcycle.getMotorcycleType());
        } else if (vehicle instanceof TruckVehicle) {
            TruckVehicle truck = (TruckVehicle) vehicle;
            System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
            System.out.println("Transmission Type: " + truck.getTransmissionType());
        }
    }
    

    public static int getValidYear(Scanner scanner) {
        while (true) {
            try {
                int year = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
                if (year >= 1900 && year <= 2200) {
                    return year;
                } else {
                    System.out.println("Enter a valid year between 1900 and 2200:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid year:");
                scanner.nextLine();  // Clear the invalid input
            }
        }
    }

    public static int getValidNumber(Scanner scanner, String errorMessage) {
        while (true) {
            try {
                int number = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
                return number;
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.nextLine();  // Clear the invalid input
            }
        }
    }

    public static String getValidFuelType(Scanner scanner) {
        while (true) {
            String fuelType = scanner.nextLine().toLowerCase();
            if (fuelType.equals("petrol") || fuelType.equals("diesel") || fuelType.equals("electric")) {
                return fuelType;
            } else {
                System.out.println("Enter a valid fuel type (petrol, diesel, or electric):");
            }
        }
    }

    public static String getValidMotorcycleType(Scanner scanner) {
        while (true) {
            String type = scanner.nextLine().toLowerCase();
            if (type.equals("sport") || type.equals("cruiser") || type.equals("off-road")) {
                return type;
            } else {
                System.out.println("Enter a valid motorcycle type (sport, cruiser, or off-road):");
            }
        }
    }

    public static double getValidCargoCapacity(Scanner scanner) {
        while (true) {
            try {
                double capacity = scanner.nextDouble();
                scanner.nextLine();  // Consume the newline character
                if (capacity > 0) {
                    return capacity;
                } else {
                    System.out.println("Enter a valid cargo capacity greater than 0:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid cargo capacity:");
                scanner.nextLine();  // Clear the invalid input
            }
        }
    }

    public static String getValidTransmissionType(Scanner scanner) {
        while (true) {
            String transmissionType = scanner.nextLine().toLowerCase();
            if (transmissionType.equals("manual") || transmissionType.equals("automatic")) {
                return transmissionType;
            } else {
                System.out.println("Enter a valid transmission type (manual or automatic):");
            }
        }
    }
}
