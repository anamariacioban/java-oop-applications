package edu.tucn.aut.isp.lab4.exercise6;

import java.time.LocalTime;

public class Exercise6 {
    public static void main(String[] args) {
        TemperatureSensor temperatureSensor = new TemperatureSensor("ThermoPro", "TempY", 10.5f);
        LevelSensor levelSensor = new LevelSensor("AquaTech", "LevelX", 4);
        PHSensor phSensor= new PHSensor("pHTech", "pHSensor", 7.0f);
        FishFeeder fishFeeder = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        Alarm alarm1 = new Alarm("SafeTech", "WaterGuard"); ///avem nevoie pt constructor
        Alarm alarm2=new Alarm("SafeTech", "WaterGuard");///tot asa
        Heater heater = new Heater("HeatMaster", "WarmWave"); ///pt constructor
        AquariumController aquariumController = new AquariumController(
                "HydroFlow", "AquaMaster 3000", LocalTime.of(9,15), LocalTime.of(12,30),
                fishFeeder, temperatureSensor, levelSensor,phSensor, heater, alarm1, alarm2, 15.5f, 7);

        aquariumController.setCurrentTime(LocalTime.of(12, 30));
        aquariumController.setCurrentTime(LocalTime.of(13, 30));
        aquariumController.setFeedingTime(LocalTime.of(13, 30));
        aquariumController.setFeedingTime(LocalTime.of(18, 30));

        aquariumController.checkWaterLevel();
        aquariumController.checkTemperature();
        aquariumController.checkPHLevel();
        levelSensor.setValue(7);
        temperatureSensor.setValue(24.0f);
        phSensor.setValue(9.0f);
        aquariumController.checkWaterLevel();
        aquariumController.checkTemperature();
        aquariumController.checkPHLevel();
    }
}
