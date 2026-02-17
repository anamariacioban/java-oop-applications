package isp.lab5.exercise1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private LocalDateTime date;
    private double totalPrice=0;
    private List<Product> products;
    private Customer customer;

    public Order(String orderId, LocalDateTime date, Customer customer) {
        this.orderId = orderId;
        this.date = date;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Product product) {
        if (products.size() >= 10) {
            throw new IllegalStateException("Nu putem adăuga mai mult de 10 produse la o comandă!");
        }
        products.add(product);
        totalPrice =totalPrice+ product.getPrice();
    }
}
