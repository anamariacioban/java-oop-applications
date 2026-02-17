package isp.lab8.airways;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void saveWaypoint(Waypoint waypoint, String routeName) throws Exception {
        File folder = new File("routes", routeName);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (created) {
                System.out.println("Directorul a fost creat cu succes: " + folder.getAbsolutePath());
            } else {
                System.out.println("A apărut o problemă la crearea directorului.");
            }
        }
        mapper.writeValue(new File(folder, waypoint.getName() + ".json"), waypoint);
    }

    public static Waypoint loadWaypoint(String filePath) throws Exception {
        return mapper.readValue(new File(filePath), Waypoint.class);
    }
}
