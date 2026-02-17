package edu.tucn.aut.isp.lab4.exercise1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalTime;

class AquariumControllerTest {
    @Test
    public void testAquariumController() {
        AquariumController aquariumcontroller = new AquariumController("HydroFlow", "AquaMaster 3000", LocalTime.now());
        aquariumcontroller.setCurrentTime(LocalTime.of(16, 28));
        Assertions.assertEquals("AquariumController:manufacturer=HydroFlow, model=AquaMaster 3000, currentTime=16:28", aquariumcontroller.toString());
        /// nu inteleg de ce nu merge cu Assert.assertEquals...la primele teme mergea...
        /// vad ca merge daca inlocuiesc Assert cu Assertations
    }
    @Test
    void dummyTestNPE() {
        Assertions.assertThrows(
                NullPointerException.class, () -> {Integer nullInt = null; nullInt.toString();});
    }
}
