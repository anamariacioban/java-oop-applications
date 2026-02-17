package isp.lab7.safehome;
import java.util.List;
import java.util.Scanner;

public class SafeHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoorLockController controller = new DoorLockController();

        while (true) {
            System.out.println("Select user type: 0 Exit 1 Admin 2 Tenant");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            if (choice == 1) {
                System.out.println("Admin options: 1) Add Tenant 2) Remove Tenant 3) View Logs");
                int adminChoice = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (adminChoice) {
                        case 1:
                            System.out.println("Enter tenant name:");
                            String name = scanner.nextLine();
                            System.out.println("Enter tenant pin:");
                            String pin = scanner.nextLine();
                            controller.addTenant(pin, name);
                            System.out.println("Tenant added.");
                            break;
                        case 2:
                            System.out.println("Enter tenant name:");
                            String removeName = scanner.nextLine();
                            controller.removeTenant(removeName);
                            System.out.println("Tenant removed.");
                            break;
                        case 3:
                            List<AccessLog> logs = controller.getAccessLogs();
                            for (int i = 0; i < logs.size(); i++) {
                                System.out.println(logs.get(i));
                            }
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getClass().getSimpleName());
                }
            } else if (choice == 2) {
                System.out.println("Enter your pin:");
                String pin = scanner.nextLine();
                try {
                    DoorStatus status = controller.enterPin(pin);
                    System.out.println("Door is now " + status);
                } catch (Exception e) {
                    System.out.println("Access Denied: " + e.getClass().getSimpleName());
                }
            }
        }
        scanner.close();
    }
}
