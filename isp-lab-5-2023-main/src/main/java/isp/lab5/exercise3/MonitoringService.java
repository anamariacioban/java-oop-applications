package isp.lab5.exercise3;

import java.util.ArrayList;
import java.util.List;

public class MonitoringService {
    private List<Sensor> sensors;

    public MonitoringService(){
        this.sensors = new ArrayList<>();
    }

    public double getAverageTemperatureSensors(){
            double s= 0;
            int c= 0;

            for (int i = 0; i < sensors.size(); i++) {
                if (sensors.get(i) instanceof TemperatureSensor) {
                    s= s+ sensors.get(i).getValue();
                    c++;
                }
            }

            if (c== 0) return 0;
            return s/ c;
    }
    public double getAverageAllSensors() {
        double s= 0;
        int c= 0;

        for (int i = 0; i < sensors.size(); i++) {
            s=s+sensors.get(i).getValue();
            c++;
        }

        if (c == 0) return 0;
        return s / c;
    }
    public void addSensor(Sensor sensor) {
        if (sensors.size() >= 10) {
            throw new IllegalStateException("Nu putem adăuga mai mult de 10 produse la o comandă!");
        }
        sensors.add(sensor);
    }

}
