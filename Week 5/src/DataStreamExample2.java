// FileInputStream: Read all bytes

import java.io.FileInputStream;

public class DataStreamExample2
{
    public static void main(String args[])
    {
        try
        {
            FileInputStream fin = new FileInputStream("out.txt");
            int i=0;
            // Reads all bytes until the byte is equal to -1 i.e. end of file marker
            while((i=fin.read())!=-1)
            {
                System.out.print((char)i);
            }
            fin.close();
        }catch(Exception e){System.err.println(e);}
    }
}