package isp.lab5.exercise3;

public abstract class Sensor {
    private String installLocation;
    private String name;

    public Sensor(String installLocation, String name) {
        this.installLocation = installLocation;
        this.name = name;
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public String getName() {
        return name;
    }
   public abstract double getValue(); ///fara ea nu putem accesa Temperature si Pressure in MonitoringService
}
