package isp.lab3.exercise3;

public class Vehicle {
    private String model;
    private String type;
    private int speed;
    private char fuelType;

    private static int numberOfVehicles = 0;


    public Vehicle(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        numberOfVehicles++;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public char getFuelType() {
        return fuelType;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        } else {
            System.out.println("Viteza nu poate fi negativă!");
        }
    }

    public void setFuelType(char fuelType) {
        if (fuelType == 'D' || fuelType == 'B') {
            this.fuelType = fuelType;
        } else {
            System.out.println("Tip de combustibil invalid!");
        }
    }

    @Override
    public String toString() {
        return model + " (" + type + ") speed " + speed + " fuel type " + fuelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;
        return speed == vehicle.speed &&
                fuelType == vehicle.fuelType &&
                model.equals(vehicle.model) &&
                type.equals(vehicle.type);
    }

    public static void displayNumberOfVehicles() {
        System.out.println("Număr total de vehicule create: " + numberOfVehicles);
    }
}
