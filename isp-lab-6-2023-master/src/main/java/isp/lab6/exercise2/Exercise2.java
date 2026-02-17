package isp.lab6.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("1234", "CJ 11 ANA", "Fiat", "Tipo", 2022);
        Vehicle vehicle2 = new Vehicle("5678", "SJ 45 CRS ", "Audi", "A6", 2018);
        Vehicle vehicle3 = new Vehicle("8765", "IF 12 ANB", "Chevrolet", "Malibu", 2020);
        Vehicle vehicle4 = new Vehicle("1234", "CT 25 DMO", "Cupra", "Leon", 2022);

        VehicleRegistrySystem registry = new VehicleRegistrySystem();

        registry.addVehicle(vehicle1);
        registry.addVehicle(vehicle2);
        registry.addVehicle(vehicle3);
        registry.addVehicle(vehicle4);

        System.out.println("Displaying all vehicles:");
        registry.displayAllVehicles();

        registry.isVehicleRegistered("8765");



        registry.removeVehicleByVin("5678");

        System.out.println("Displaying all vehicles after removal:");
        registry.displayAllVehicles();
    }
}
