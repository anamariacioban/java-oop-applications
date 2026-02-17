package isp.lab10.raceapp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame raceFrame = new JFrame("Car Race");
        raceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarPanel carPanel = new CarPanel();
        raceFrame.getContentPane().add(carPanel);
        raceFrame.setSize(500, 300);
        raceFrame.setLocation(100, 100);
        raceFrame.setVisible(true);


        Car car1 = new Car("Red car", carPanel);
        Car car2 = new Car("Blue car", carPanel);
        Car car3 = new Car("Green car", carPanel);
        Car car4 = new Car("Yellow car", carPanel);


        JFrame semFrame = new JFrame("Semaphore");
        semFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SemaphorePanel semaphorePanel = new SemaphorePanel();
        semFrame.getContentPane().add(semaphorePanel);
        semFrame.setSize(200, 300);
        semFrame.setLocation(650, 100);
        semFrame.setVisible(true);


        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();

        try {

            semaphoreThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PlaySound ps = new PlaySound();
        ps.playSound();

        RaceTimerThread raceTimer = new RaceTimerThread();
        raceTimer.start();

        //pornim cursa
        car1.start();
        car2.start();
        car3.start();
        car4.start();

        try {
            car1.join();
            car2.join();
            car3.join();
            car4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //oprim sunet
        ps.stopSound();

        raceTimer.stopTimer();
        System.out.println("Total race time: " + raceTimer.getTickCount() * 10 + " ms");

    }
}
