package soal1;

import java.text.DecimalFormat;

abstract class Shape {
    protected String shapeName;

    public abstract double area();
    
    // addon dari GPT    
    public Shape(String shapeName) { 
        this.shapeName = shapeName;
    }
    public String toString() {
        return shapeName;
    }
}

class Sphere extends Shape{
    private double radius;

    public Sphere(double r) {
        super("Sphere");
        radius = r;
    }
    @Override
    public double area() {
        return 4 * Math.PI * (radius * radius);
    }
    @Override
    public String toString() {
        return super.toString() + " of radius " + radius;
    }
}

class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle(double l , double w) {
        super("Rectangle");
        length = l;
        width = w;
    }
    @Override
    public double area() {
        return length * width;
    }
    @Override
    public String toString() {
        return super.toString() + " of length " + length + " cm and width" + width + " cm" ;
    }
}

class Cylinder extends Shape{
    private double radius;
    private double height;

    public Cylinder(double r , double h) {
        super("Cylinder");
        radius = r;
        height = h;
    }
    @Override
    public double area() {
        return Math.PI * (radius * radius) * height;
    }
    @Override
    public String toString() {
        return super.toString() + " of radius " + radius + " and height" + height;
    }
}

class Paint {
    private double coverage;

    public Paint(double c) {
        coverage = c;
    }
    public double amount(Shape s) {
        System.out.println("Computing amount for " + s);
        return s.area() / coverage;
    }
}

public class PaintThings {
    public static void main (String[] args) {
        final double COVERAGE = 350;
        Paint paint = new Paint(COVERAGE);
        Rectangle deck;
        Sphere bigBall;
        Cylinder tank;
        double deckAmt, ballAmt, tankAmt;

        deck = new Rectangle(20, 30);
        bigBall = new Sphere(15);
        tank = new Cylinder(10,30);

        ballAmt = paint.amount(bigBall);
        deckAmt = paint.amount(deck);
        tankAmt = paint.amount(tank);

        DecimalFormat fmt = new DecimalFormat("0.#");
        System.out.println("\nNumber of gallons of paint needed...");
        System.out.println("Deck " + fmt.format(deckAmt));
        System.out.println("Big Ball " + fmt.format(ballAmt));
        System.out.println("Tank " + fmt.format(tankAmt));

    }
}
