package isp.lab3.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        Vehicle car1 = new Vehicle("Dacia", "Logan", 150, 'B');
        Vehicle car2 = new Vehicle("Tesla Model 3", "Sedan", 150, 'E');

        System.out.println(car1.toString());
        System.out.println(car2.toString());

        System.out.println("Vehicul 1:");
        System.out.println("Model: " + car1.getModel());
        System.out.println("Tip: " + car1.getType());
        System.out.println("Viteză: " + car1.getSpeed());
        System.out.println("Tip combustibil: " + car1.getFuelType());

        car1.setSpeed(160);
        System.out.println("\nDupă modificare:");
        System.out.println("Viteză vehicul 1: " + car1.getSpeed());

        System.out.println("\nVehicul 1 și Vehicul 2 sunt egale? " + car1.equals(car2));

        Vehicle.displayNumberOfVehicles();
    }
}
