package isp.lab5.exercise1;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Radu Miron
 * @version 1
 */
public class Exercise1Test {
    @Test
    public void totalPriceTest(){
        Address address = new Address("Strada Alba Iulia", "Alba Iulia");
        Customer customer = new Customer("123", "Dimofte Andrei", "0785472365", address);
        Product product1 = new Product("1", "Masina de tuns iarba", 754.54, ProductCategory.HOME_AND_GARDEN);
        Product product2 = new Product("2", "beauty blender", 89.75, ProductCategory.BEAUTY);
        Product product3 = new Product("3", "ball", 74.426, ProductCategory.TOYS);
        Product product4= new Product("4", "Red dress", 120.0, ProductCategory.FASHION);
        Product product5=new Product ("5", "Cuptor cu microunde", 450.8, ProductCategory.ELECTRONICS);
        Product product6=new Product("6", "Blush", 80, ProductCategory.BEAUTY);
        Product product7=new Product("7", "Foarfeca de gradinarit", 100, ProductCategory.HOME_AND_GARDEN);
        Product product8=new Product("8", "Papusa Barbie", 75, ProductCategory.TOYS);
        Product product9=new Product("9", "Ondulator", 200, ProductCategory.ELECTRONICS);
        Product product10=new Product("10", "Ruj", 140, ProductCategory.BEAUTY);
        Product product11=new Product("11", "Lego", 250, ProductCategory.TOYS);

        Order order = new Order("214789", LocalDateTime.of(2024, 12, 6, 10, 30), customer);
        Assert.assertEquals(0.0, order.getTotalPrice(), 0.001);
        order.addProduct(product1);
        Assert.assertEquals(754.54, order.getTotalPrice(), 0.001);
        order.addProduct(product2);
        Assert.assertEquals(844.29, order.getTotalPrice(), 0.001);
        order.addProduct(product3);
        Assert.assertEquals(918.716, order.getTotalPrice(), 0.001);
        order.addProduct(product4);
        Assert.assertEquals(1038.716, order.getTotalPrice(), 0.001);
        order.addProduct(product5);
        Assert.assertEquals(1489.516, order.getTotalPrice(), 0.001);
        order.addProduct(product6);
        Assert.assertEquals(1569.516, order.getTotalPrice(), 0.001);
        order.addProduct(product7);
        Assert.assertEquals(1669.516, order.getTotalPrice(), 0.001);
        order.addProduct(product8);
        Assert.assertEquals(1744.516, order.getTotalPrice(), 0.001);
        order.addProduct(product9);
        Assert.assertEquals(1944.516, order.getTotalPrice(), 0.001);
        order.addProduct(product10);
        Assert.assertEquals(2084.516, order.getTotalPrice(), 0.001);
        try {
            order.addProduct(product11);
            Assert.fail("Ar fi trebuit să avem exceptie pt ca putem avea max 10 produse in cos!");
        } catch (IllegalStateException e) {
        }
    }
}
