import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileOutputStreamExample1
{
    public static void main(String[] args)
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            // Writes bytes to specified text file.
            FileOutputStream fOut = new FileOutputStream("out.txt");
            /*
            Gets input from the user and converts the string to bytes, storing
            them in an array.
             */
            byte[] array = scanner.nextLine().getBytes(StandardCharsets.UTF_8);
            /*
            Writes the byte array to the passed text file and they are encoded as
            Unicode characters.
             */
            fOut.write(array);
            // Prevents any memory/resource leaks.
            fOut.close();
            System.out.println("Success");
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
}
