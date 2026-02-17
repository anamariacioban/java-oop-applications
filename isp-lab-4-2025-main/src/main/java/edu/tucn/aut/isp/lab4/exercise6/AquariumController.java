package edu.tucn.aut.isp.lab4.exercise6;

import java.time.LocalTime;

public class AquariumController {

    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;
    private FishFeeder feeder;
    private float presetTemperature;
    private int presetLevel;

    private LevelSensor levelSensor;
    private TemperatureSensor temperatureSensor;
    private PHSensor phsensor;
    private Actuator temperatureActuator;
    private Actuator waterLevelActuator;
    private Actuator phlevelActuator;

    public AquariumController(String manufacturer, String model, LocalTime currentTime, LocalTime feedingTime, FishFeeder feeder, TemperatureSensor temperatureSensor, LevelSensor levelSensor, PHSensor phsensor, Actuator temperatureActuator, Actuator waterLevelActuator, Actuator phlevelActuator, float presetTemperature, int presetLevel ) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime=feedingTime;
        this.feeder = feeder;
        this.temperatureSensor=temperatureSensor;
        this.levelSensor=levelSensor;
        this.phsensor=phsensor;
        this.temperatureActuator=temperatureActuator;
        this.waterLevelActuator=waterLevelActuator;
        this.phlevelActuator=phlevelActuator;
        this.presetTemperature = presetTemperature;
        this.presetLevel=presetLevel;

    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if (currentTime.equals(feedingTime)) {
            feeder.feed();///cand metoda e apelata se declandeaza feed()
            System.out.println("currentTime=feedingTime");
        }
        else System.out.println("currentTime!=feedingTime");
    }
    public void setFeedingTime(LocalTime feedingTime){
        this.feedingTime=feedingTime;
        if (feedingTime.equals(currentTime)) {
            feeder.feed();///cand metoda e apelata se declandeaza feed()
            System.out.println("feedingTime=currentTime");
        }
        else System.out.println("feedingTime!=currentTime");
    }
    public void checkTemperature() {
        if (temperatureSensor.getValue() < presetTemperature) {
            System.out.println("activam heater-ul!");
            temperatureActuator.turnOn();
        } else {
            System.out.println("dezactivam heater-ul!");
            temperatureActuator.turnOff();
        }
    }

    public void checkWaterLevel() {
        if (levelSensor.getValue() < presetLevel) {
            System.out.println("activam alarma!");
            waterLevelActuator.turnOn();
        } else {
            System.out.println("dezactivam alarma!");
            waterLevelActuator.turnOff();
        }
    }

    public void checkPHLevel(){
        if(phsensor.getValue()<6.5 || phsensor.getValue()>8.0){
            System.out.println("PH nu e okay! activam alarma!");
            phlevelActuator.turnOn();
        } else {
            System.out.println("Ph okay! dezactivam alarma!");
            phlevelActuator.turnOff();

        }
    }

    @Override
    public String toString() {
        return "AquariumController:" + "manufacturer=" + manufacturer + ", model=" + model + ", currentTime=" + currentTime + ", feedingTime=" + feedingTime + ", presetTemperature=" + presetTemperature + ", presetLevel=" + presetLevel;
    }
}

