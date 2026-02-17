package isp.lab5.exercise2;

import org.junit.Assert;
import org.junit.Test;

public class exercise2Test {
    @Test
    public void chargeTest(){
        Laptop laptop=new Laptop();
        laptop.charge(15);
        Assert.assertEquals(75, laptop.getBatteryLevel());
        laptop.charge(50);
        Assert.assertEquals(100, laptop.getBatteryLevel());

        SmartPhone smartPhone=new SmartPhone();
        smartPhone.charge(20);
        Assert.assertEquals(60, smartPhone.getBatteryLevel());
        smartPhone.charge(80);
        Assert.assertEquals(100, smartPhone.getBatteryLevel());

        SmartWatch smartWatch=new SmartWatch();
        smartWatch.charge(2);
        Assert.assertEquals(40, smartWatch.getBatteryLevel());
        smartWatch.charge(30);
        Assert.assertEquals(100, smartPhone.getBatteryLevel());

    }
}
