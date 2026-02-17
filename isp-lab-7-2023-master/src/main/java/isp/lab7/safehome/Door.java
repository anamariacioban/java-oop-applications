package isp.lab7.safehome;

class Door {
    DoorStatus status = DoorStatus.CLOSE;

    public void lockDoor() {
        status = DoorStatus.CLOSE;
    }

    public void unlockDoor() {
        status = DoorStatus.OPEN;
    }
    public DoorStatus getStatus() {
        return status;
    }
}
