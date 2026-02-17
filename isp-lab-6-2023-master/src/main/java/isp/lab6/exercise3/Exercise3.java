package isp.lab6.exercise3;

public class Exercise3 {

    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();
        LoginSystem loginSystem = new LoginSystem(store);

        // Produse in magazin
        store.getProducts().add(new Product("Laptop", 8499.99));
        store.getProducts().add(new Product("Smartphone", 5499.99));
        store.getProducts().add(new Product("Headphones", 699.99));

        UserInterface ui = new UserInterface(loginSystem, store);
        ui.loadInterface();

    }
}
