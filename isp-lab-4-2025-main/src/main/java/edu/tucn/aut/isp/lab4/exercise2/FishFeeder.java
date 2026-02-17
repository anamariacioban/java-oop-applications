package edu.tucn.aut.isp.lab4.exercise2;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder(String manufacturer, String model, int meals) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = meals;
    }

    public void fillUp() {
        this.meals = 14;
        System.out.println("meals=14");
    }

    public void feed() {
        if (meals > 0) {
            this.meals = meals - 1;
            System.out.println("meals=meals-1->" + meals);
        } else  System.out.println("nu putem avea nr negativ!");

    }

    @Override
    public String toString() {
        return "FishFeeder:" + "manufacturer=" + manufacturer + ", model=" + model + ", meals=" + meals;
    }

}
