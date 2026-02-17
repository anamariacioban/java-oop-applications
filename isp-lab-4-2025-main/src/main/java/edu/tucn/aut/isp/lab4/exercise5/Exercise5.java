package edu.tucn.aut.isp.lab4.exercise5;


import java.time.LocalTime;

public class Exercise5 {
    public static void main(String[] args) {
        TemperatureSensor temperatureSensor = new TemperatureSensor("ThermoPro", "TempY", 10.5f);
        LevelSensor levelSensor = new LevelSensor("AquaTech", "LevelX", 4);
        FishFeeder fishFeeder = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        Alarm alarm = new Alarm("SafeTech", "WaterGuard"); ///avem nevoie pt constructor
        Heater heater = new Heater("HeatMaster", "WarmWave"); ///pt constructor
        AquariumController aquariumController = new AquariumController(
                "HydroFlow", "AquaMaster 3000", LocalTime.of(9,15), LocalTime.of(12,30),
                fishFeeder, temperatureSensor, levelSensor,  heater, alarm, 15.5f, 7);

        aquariumController.setCurrentTime(LocalTime.of(12, 30));
        aquariumController.setCurrentTime(LocalTime.of(13, 30));
        aquariumController.setFeedingTime(LocalTime.of(13, 30));
        aquariumController.setFeedingTime(LocalTime.of(18, 30));

        aquariumController.checkWaterLevel();
        aquariumController.checkTemperature();
        levelSensor.setValue(7);
        temperatureSensor.setValue(24.0f);
        aquariumController.checkWaterLevel();
        aquariumController.checkTemperature();
    }
}


