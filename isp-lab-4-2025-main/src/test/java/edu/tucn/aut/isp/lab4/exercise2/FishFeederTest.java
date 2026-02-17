package edu.tucn.aut.isp.lab4.exercise2;

import edu.tucn.aut.isp.lab4.exercise2.FishFeeder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FishFeederTest {
    @Test
    public void testFillUp(){
        FishFeeder fishfeeder = new FishFeeder("HydroFlow", "AquaMaster 3000", 20);
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=20", fishfeeder.toString());
        fishfeeder.fillUp();
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=14", fishfeeder.toString());
        fishfeeder.fillUp();
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=14", fishfeeder.toString());
    }
    @Test
    public void testFeed(){
        FishFeeder fishfeeder = new FishFeeder("HydroFlow", "AquaMaster 3000", 2);
        fishfeeder.feed();
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=1", fishfeeder.toString());
        fishfeeder.feed();
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=0", fishfeeder.toString());
        fishfeeder.feed();
        Assertions.assertEquals("FishFeeder:manufacturer=HydroFlow, model=AquaMaster 3000, meals=0", fishfeeder.toString());


    }
}
