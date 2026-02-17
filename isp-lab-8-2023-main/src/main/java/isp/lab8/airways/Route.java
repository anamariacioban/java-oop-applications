package isp.lab8.airways;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private String name;
    @Getter
    /// genereaza automat getName si getWaypoints
    private List<Waypoint> waypoints = new ArrayList<>();

    public Route(String name) {
        this.name = name;
    }

    public void addWaypoint(Waypoint waypoint) {
        waypoints.add(waypoint);
    }

    public double getTotalDistance() {
        double total = 0.0;
        for (int i = 0; i < waypoints.size() - 1; i++) {
            Waypoint w1 = waypoints.get(i);
            Waypoint w2 = waypoints.get(i + 1);
            total = total + WaypointDistanceCalculator.calculateDistance(
                    w1.getLatitude(), w1.getLongitude(),
                    w2.getLatitude(), w2.getLongitude()
            );
        }
        return total;
    }

    public String getName() {
        return name;
    }
}
