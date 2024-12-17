package soal1;

public class Cyclinder extends Shape{
    private double radius;
    private double height;

    public Cyclinder(double r , double h) {
        super("Cyclinder");
        radius = r;
        height = h;
    }
    public double area() {
        return Math.PI * (radius * radius) * height;
    }
    public String toString() {
        return super.toString() + " of radius " + radius + " and height" + height;
    }
}
