package isp.lab6.exercise3;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class TestExercise3 {
    @Test
    public void testRegisterSuccess() {
        OnlineStore store = new OnlineStore();
        LoginSystem loginSystem = new LoginSystem(store);
        loginSystem.register("mara123", "maraa");
        assertTrue(loginSystem.login("mara123", "maraa"));
    }
    @Test
    public void testShowProducts() {
        OnlineStore store = new OnlineStore();
        List<Product> products = store.getProducts();

        store.getProducts().add(new Product("Laptop", 7852.22));
        store.getProducts().add(new Product("Telefon", 2250.50));
        store.getProducts().add(new Product("Casti", 750.99));


        assertEquals(3, products.size());
        assertEquals("Laptop", products.get(0).getName());
        assertEquals(7852.22, products.get(0).getPrice(), 0.001);
        assertEquals("Telefon", products.get(1).getName());
        assertEquals(2250.50, products.get(1).getPrice(), 0.001);
        assertEquals("Casti", products.get(2).getName());
        assertEquals(750.99, products.get(2).getPrice(), 0.001);
    }
    @Test
    public void testSortedProductsByName() {
        OnlineStore store = new OnlineStore();

        store.getProducts().add(new Product("Laptop", 7852.22));
        store.getProducts().add(new Product("Telefon", 2250.50));
        store.getProducts().add(new Product("Casti", 750.99));

        List<Product> sorted = store.getProductsSorted(Comparator.comparing(Product::getName));

        assertEquals("Casti", sorted.get(0).getName());
        assertEquals("Laptop", sorted.get(1).getName());
        assertEquals("Telefon", sorted.get(2).getName());
    }
    @Test
    public void testSortedProductsByPrice() {
        OnlineStore store = new OnlineStore();

        store.getProducts().add(new Product("Laptop", 7852.22));
        store.getProducts().add(new Product("Telefon", 2250.50));
        store.getProducts().add(new Product("Casti", 750.99));

        List<Product> sorted = store.getProductsSorted(Comparator.comparingDouble(Product::getPrice));

        assertEquals("Casti", sorted.get(0).getName());
        assertEquals("Telefon", sorted.get(1).getName());
        assertEquals("Laptop", sorted.get(2).getName());


        assertEquals(750.99, sorted.get(0).getPrice(), 0.001);
        assertEquals(2250.50, sorted.get(1).getPrice(), 0.001);
        assertEquals(7852.22, sorted.get(2).getPrice(), 0.001);
    }
    @Test
    public void testAddProductToCart() {
        OnlineStore store = new OnlineStore();
        LoginSystem loginSystem = new LoginSystem(store);

        loginSystem.register("ana", "parola123");
        assertTrue(loginSystem.login("ana", "parola123"));

        Product produs = new Product("Mouse", 99.99);
        store.getProducts().add(produs);
        store.addToCart("ana", "Mouse", 2);

        ActiveSession sesiune = store.getSession("ana");
        int cantitate = sesiune.getShoppingCart().get("Mouse");
        assertEquals(2, cantitate);
    }
    @Test
    public void testCheckout() {
        OnlineStore store = new OnlineStore();
        LoginSystem loginSystem = new LoginSystem(store);

        store.getProducts().add(new Product("Laptop", 7852.22));
        store.getProducts().add(new Product("Telefon", 2250.50));
        store.getProducts().add(new Product("Casti", 750.99));
        loginSystem.register("mara123", "maraa");

        boolean loggedIn = loginSystem.login("mara123", "maraa");
        assertTrue(loggedIn);

        store.addToCart("mara123", "Laptop", 1);
        store.addToCart("mara123", "Telefon", 2);
        String checkoutMessage = store.checkout("mara123");

        double expectedTotal = 7852.22 + 4501.00;
        assertEquals(12353.22, expectedTotal, 0.001);
    }
}

