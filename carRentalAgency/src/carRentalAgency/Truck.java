package carRentalAgency;

public class Truck implements TruckVehicle {
    private String make;
    private String model;
    private int year;
    private double cargoCapacity;
    private String transmissionType;

    public Truck(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    @Override
    public void setCargoCapacity(double capacity) {
        this.cargoCapacity = capacity;
    }

    @Override
    public void setTransmissionType(String type) {
        this.transmissionType = type;
    }
}
