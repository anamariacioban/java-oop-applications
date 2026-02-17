package edu.tucn.aut.isp.lab4.exercise4;

public class Lights {
    private boolean isOn;

    public Lights(boolean isOn) {
        this.isOn = isOn;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println("true");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("false");
    }
    public boolean isOn() {
        return isOn;
    }
}
