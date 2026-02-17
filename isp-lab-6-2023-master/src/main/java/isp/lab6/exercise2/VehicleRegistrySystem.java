package isp.lab6.exercise2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VehicleRegistrySystem {

        private Set<Vehicle> vehicles = new HashSet<>();

    public String addVehicle(Vehicle vehicle) {
        if (vehicles.add(vehicle)) {
            return "Vehicle added!";
        } else {
            return "Vehicle with this VIN already exists!";
        }
    }

    public void removeVehicleByVin(String vin) {
        List<Vehicle> vehicleList = new ArrayList<>(vehicles); ///convertim intr o lista ->e mai usor
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getVin().equals(vin)) {
                vehicles.remove(vehicleList.get(i));
                System.out.println("Vehicle removed!");

            }
        }
    }

    public String isVehicleRegistered(String vin) {
        List<Vehicle> vehicleList = new ArrayList<>(vehicles);
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getVin().equals(vin)) {
                return "Vehicle found!";
            }
        }
            return "Vehicle not found!";
    }
    public void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicle!");
        } else {
            List<Vehicle> vehicleList = new ArrayList<>(vehicles);
            for (int i = 0; i < vehicleList.size(); i++) {
                System.out.println(vehicleList.get(i));
            }
        }
    }
}
