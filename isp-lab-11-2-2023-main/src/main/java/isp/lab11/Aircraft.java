package isp.lab11;

public class Aircraft {
    private String id;
    private int altitude = 0;
    private int cruisingAltitude; /// ținta finală a altitudinii
    private boolean running = true;   ///ca sa oprim thread ul cand avionul aterizeaza
    private ATcCommandClass currentCommand;  /// pentru a salva acea comandă temporar până este executată
    private final Object lock = new Object(); ///Ca să implementez mecanismul wait()
    private long cruisingStartTime;  ///cât timp a petrecut avionul în starea Cruising
    private long cruisingEndTime;/// -||-

    public Aircraft(String id) {
        this.id = id;
    }

    public void receiveAtcCommand(ATcCommandClass cmd) { /// comunica ATc cu avion
        synchronized (lock) {
            this.currentCommand = cmd;
            lock.notify();
        }
    }

    public void run() {
        while (running) {
            synchronized (lock) {  /// folosim lock pt sincronizare
                try {
                    lock.wait(); ///  avionul așteaptă comenzi
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public String getId() {
        return id;
    }

    public void setAltitude(int alt) {
        this.altitude = alt;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setCruisingAltitude(int ca) {
        this.cruisingAltitude = ca;
    }

    public void startCruising() {
        cruisingStartTime = System.currentTimeMillis();
    }

    public void stopCruising() {
        cruisingEndTime = System.currentTimeMillis();
    }

    public long getCruisingDuration() {
        return (cruisingEndTime - cruisingStartTime) / 1000;
    }

    public void stop() {
        this.running = false;
    }

}
