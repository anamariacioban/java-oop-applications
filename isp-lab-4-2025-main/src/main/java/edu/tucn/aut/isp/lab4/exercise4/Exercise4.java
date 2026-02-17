package edu.tucn.aut.isp.lab4.exercise4;


import java.time.LocalTime;

public class Exercise4 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        Lights lights = new Lights(true);
        AquariumController aquariumController = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.of(9,15), LocalTime.of(12,30) , fishFeeder, LocalTime.of(10,15), LocalTime.of(15,15),  lights);

        aquariumController.setCurrentTime(LocalTime.of(10, 15));
        aquariumController.setCurrentTime(LocalTime.of(17, 15));
        aquariumController.setCurrentTime(LocalTime.of(15, 15));
        aquariumController.setCurrentTime(LocalTime.of(10, 15));
        aquariumController.setCurrentTime(LocalTime.of(15, 15));
        aquariumController.setCurrentTime(LocalTime.of(22, 15));

    }
}
