package isp.lab5.exercise2;

import static java.lang.Math.min;

public class SmartPhone implements Chargeable {
    private int batteryLevel=0;

    @Override
    public int getBatteryLevel(){
        return batteryLevel;
    }
    @Override
    public void charge(int duration){
        int charged = duration * 3; //3%pe minut
        batteryLevel = min(100, batteryLevel + charged); //nu putem sa incarcam mai mult de 100%
        System.out.println("SmartPhone ul a fost încărcat" + duration + " min. Nivelul bateriei este: " + batteryLevel + "%");
    }

}
