public class HugeIntegerTest
{
    public static void main(String[] args)
    {
        HugeInteger test = new HugeInteger();
        test.parse("456789");
        System.out.println(test);
    }
}
