package edu.tucn.aut.isp.lab4.exercise5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class ActuatorTest {
    @Test
    public void testActuator1() {
        FishFeeder fishFeeder1 = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        TemperatureSensor temperatureSensor1 = new TemperatureSensor("ThermoPro", "TempY", 20.5f);
        LevelSensor levelSensor1 = new LevelSensor("AquaTech", "LevelX", 9);
        Alarm alarm1 = new Alarm("SafeTech", "WaterGuard");
        Heater heater1 = new Heater("HeatMaster", "WarmWave");

        AquariumController aquariumController1 = new AquariumController(
                "HydroFlow", "AquaMaster 3000", LocalTime.of(9, 15), LocalTime.of(14, 30),
                fishFeeder1, temperatureSensor1, levelSensor1, heater1, alarm1, 15.5f, 7);

        aquariumController1.checkWaterLevel();
        Assertions.assertEquals(false, alarm1.isOn());
        aquariumController1.checkTemperature();
        Assertions.assertEquals(false, heater1.isOn());

    }
    @Test
    public void testActuator2() {
        FishFeeder fishFeeder2 = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        TemperatureSensor temperatureSensor2 = new TemperatureSensor("ThermoPro", "TempY", 10.5f);
        LevelSensor levelSensor2 = new LevelSensor("AquaTech", "LevelX", 3);
        Alarm alarm2 = new Alarm("SafeTech", "WaterGuard");
        Heater heater2 = new Heater("HeatMaster", "WarmWave");

        AquariumController aquariumController2 = new AquariumController(
                "HydroFlow", "AquaMaster 3000", LocalTime.of(9, 15), LocalTime.of(14, 30),
                fishFeeder2, temperatureSensor2, levelSensor2, heater2, alarm2, 15.5f, 7);

        aquariumController2.checkWaterLevel();
        Assertions.assertEquals(true, alarm2.isOn());
        aquariumController2.checkTemperature();
        Assertions.assertEquals(true, heater2.isOn());

    }
}
