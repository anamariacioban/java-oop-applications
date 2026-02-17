package edu.tucn.aut.isp.lab4.exercise3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class AquariumControllerTestandFishFeederTest {
    @Test
    public void testAquariumControllerAndFishFeeder1() {
        FishFeeder fishFeeder1 = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        AquariumController aquariumcontroller1 = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.of(11,11), LocalTime.of(12,00), fishFeeder1);

        aquariumcontroller1.setCurrentTime(LocalTime.of(12, 00));
        Assertions.assertEquals("AquariumController:manufacturer=HydroFlow, model=AquaMaster 3000, currentTime=12:00, feedingTime=12:00", aquariumcontroller1.toString());
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=19", fishFeeder1.toString());


        FishFeeder fishFeeder2 = new FishFeeder("HydroFlow", "AquaMaster 3000", 19);
        AquariumController aquariumcontroller2 = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.of(14,14), LocalTime.of(14,30), fishFeeder2);

        aquariumcontroller2.setCurrentTime(LocalTime.of(17, 30));
        Assertions.assertEquals("AquariumController:manufacturer=HydroFlow, model=AquaMaster 3000, currentTime=17:30, feedingTime=14:30", aquariumcontroller2.toString());
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=19", fishFeeder2.toString());


        FishFeeder fishFeeder3 = new FishFeeder("HydroFlow", "AquaMaster 3000", 0);
        AquariumController aquariumcontroller3 = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.of(14,14), LocalTime.of(14,30), fishFeeder3);

        aquariumcontroller3.setCurrentTime(LocalTime.of(14, 30));
        Assertions.assertEquals("AquariumController:manufacturer=HydroFlow, model=AquaMaster 3000, currentTime=14:30, feedingTime=14:30", aquariumcontroller3.toString());
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=0", fishFeeder3.toString());

    }
}

