package isp.lab6.exercise2;

import java.util.Objects;

public class Vehicle {
    private String vin;
    private String licensePlate;
    private String make;
    private String model;
    private int year;

    public Vehicle(String vin, String licensePlate, String make, String model, int year) {
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return vin.equals(vehicle.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    @Override
    public String toString() {
        return "VIN: " + vin + ", Plate: " + licensePlate + ", Make: " + make +
                ", Model: " + model + ", Year: " + year;
    }
}