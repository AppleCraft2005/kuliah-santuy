package soal1;

abstract class Shape {
    protected String shapeName;

    public abstract double area();
    
    // addon dari GPT    
    public Shape(String shapeName) { 
        this.shapeName = shapeName;
    }
    public String toString(String shapeName) {
        return shapeName;
    }
}
