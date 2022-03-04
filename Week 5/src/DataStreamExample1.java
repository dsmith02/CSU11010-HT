// FileInputStream: Read a single byte

import java.io.FileInputStream;

public class DataStreamExample1
{
    public static void main(String args[])
    {
        try
        {
            // Stream will read in bytes from passed txt file.
            FileInputStream fin = new  FileInputStream("out.txt");
            // Reads the next byte from the text file, storing it as an int.
            int i = fin.read();
            // Prints the character equivalent of the integer read in from the file.
            System.out.println((char)i);
            fin.close();
        }catch(Exception e){System.err.println(e);}
    }
} 