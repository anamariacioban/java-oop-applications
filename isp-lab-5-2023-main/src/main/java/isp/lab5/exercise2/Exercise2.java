package isp.lab5.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        System.out.println("Nivelul bateriei:" + laptop.getBatteryLevel() + "%");
        laptop.charge(20);
        System.out.println("Nivelul bateriei:" + laptop.getBatteryLevel() + "%");

        SmartPhone smartPhone=new SmartPhone();
        System.out.println("Nivelul bateriei:" + smartPhone.getBatteryLevel() + "%");
        smartPhone.charge(50);
        System.out.println("Nivelul bateriei:" + smartPhone.getBatteryLevel() + "%");

        SmartWatch smartWatch=new SmartWatch();
        System.out.println("Nivelul bateriei:" + smartWatch.getBatteryLevel() + "%");
        smartWatch.charge(80);
        System.out.println("Nivelul bateriei:" + smartWatch.getBatteryLevel() + "%");





    }
}
