package edu.tucn.aut.isp.lab4.exercise3;


import java.time.LocalTime;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        AquariumController aquariumController = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.of(12,52), LocalTime.of(13,30), fishFeeder);

        aquariumController.setCurrentTime(LocalTime.of(13, 30));
        aquariumController.setCurrentTime(LocalTime.of(18, 0));
    }
}