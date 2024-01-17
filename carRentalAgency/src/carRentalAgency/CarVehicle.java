package carRentalAgency;

public interface CarVehicle extends Vehicle {
    int getNumDoors();
    String getFuelType();
    void setNumDoors(int numDoors);
    void setFuelType(String fuelType);
}
