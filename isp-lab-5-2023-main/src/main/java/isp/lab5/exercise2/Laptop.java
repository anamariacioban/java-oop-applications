package isp.lab5.exercise2;

import static java.lang.Math.min;

public class Laptop implements Chargeable {
    private int batteryLevel=0;

    @Override
    public int getBatteryLevel(){
        return batteryLevel;
    }
    @Override
    public void charge(int duration){
        int charged = duration * 5; //5%pe minut-> 5*2=10(in 2 min se incarca 10%)
        batteryLevel = min(100, batteryLevel + charged); //nu putem sa incarcam mai mult de 100%
        System.out.println("Laptopul a fost încărcat" + duration + " min. Nivelul bateriei este: " + batteryLevel + "%");
    }
}
