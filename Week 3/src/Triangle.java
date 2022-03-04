public class Triangle
{
    private double base;
    private double height;

    public double getArea()
    {
        // 1/2 of base by perpendicular height
        return 0.5 * base * height;
    }

    public String toString()
    {
        return "Base: " + base
                + "\nHeight: " + height
                + "\nArea: " + getArea();
    }
}
