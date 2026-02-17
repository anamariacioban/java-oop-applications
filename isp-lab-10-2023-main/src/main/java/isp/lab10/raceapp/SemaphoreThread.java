package isp.lab10.raceapp;

class SemaphoreThread extends Thread {
    private SemaphorePanel semaphorePanel;
    private Car[] cars;

    public SemaphoreThread(SemaphorePanel semaphorePanel, Car... cars) {
        this.semaphorePanel = semaphorePanel;
        this.cars = cars;
    }

    public void run() {
        try {
            semaphorePanel.setGray();
            Thread.sleep((int) (Math.random() * 5000) + 2000);

            semaphorePanel.setYellow();
            Thread.sleep((int) (Math.random() * 5000) + 2000);

            semaphorePanel.setGreen();

            for (Car car : cars) {
                car.start();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
