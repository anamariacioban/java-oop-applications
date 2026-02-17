package edu.tucn.aut.isp.lab4.exercise1;

import java.time.LocalTime;

public class Exercise1 {

    public static void main(String[] args) {
        AquariumController aquariumcontroller = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.now());
        /// vedem: manufacturer+model+ora curenta(cea reala)
        System.out.println(aquariumcontroller);
        aquariumcontroller.setCurrentTime(LocalTime.of(16, 28));
        /// vedem:  manufacturer+model+ora setata
        System.out.println(aquariumcontroller);
    }
}
