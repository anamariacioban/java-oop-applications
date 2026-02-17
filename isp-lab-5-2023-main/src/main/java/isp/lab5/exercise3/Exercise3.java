package isp.lab5.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        MonitoringService monitoringService = new MonitoringService();
        TemperatureSensor temperatureSensor1 = new TemperatureSensor("camera", "nume1", 23.25);
        TemperatureSensor temperatureSensor2 = new TemperatureSensor("camera", "nume2", 22.15);
        TemperatureSensor temperatureSensor3 = new TemperatureSensor("camera", "nume3", 21.25);
        PressureSensor pressureSensor1 = new PressureSensor("cauciuc bicicleta", "nume1", 12.78);
        PressureSensor pressureSensor2 = new PressureSensor("cauciuc bicicleta", "nume2", 15.78);

        monitoringService.addSensor(temperatureSensor1);
        monitoringService.addSensor(temperatureSensor2);
        monitoringService.addSensor(temperatureSensor3);
        monitoringService.addSensor(pressureSensor1);
        monitoringService.addSensor(pressureSensor2);
        System.out.println("Medie:" + monitoringService.getAverageTemperatureSensors());
        System.out.println("Medie:" + monitoringService.getAverageAllSensors());


    }
}


