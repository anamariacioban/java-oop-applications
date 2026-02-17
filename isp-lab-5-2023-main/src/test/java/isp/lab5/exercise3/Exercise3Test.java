package isp.lab5.exercise3;

import org.junit.Assert;
import org.junit.Test;

public class Exercise3Test {
    @Test
    public void SensorsTest(){
        MonitoringService monitoringService = new MonitoringService();
        TemperatureSensor temperatureSensor1 = new TemperatureSensor("camera", "nume1", 23.25);
        TemperatureSensor temperatureSensor2 = new TemperatureSensor("camera", "nume2", 22.15);
        TemperatureSensor temperatureSensor3 = new TemperatureSensor("camera", "nume3", 21.25);
        TemperatureSensor temperatureSensor4 = new TemperatureSensor("camera", "num4", 25.10);
        TemperatureSensor temperatureSensor5 = new TemperatureSensor("camera", "nume5", 24.20);
        PressureSensor pressureSensor1 = new PressureSensor("cauciuc bicicleta", "nume1", 12.78);
        PressureSensor pressureSensor2 = new PressureSensor("cauciuc bicicleta", "nume2", 15.78);
        PressureSensor pressureSensor3 = new PressureSensor("cauciuc bicicleta", "nume3", 20.78);
        PressureSensor pressureSensor4 = new PressureSensor("cauciuc bicicleta", "nume4", 18.20);
        PressureSensor pressureSensor5 = new PressureSensor("cauciuc bicicleta", "nume5", 14.35);
        PressureSensor pressureSensor6 = new PressureSensor("cauciuc bicicleta", "nume6", 18.78);

        monitoringService.addSensor(temperatureSensor1);
        Assert.assertEquals(23.250, monitoringService.getAverageTemperatureSensors(), 0.001);
        monitoringService.addSensor(temperatureSensor2);
        Assert.assertEquals(22.700, monitoringService.getAverageTemperatureSensors(), 0.001);
        monitoringService.addSensor(temperatureSensor3);
        Assert.assertEquals(22.216, monitoringService.getAverageTemperatureSensors(), 0.001);
        monitoringService.addSensor(temperatureSensor4);
        Assert.assertEquals(22.9375, monitoringService.getAverageTemperatureSensors(), 0.001);
        monitoringService.addSensor(temperatureSensor5);
        Assert.assertEquals(23.19, monitoringService.getAverageTemperatureSensors(), 0.001);

        monitoringService.addSensor(pressureSensor1);
        Assert.assertEquals(21.455, monitoringService.getAverageAllSensors(), 0.001);
        monitoringService.addSensor(pressureSensor2);
        Assert.assertEquals(20.644, monitoringService.getAverageAllSensors(), 0.001);
        monitoringService.addSensor(pressureSensor3);
        Assert.assertEquals(20.661, monitoringService.getAverageAllSensors(), 0.001);
        monitoringService.addSensor(pressureSensor4);
        Assert.assertEquals(20.387, monitoringService.getAverageAllSensors(), 0.001);
        monitoringService.addSensor(pressureSensor5);
        Assert.assertEquals(19.784, monitoringService.getAverageAllSensors(), 0.001);

        try {
            monitoringService.addSensor(pressureSensor6);
            Assert.fail("Ar fi trebuit să avem exceptie pt ca putem avea max 10 sensori in lista!");
        } catch (IllegalStateException e) {
        }


    }
}
