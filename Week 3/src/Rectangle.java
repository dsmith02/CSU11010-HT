public class Rectangle implements Shape
{
    private double length;
    private double width;

    public double getArea()
    {
        return (length * width);
    }

    public String toString()
    {
        return "Length: " + length
                + "\nWidth: " + width
                + "\nArea: " + getArea();
    }
}
