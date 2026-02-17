package isp.lab6.exercise3;

import java.util.*;

public class OnlineStore {
    private List<Product> products;
    private HashMap<String, ActiveSession> sessions;
    public OnlineStore()
    {
        this.products = new ArrayList<>();
        this.sessions = new HashMap<>();
    }
    public List<Product> getProducts() {
        return products;
    }
    public List<Product> getProductsSorted(Comparator<Product> sortCriteria) {
        List<Product> sortedList = new ArrayList<>(products);
        Collections.sort(sortedList, sortCriteria);
        return sortedList;
    }
    public void addSession(String username) {
        sessions.put(username, new ActiveSession(username));
    }
    public void removeSession(String username) {
        sessions.remove(username);
    }
    public void addToCart(String username, String product, int quantity) {
        ActiveSession session = sessions.get(username);
        if (session != null) {
            session.addToCart(product, quantity);
        } else {
            System.out.println("User is not logged in.");
        }
    }
    public String checkout(String username) {
        ActiveSession session = sessions.get(username);
        if (session == null || session.getShoppingCart().isEmpty()) {
            return "Cart is empty or user not logged in.";
        }

        double total = 0;
        List<String> productNames = new ArrayList<>(session.getShoppingCart().keySet());

        for (int i = 0; i < productNames.size(); i++) {
            String productName = productNames.get(i);
            Product product = findProductByName(productName);
            if (product != null) {
                total += product.getPrice() * session.getShoppingCart().get(productName);
            }
        }

        return "Total: " + total + " lei";
    }

    private Product findProductByName(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                return products.get(i);
            }
        }
        return null;
    }
    public ActiveSession getSession(String username) {
        return sessions.get(username);
    }

}
