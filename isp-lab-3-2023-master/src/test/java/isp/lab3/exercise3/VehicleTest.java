package isp.lab3.exercise3;

import org.junit.Assert;
import org.junit.Test;

public class VehicleTest {
    @Test
    public void testToString() {
        Vehicle vehicle = new Vehicle("Ford", "Truck", 100, 'D');

        vehicle.setModel("Tesla");
        vehicle.setType("Sedan");
        vehicle.setSpeed(-10);
        vehicle.setFuelType('B');
        Assert.assertEquals("Tesla (Sedan) speed 100 fuel type B", vehicle.toString());


        vehicle.setModel("Tesla");
        vehicle.setType("Sedan");
        vehicle.setSpeed(150);
        vehicle.setFuelType('B');
        Assert.assertEquals("Tesla (Sedan) speed 150 fuel type B", vehicle.toString());

        vehicle.setModel("Tesla");
        vehicle.setType("Sedan");
        vehicle.setSpeed(150);
        vehicle.setFuelType('A');
        Assert.assertEquals("Tesla (Sedan) speed 150 fuel type B", vehicle.toString());


    }
}
