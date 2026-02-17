package isp.lab6.exercise3;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private LoginSystem loginSyst;
    private OnlineStore store;

    public UserInterface(LoginSystem loginSyst, OnlineStore store){
        this.loginSyst=loginSyst;
        this.store=store;
    }

    public void loadInterface() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n- Main Menu -");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Show Products");
            System.out.println("4. Show Sorted Products");
            System.out.println("5. Add Product to Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    loginSyst.register(username, password);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    if (loginSyst.login(loginUsername, loginPassword)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid credentials!");
                    }
                    break;

                case 3:
                    System.out.println("Products in store:");
                    List<Product> products = store.getProducts();
                    for (int i = 0; i < products.size(); i++) {
                        Product product = products.get(i);
                        System.out.println(product.getName() + " " + product.getPrice() + " lei");
                    }
                    break;


                case 4:
                    System.out.println("Choose sorting criteria:");
                    System.out.println("1. Sort by name");
                    System.out.println("2. Sort by price");

                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();

                    List<Product> sortedProducts = null;
                    if (sortChoice == 1) {
                        sortedProducts = store.getProductsSorted(Comparator.comparing(Product::getName));
                    } else if (sortChoice == 2) {
                        sortedProducts = store.getProductsSorted(Comparator.comparing(Product::getPrice));
                    } else {
                        System.out.println("Invalid choice.");
                        break;
                    }

                    System.out.println("Sorted Products:");
                    for (int i = 0; i < sortedProducts.size(); i++) {
                        Product product = sortedProducts.get(i);
                        System.out.println(product.getName() + " " + product.getPrice() + " lei");
                    }

                case 5:
                    System.out.print("Enter username: ");
                    String cartUsername = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    store.addToCart(cartUsername, productName, quantity);
                    break;

                case 6:
                    System.out.print("Enter username: ");
                    String checkoutUsername = scanner.nextLine();
                    System.out.println(store.checkout(checkoutUsername));
                    break;

                case 7:
                    System.out.println("Exiting...");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

}
