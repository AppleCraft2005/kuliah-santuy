package soal1;

public abstract class Shape {
    protected String shapeName;

    public abstract double area();
    
    public Shape(String ShapeName) { 
        shapeName = ShapeName;
    }
    public String toString() {
        return shapeName;
    }
}
