package edu.tucn.aut.isp.lab4.exercise4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class LightsTest {
    @Test
    public void testLights1() {
        FishFeeder fishFeeder1 = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        Lights lights1 = new Lights(false);
        AquariumController aquariumcontroller1 = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.of(11,11), LocalTime.of(14,30), fishFeeder1, LocalTime.of(12, 30), LocalTime.of(14, 30), lights1);

        aquariumcontroller1.setCurrentTime(LocalTime.of(14, 30));
        Assertions.assertEquals("AquariumController:manufacturer=HydroFlow, model=AquaMaster 3000, currentTime=14:30, feedingTime=14:30, lightOnTime=12:30, lightsOffTime=14:30", aquariumcontroller1.toString());
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=19", fishFeeder1.toString());
        Assertions.assertEquals(false, lights1.isOn());

    }

    @Test
    public void testLights2() {
        FishFeeder fishFeeder2 = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        Lights lights2 = new Lights(true);
        AquariumController aquariumcontroller2 = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.now(), LocalTime.of(12,12), fishFeeder2, LocalTime.of(12, 30), LocalTime.of(14, 30), lights2);

        aquariumcontroller2.setCurrentTime(LocalTime.of(12, 30));
        Assertions.assertEquals("AquariumController:manufacturer=HydroFlow, model=AquaMaster 3000, currentTime=12:30, feedingTime=12:12, lightOnTime=12:30, lightsOffTime=14:30", aquariumcontroller2.toString());
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=20", fishFeeder2.toString());
        Assertions.assertEquals(true, lights2.isOn());

    }

    @Test
    public void testLights3() {
        FishFeeder fishFeeder3 = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        Lights lights3 = new Lights(true);
        AquariumController aquariumcontroller3 = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.now(), LocalTime.of(17,20), fishFeeder3, LocalTime.of(12, 30), LocalTime.of(14, 30), lights3);

        aquariumcontroller3.setCurrentTime(LocalTime.of(19, 30));
        Assertions.assertEquals("AquariumController:manufacturer=HydroFlow, model=AquaMaster 3000, currentTime=19:30, feedingTime=17:20, lightOnTime=12:30, lightsOffTime=14:30", aquariumcontroller3.toString());
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=20", fishFeeder3.toString());
        Assertions.assertEquals(false, lights3.isOn());

    }

    @Test
    public void testLights4() {
        FishFeeder fishFeeder4 = new FishFeeder("HydroFlow", "AquaMaster 3000", 8);
        Lights lights4 = new Lights(true);
        AquariumController aquariumcontroller4 = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.now(), LocalTime.of(14,30), fishFeeder4, LocalTime.of(12, 30), LocalTime.of(14, 30), lights4);

        aquariumcontroller4.setCurrentTime(LocalTime.of(14, 30));
        Assertions.assertEquals("AquariumController:manufacturer=HydroFlow, model=AquaMaster 3000, currentTime=14:30, feedingTime=14:30, lightOnTime=12:30, lightsOffTime=14:30", aquariumcontroller4.toString());
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=7", fishFeeder4.toString());
        Assertions.assertEquals(false, lights4.isOn());

    }

    @Test
    public void testLights5() {
        FishFeeder fishFeeder5 = new FishFeeder("HydroFlow", "AquaMaster 3000", 0);
        Lights lights5 = new Lights(false);
        AquariumController aquariumcontroller5 = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.now(), LocalTime.of(12,30), fishFeeder5, LocalTime.of(12, 30), LocalTime.of(14, 30), lights5);

        aquariumcontroller5.setCurrentTime(LocalTime.of(12, 30));
        Assertions.assertEquals("AquariumController:manufacturer=HydroFlow, model=AquaMaster 3000, currentTime=12:30, feedingTime=12:30, lightOnTime=12:30, lightsOffTime=14:30", aquariumcontroller5.toString());
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=0", fishFeeder5.toString());
        Assertions.assertEquals(true, lights5.isOn());

    }

    @Test
    public void testLights6() {
        FishFeeder fishFeeder6 = new FishFeeder("HydroFlow", "AquaMaster 3000", 10);
        Lights lights6 = new Lights(false);
        AquariumController aquariumcontroller6 = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.now(), LocalTime.of(15,15), fishFeeder6, LocalTime.of(12, 30), LocalTime.of(14, 30), lights6);

        aquariumcontroller6.setCurrentTime(LocalTime.of(19, 30));
        Assertions.assertEquals("AquariumController:manufacturer=HydroFlow, model=AquaMaster 3000, currentTime=19:30, feedingTime=15:15, lightOnTime=12:30, lightsOffTime=14:30", aquariumcontroller6.toString());
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=10", fishFeeder6.toString());
        Assertions.assertEquals(false, lights6.isOn());

    }


}
