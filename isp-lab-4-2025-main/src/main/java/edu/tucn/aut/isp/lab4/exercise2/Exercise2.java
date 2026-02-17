package edu.tucn.aut.isp.lab4.exercise2;

import edu.tucn.aut.isp.lab4.exercise1.AquariumController;

import java.time.LocalTime;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder fishfeeder = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        System.out.println(fishfeeder.toString());
        fishfeeder.fillUp();
        System.out.println(fishfeeder);
        fishfeeder.feed();
        System.out.println(fishfeeder);


    }
}
