package isp.lab8.airways;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirwaysTest {
    @Test
    public void test() {
        Waypoint lrcl = new Waypoint();
        lrcl.setName("LRCL");
        lrcl.setLatitude(46.7852);
        lrcl.setLongitude(23.6862);
        lrcl.setAltitude(415);

        Waypoint tasod = new Waypoint();
        tasod.setName("TASOD");
        tasod.setLatitude(47.0548);
        tasod.setLongitude(23.9212);
        tasod.setAltitude(10460);

        Waypoint sopav = new Waypoint();
        sopav.setName("SOPAV");
        sopav.setLatitude(46.9804);
        sopav.setLongitude(24.7365);
        sopav.setAltitude(10900);

        Waypoint birgu = new Waypoint();
        birgu.setName("BIRGU");
        birgu.setLatitude(45.9467);
        birgu.setLongitude(26.0217);
        birgu.setAltitude(10200);

        Waypoint lrop = new Waypoint();
        lrop.setName("LROP");
        lrop.setLatitude(44.5711);
        lrop.setLongitude(26.0858);
        lrop.setAltitude(106);

        /// distanta intre LRCL și TASOD
        double dist1 = WaypointDistanceCalculator.calculateDistance(lrcl.getLatitude(), lrcl.getLongitude(), tasod.getLatitude(), tasod.getLongitude());
        System.out.printf("Distanța între LRCL și TASOD: %.2f km\n", dist1);
        assertEquals(34.88, dist1, 0.1);

        /// distanta între TASOD și SOPAV
        double dist2 = WaypointDistanceCalculator.calculateDistance(tasod.getLatitude(), tasod.getLongitude(), sopav.getLatitude(), sopav.getLongitude());
        System.out.printf("Distanța între TASOD și SOPAV: %.2f km\n", dist2);
        assertEquals(62.35, dist2, 0.1);

        /// d. între SOPAV și BIRGU
        double dist3 = WaypointDistanceCalculator.calculateDistance(sopav.getLatitude(), sopav.getLongitude(), birgu.getLatitude(), birgu.getLongitude());
        System.out.printf("Distanța între SOPAV și BIRGU: %.2f km\n", dist3);
        assertEquals(151.32, dist3, 0.1);

        /// d. între BIRGU și LROP
        double dist4 = WaypointDistanceCalculator.calculateDistance(birgu.getLatitude(), birgu.getLongitude(), lrop.getLatitude(), lrop.getLongitude());
        System.out.printf("Distanța între BIRGU și LROP: %.2f km\n", dist4);
        assertEquals(153.04, dist4, 0.1);

        /// Test total distanță
        Route route = new Route("LRCL-LROP");
        route.addWaypoint(lrcl);
        route.addWaypoint(tasod);
        route.addWaypoint(sopav);
        route.addWaypoint(birgu);
        route.addWaypoint(lrop);

        System.out.println("Distanța totală a rutei LRCL-LROP: " + route.getTotalDistance() + " km");
        assertEquals(401.61, route.getTotalDistance(), 0.1);
    }
}
