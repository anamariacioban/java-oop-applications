package isp.lab10.raceapp;

public class RaceTimerThread extends Thread {
    private volatile boolean running = true;
    private long tickCount = 0;

    public void stopTimer() {
        running = false;
    }

    public long getTickCount() {
        return tickCount;
    }

    @Override
    public void run() {
        long lastTick = System.currentTimeMillis();

        while (running) {
            long now = System.currentTimeMillis();
            if (now - lastTick >= 10) {
                tickCount++;
                lastTick += 10;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
