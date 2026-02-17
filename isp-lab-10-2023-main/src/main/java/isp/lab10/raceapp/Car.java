package isp.lab10.raceapp;

public class Car extends Thread {
    private String name;
    private int distance = 0;
    private CarPanel carPanel;
    private long startTime;
    private long endTime;

    public Car(String name, CarPanel carPanel) {
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();

        while (distance < 400) {
            int speed = (int) (Math.random() * 10) + 1;
            distance += speed;

            carPanel.updateCarPosition(name, distance);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        endTime = System.currentTimeMillis();
        carPanel.carFinished(name, endTime - startTime);
    }

    public long getRaceDuration() {
        return endTime - startTime;
    }

}