package isp.lab6.exercise3;

import java.util.HashMap;


public class ActiveSession {
    private String username;
    private HashMap<String, Integer> shoppingCart;

    public ActiveSession(String username){
        this.username=username;
        this.shoppingCart = new HashMap<>();
    }

    public void addToCart(String product, int quantity) {
        if (shoppingCart.containsKey(product)) {
            int existingQuantity = shoppingCart.get(product);
            shoppingCart.put(product, existingQuantity + quantity);
        } else {
            shoppingCart.put(product, quantity);
        }
    }
    public HashMap<String, Integer> getShoppingCart() {
        return shoppingCart;
    }
}
