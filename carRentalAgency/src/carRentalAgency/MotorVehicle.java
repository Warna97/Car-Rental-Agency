package carRentalAgency;

public interface MotorVehicle extends Vehicle {
    int getNumWheels();
    String getMotorcycleType();
    void setNumWheels(int numWheels);
    void setMotorcycleType(String type);
}

