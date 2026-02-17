package isp.lab8.airways;

import java.util.List;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        String routeName = "ParisRoute";
        Route route = new Route(routeName);

        Waypoint wp1 = new Waypoint();
        wp1.setIndex(0);
        wp1.setName("Marseille");  ///plecam de aici
        wp1.setLatitude(43.2965);
        wp1.setLongitude(5.3698);
        wp1.setAltitude(40);

        Waypoint wp2 = new Waypoint();
        wp2.setIndex(1);
        wp2.setName("Lyon");
        wp2.setLatitude(45.75);
        wp2.setLongitude(4.85);
        wp2.setAltitude(50);

        Waypoint wp3 = new Waypoint();
        wp3.setIndex(2);
        wp3.setName("Paris");
        wp3.setLatitude(48.8566);
        wp3.setLongitude(2.3522);
        wp3.setAltitude(35);

        route.addWaypoint(wp1);
        route.addWaypoint(wp2);
        route.addWaypoint(wp3);

        try {
            JsonUtils.saveWaypoint(wp1, routeName);  ///salvam fiecare wp in folderul rutei
            JsonUtils.saveWaypoint(wp2, routeName);
            JsonUtils.saveWaypoint(wp3, routeName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Încarcăm ruta și afișam detalii
        try {
            Route loadedRoute = RouteManager.loadRoute(routeName);
            System.out.println("Ruta încărcată: " + loadedRoute.getName());
            System.out.println("Waypoints:");

            List<Waypoint> waypoints = loadedRoute.getWaypoints();
            for (int i = 0; i < waypoints.size(); i++) {
                Waypoint wp = waypoints.get(i);
                System.out.printf(" - %s (%.4f, %.4f)\n", wp.getName(), wp.getLatitude(), wp.getLongitude());
            }

            double dist = loadedRoute.getTotalDistance();
            System.out.printf("Distanță totală: %.2f km\n", dist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Listez toate rutele disponibile:");
        RouteManager.listRoutes();
        /*
        ///am comentat-o pt a ramane ruta in director(daca o decomentam, ruta se sterge)
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIntroduceți numele rutei pe care doriți să o ștergeți:");
        String routeToDelete = scanner.nextLine();
        RouteManager.deleteRoute(routeToDelete);
        System.out.println("Ruta " + routeToDelete + " a fost ștearsă!");
         */
    }
}
