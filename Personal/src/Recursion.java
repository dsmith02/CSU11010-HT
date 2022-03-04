public class Recursion
{
    public static void main(String[] args)
    {
        System.out.println(power(2, 3));
    }

    public static int power(int x, int n)
    {
        int result = 1;
        if (n != 0)
        {
            result = x * power(x, n - 1);
        }
        return result;
    }
}
