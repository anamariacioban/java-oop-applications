package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoorLockController implements ControllerInterface{

    private Map<Tenant, AccessKey> validAccess = new HashMap<>();
    private List<AccessLog> accessLogs = new ArrayList<>();
    private Door door = new Door();
    private int retryCount = 0;
    private boolean locked = false;

    @Override
    public DoorStatus enterPin(String pin) throws Exception {
        if (pin.equals(MASTER_KEY)) {
            retryCount = 0;
            locked = false;
            toggleDoor();
            logAccess(MASTER_TENANT_NAME, "Enter Pin", door.getStatus(), null);
            return door.getStatus();
        }

        if (locked) {
            logAccess("UNKNOWN", "Enter Pin", door.getStatus(), "Too many attempts");
            throw new TooManyAttemptsException();
        }

        List<Map.Entry<Tenant, AccessKey>> entries = new ArrayList<>(validAccess.entrySet());
        ///  folosim toate perechile „cheie-valoare”
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<Tenant, AccessKey> entry = entries.get(i);
            if (entry.getValue().getPin().equals(pin)) {
                retryCount = 0;
                toggleDoor();
                logAccess(entry.getKey().getName(), "Enter Pin", door.getStatus(), null);
                return door.getStatus();
            }
        }

        retryCount++;
        if (retryCount >= 3) {
            locked = true;
            logAccess("UNKNOWN", "Enter Pin", door.getStatus(), "Too many attempts");
            throw new TooManyAttemptsException();
        }

        logAccess("UNKNOWN", "Enter Pin", door.getStatus(), "Invalid pin");
        throw new InvalidPinException();
    }

    @Override
    public void addTenant(String pin, String name) throws Exception {
        List<Tenant> tenants = new ArrayList<>(validAccess.keySet());
    /// folosim doar cheile din map, adica doar numele
        for (int i = 0; i < tenants.size(); i++) {
            if (tenants.get(i).getName().equals(name)) {
                throw new TenantAlreadyExistsException();
            }
        }
        validAccess.put(new Tenant(name), new AccessKey(pin));
    }

    @Override
    public void removeTenant(String name) throws Exception {
        List<Tenant> tenants = new ArrayList<>(validAccess.keySet());
        Tenant toRemove = null;

        for (int i = 0; i < tenants.size(); i++) {
            if (tenants.get(i).getName().equals(name)) {
                toRemove = tenants.get(i);
                break;
            }
        }

        if (toRemove == null) {
            throw new TenantNotFoundException();
        }

        validAccess.remove(toRemove);
    }
    public List<AccessLog> getAccessLogs() {
        return accessLogs;
    }

    private void toggleDoor() {
        if (door.getStatus() == DoorStatus.CLOSE) {
            door.unlockDoor();
        } else {
            door.lockDoor();
        }
    }

    private void logAccess(String tenantName, String operation, DoorStatus status, String error) {
        accessLogs.add(new AccessLog(tenantName, LocalDateTime.now(), operation, status, error));
    }
}
