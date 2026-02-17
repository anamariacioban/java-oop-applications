package edu.tucn.aut.isp.lab4.exercise3;


import java.time.LocalTime;

public class AquariumController {

    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;
    private FishFeeder fishFeeder;

    /// aici am adaugat un atribut de tipul clasei fishFeeder

    public AquariumController(String manufacturer, String model, LocalTime currentTime, LocalTime feedingTime, FishFeeder fishFeeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.fishFeeder = fishFeeder;  ///si in constructor il folosim
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if (currentTime.equals(feedingTime)) {
            fishFeeder.feed();///cand metoda e apelata se declandeaza feed()
            System.out.println("currentTime=feedingTime");
        }
        else System.out.println("currentTime!=feedingTime");
    }

    @Override
    public String toString() {
        return "AquariumController:" + "manufacturer=" + manufacturer + ", model=" + model + ", currentTime=" + currentTime + ", feedingTime=" + feedingTime;
    }
}
