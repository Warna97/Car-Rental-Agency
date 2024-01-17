package carRentalAgency;

public interface TruckVehicle extends Vehicle {
    double getCargoCapacity();
    String getTransmissionType();
    void setCargoCapacity(double capacity);
    void setTransmissionType(String type);
}
