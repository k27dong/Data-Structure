import java.awt.geom.Area;

public class P2_34 {
    public static void main(String[] args) {    // test
        Square test = new Square(4.0);
        System.out.println(test.area());

        Rectangle test2 = new Rectangle(5, 3);
        System.out.println(test2.area());

        Quadrilateral test3 = new Quadrilateral(5, 3, 5, 3);
        System.out.println(test3.area());
    }
}

interface Polygon {  // default interface for all shapes
    public double area();
    public double perimeter();
}

class Triangle implements Polygon {
    private double base, left, right;
    private double height;

    public Triangle(double b, double h, double l, double r) {
        base = b;
        height = h;
        left = l;
        right = r;
    }

    // parent calculation function should not be overriden
    public double area() {  
        return base * height * 0.5;
    }

    public double perimeter() {
        return base + left + right;
    }
}

class Quadrilateral implements Polygon {
    private double a, b, c, d;

    public Quadrilateral(double p, double q, double r, double s) {
        a = p;
        b = q;
        c = r;
        d = s;
    }

    // parent calculation functions should not be overiden
    public double area() {
        double s = 0.5 * (a + b + c + d);
        return Math.sqrt((s - a) * (s - b) * (s - c) * (s - d));
    }

    public double perimeter() {
        return a + b + c + d;
    }
}

class Equilateral extends Triangle {

    public Equilateral(double b, double h) {
        super(b, h, b, b);
    }

    public Equilateral(double b) {
        super(b, b * 0.5 * Math.sqrt(3), b, b);
    }
}

class Isosceles extends Triangle {
    public Isosceles(double b, double h, double s) {
        super(b, h, s, s);
    }
}

class Rectangle extends Quadrilateral {
    public Rectangle(double l, double h) {
        super (l, h, l, h);
    }
}

class Square extends Rectangle {
    public Square(double s) {
        super (s, s);
    }
}