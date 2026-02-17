package isp.lab7.safehome;

import java.time.LocalDateTime;

class AccessLog {
    String tenantName;
    LocalDateTime dateTime;
    String operation;
    DoorStatus doorStatus;
    String errorMessage;

    public AccessLog(String tenantName, LocalDateTime dateTime, String operation, DoorStatus doorStatus, String errorMessage) {
        this.tenantName = tenantName;
        this.dateTime = dateTime;
        this.operation = operation;
        this.doorStatus = doorStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return dateTime + " - " + tenantName + ": " + operation + " - Door is " + doorStatus + (errorMessage != null ? " - ERROR: " + errorMessage : "");
    }
}
