// Unlike FileOutputStream class, you do not need
// to convert a string into a byte array

import java.io.FileWriter;

public class FileWriterExample
{
    public static void main(String args[])
    {
        try
        {
            FileWriter fw = new FileWriter("out.txt");
            fw.write("Welcome to Java");
            fw.close();
        }catch(Exception e){System.out.println(e);}

        System.out.println("Success...");
    }
} 