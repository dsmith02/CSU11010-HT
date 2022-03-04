public class MethodOverload
{
    public static int square(int value)
    {
        return value * value;
    }

    public static double square(double value)
    {
        return value * value;
    }

    public static void main(String[] args)
    {
        int value = 2;
        System.out.println(square(value));
        double variable = 3.0;
        System.out.println(square(variable));
    }
}
