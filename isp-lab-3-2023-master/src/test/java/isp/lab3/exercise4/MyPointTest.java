package isp.lab3.exercise4;


import org.junit.Assert;
import org.junit.Test;

public class MyPointTest {
    @Test
    public void testDistance() {
        MyPoint point1 = new MyPoint(0, 0, 0);
        MyPoint point2 = new MyPoint(3, 4, 5);
        MyPoint point3 = new MyPoint(7, 4, 9);
        MyPoint point4 = new MyPoint();

        double expectedDistance1 = Math.sqrt(1 * 1 + 2 * 2 + 3 * 3);
        double actualDistance1 = point1.distance(1, 2, 3);

        Assert.assertEquals("1 Distanța calculată nu este corectă!", expectedDistance1, actualDistance1, 0.0001);

        double expectedDistance2 = Math.sqrt(3 * 3 + 4 * 4 + 5 * 5);
        double actualDistance2 = point2.distance(0, 0, 0);
        Assert.assertEquals("2 Distanța calculata nu este corecta", expectedDistance2, actualDistance2, 0.0001);

        double expectedDistance3 = Math.sqrt(3 * 3 + 4 * 4 + 5 * 5);
        double actualDistance3 = point1.distance(point2);
        Assert.assertEquals("3 Distanța calculata nu este corecta", expectedDistance3, actualDistance3, 0.0001);


        double expectedDistance4 = Math.sqrt(4 * 4 + 0 * 0 + 4 * 4);
        double actualDistance4 = point3.distance(point2);
        Assert.assertEquals("4 Distanța calculata nu este corecta", expectedDistance4, actualDistance4, 0.0001);


        double expectedDistance5 = Math.sqrt(7 * 7 + 4 * 4 + 9 * 9);
        double actualDistance5 = point3.distance(point4);
        Assert.assertEquals("5 Distanța calculata nu este corecta", expectedDistance5, actualDistance5, 0.0001);
    }
}
