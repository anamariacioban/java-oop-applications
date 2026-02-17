package isp.lab5.exercise3;

public class PressureSensor extends Sensor{
    private double pressure;

    public PressureSensor(String installLocation, String name, double pressure) {
        super(installLocation, name);
        this.pressure = pressure;
    }
    @Override
    public double getValue(){
        return pressure;
    }
}
