package edu.tucn.aut.isp.lab4.exercise4;

import java.time.LocalTime;

public class AquariumController {

    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;
    private FishFeeder fishFeeder;
    /// aici am adaugat un atribut de tipul clasei fishFeeder
    private LocalTime lightOnTime;
    /// adaugam nou atribut
    private LocalTime lightsOffTime;
    /// adaugam nou atribut
    private Lights lights;

    public AquariumController(String manufacturer, String model, LocalTime currentTime, LocalTime feedingTime, FishFeeder fishFeeder, LocalTime lightOnTime, LocalTime lightsOffTime, Lights lights) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime=feedingTime;
        this.fishFeeder = fishFeeder;
        this.lightOnTime = lightOnTime;
        this.lightsOffTime = lightsOffTime;
        this.lights = lights;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if (currentTime.equals(feedingTime)) {
            fishFeeder.feed();///cand metoda e apelata se declandeaza feed()
            System.out.println("currentTime=feedingTime");
        }
        else System.out.println("currentTime!=feedingTime");


        if (currentTime.equals(lightOnTime) && !lights.isOn()) {
            lights.turnOn();
            System.out.println("Apridem luminile!");
        } else if (currentTime.equals(lightOnTime) && lights.isOn()) {
            System.out.println("Luminile sunt deja aprinse!");
        }


        if (currentTime.equals(lightsOffTime) && lights.isOn() || currentTime.isAfter(lightOnTime.plusHours(6)) && currentTime.isBefore(lightOnTime.plusHours(8)) && lights.isOn()) {
            lights.turnOff();
            System.out.println("Stingem luminile!");
        }
        else if ((currentTime.equals(lightsOffTime) && !lights.isOn()) || (currentTime.isAfter(lightOnTime.plusHours(6)) && currentTime.isBefore(lightOnTime.plusHours(8)) && !lights.isOn())){
            System.out.println("Luminile sunt deja stinse!");
        }
        else if ((!lights.isOn())) {
            System.out.println("Luminile sunt deja stinse!");
        }

    }

    @Override
    public String toString() {
        return "AquariumController:" + "manufacturer=" + manufacturer + ", model=" + model + ", currentTime=" + currentTime + ", feedingTime=" + feedingTime + ", lightOnTime=" + lightOnTime + ", lightsOffTime=" + lightsOffTime;
    }
}
