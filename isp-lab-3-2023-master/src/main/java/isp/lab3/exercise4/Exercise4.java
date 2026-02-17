package isp.lab3.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint();
        MyPoint point2 = new MyPoint(3, 4, 5);

        double dist = point1.distance(point2);

        System.out.println("Distanța între punctele " + point1 + " și " + point2 + " este: " + dist);
    }
}
