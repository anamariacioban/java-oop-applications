package isp.lab5.exercise1;

import java.time.LocalDateTime;

public class Exercise1 {

    public static void main(String[] args) {
        Address address = new Address("Strada Caminului", "Alba Iulia");
        Customer customer = new Customer("123", "Dimofte Andrei", "0785472365", address);
        Product product1 = new Product("584", "Masina de tuns iarba", 754.54, ProductCategory.HOME_AND_GARDEN);
        Product product2 = new Product("124", "beauty blender", 89.75, ProductCategory.BEAUTY);
        Product product3 = new Product("21", "ball", 74.426, ProductCategory.TOYS);
        Order order = new Order("214789", LocalDateTime.of(2024, 12, 6, 10, 30), customer);
        order.addProduct(product1);
        order.addProduct(product2);
        order.addProduct(product3);

        System.out.println("Despre client:" + customer.getCustomerId() + " " + customer.getName() + " " + customer.getPhone() + " " + customer.getAddress());
        System.out.println("Despre order:" + order.getOrderId() + " " + order.getDate()+ " " + order.getTotalPrice());
        System.out.println("adresa:" + address.getCity() + " " + address.getStreet());

    }
}
