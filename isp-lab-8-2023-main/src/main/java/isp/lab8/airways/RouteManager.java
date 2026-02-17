package isp.lab8.airways;

import java.io.File;

public class RouteManager {
    public static Route loadRoute(String routeName) throws Exception {
        File folder = new File("routes", routeName);
        if (!folder.exists() || !folder.isDirectory()) {
            throw new Exception("Ruta nu există: " + routeName);
        }

        Route route = new Route(routeName);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                Waypoint wp = JsonUtils.loadWaypoint(files[i].getAbsolutePath());
                route.addWaypoint(wp);
            }
        }
        return route;
    }

    public static void deleteRoute(String routeName) {
        File folder = new File("routes", routeName);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            folder.delete();
        }
    }

    public static void listRoutes() {
        File routesFolder = new File("routes");
        if (routesFolder.exists() && routesFolder.isDirectory()) {
            String[] routeNames = routesFolder.list();
            if (routeNames != null) {
                for (int i = 0; i < routeNames.length; i++) {
                    System.out.println("Ruta: " + routeNames[i]);
                }
            }
        }
    }
}
