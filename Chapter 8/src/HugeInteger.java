import java.util.Arrays;

public class HugeInteger
{
    private int[] digits = new int[40];

    public void parse(String s)
    {
        if (s.length() > digits.length || s == null)
        {
            return;
        }

        int position = digits.length - s.length();
        for (int index = 0; index < s.length(); index++)
        {
            digits[position++] = Integer.parseInt(Character.toString(s.charAt(index)));
        }
    }

    @Override
    public String toString()
    {
        String representation = "";
        for (int digit : digits)
        {
            if (digit > 0)
            {
                representation += String.valueOf(digit);
            }
        }
        return representation;
    }

    public void add(HugeInteger i)
    {

    }

    public void subtract(HugeInteger i)
    {

    }
}
