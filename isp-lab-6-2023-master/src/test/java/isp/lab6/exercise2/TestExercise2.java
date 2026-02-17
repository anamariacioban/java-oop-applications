package isp.lab6.exercise2;

import org.junit.Assert;
import org.junit.Test;


public class TestExercise2 {
    @Test
    public void testAddVehicle() {
        Vehicle vehicle1 = new Vehicle("1234", "CJ 11 ANA", "Fiat", "Tipo", 2022);
        VehicleRegistrySystem registry = new VehicleRegistrySystem();
        String result1=registry.addVehicle(vehicle1);
        Assert.assertEquals("Vehicle added!", result1);

        Vehicle vehicle2 = new Vehicle("5678", "SJ 45 CRS ", "Audi", "A6", 2018);
        String result2=registry.addVehicle(vehicle2);
        Assert.assertEquals("Vehicle added!", result2);

        Vehicle vehicle3 = new Vehicle("1234", "CT 25 DMO", "Cupra", "Leon", 2022);
        String result3=registry.addVehicle(vehicle3);
        Assert.assertEquals("Vehicle with this VIN already exists!", result3);

    }
    @Test
    public void testRemoveVehicle() {
        Vehicle vehicle1 = new Vehicle("1234", "CJ 11 ANA", "Fiat", "Tipo", 2022);
        Vehicle vehicle2 = new Vehicle("5678", "SJ 45 CRS ", "Audi", "A6", 2018);
        VehicleRegistrySystem registry = new VehicleRegistrySystem();
        registry.addVehicle(vehicle1);
        registry.addVehicle(vehicle2);

        registry.removeVehicleByVin("1234");
        String result1=registry.isVehicleRegistered("1234");
        String result2=registry.isVehicleRegistered("5678");

        Assert.assertEquals("Vehicle not found!", result1);
        Assert.assertEquals("Vehicle found!", result2);
    }
    @Test
    public void testIsVehicleRegistered() {
        Vehicle vehicle1 = new Vehicle("1234", "CJ 11 ANA", "Fiat", "Tipo", 2022);
        Vehicle vehicle2 = new Vehicle("5678", "SJ 45 CRS ", "Audi", "A6", 2018);
        VehicleRegistrySystem registry = new VehicleRegistrySystem();
        registry.addVehicle(vehicle1);

        String result1=registry.isVehicleRegistered("1234");
        String result2=registry.isVehicleRegistered("5678");
        Assert.assertEquals("Vehicle found!", result1);
        Assert.assertEquals("Vehicle not found!", result2);

    }

}
