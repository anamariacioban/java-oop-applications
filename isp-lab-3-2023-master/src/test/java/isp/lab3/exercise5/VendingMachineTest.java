package isp.lab3.exercise5;

import org.junit.Assert;
import org.junit.Test;


public class VendingMachineTest {
    @Test
    public void testInsertCoin() {
        VendingMachine vm = new VendingMachine();
        vm.insertCoin(10);
        vm.insertCoin(5);

        Assert.assertEquals(15, vm.getCredit());

        vm.insertCoin(-5);
        Assert.assertEquals(15, vm.getCredit());


    }

    @Test
    public void testDisplayProducts() {
        VendingMachine vendingMachine = new VendingMachine();

        String[] expectedProducts = {
                "1. Water - 5 credite",
                "2. Soda - 7 credite",
                "3. Chips - 10 credite",
                "4. Chocolate - 12 credite"
        };
        Assert.assertEquals("Lista produselor nu este corectă!", expectedProducts, vendingMachine.getProduct());
    }

    @Test
    public void testSelectProduct() {
        VendingMachine vm = new VendingMachine();
        vm.insertCoin(10);

        String result1 = vm.selectProduct(1);
        Assert.assertTrue(result1.contains("a fost eliberat"));

        String result2 = vm.selectProduct(3);
        Assert.assertEquals("Credit insuficient!", result2);

        String result3 = vm.selectProduct(10);
        Assert.assertEquals("Produs invalid!", result3);
    }
}
