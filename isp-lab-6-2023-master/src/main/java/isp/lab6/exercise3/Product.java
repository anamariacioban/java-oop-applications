package isp.lab6.exercise3;

import java.util.Objects;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price)
    {
        this.name=name;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
