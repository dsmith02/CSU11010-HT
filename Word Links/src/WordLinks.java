import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordLinks
{
    public static void main(String[] args)
    {

    }

    public static ArrayList<String> readDictionary(File file)
    {
        ArrayList<String> words = new ArrayList<>();
        try
        {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            boolean isEndOfFile = false;
            while (!isEndOfFile)
            {
                if (bufferedReader.readLine() == null)
                {
                    isEndOfFile = true;
                }
                else
                {
                    words.add(bufferedReader.readLine());
                }
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return words;
    }

    public static ArrayList<String> readWordList()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a comma separated list of words (or an empty list to quit):");
        return new ArrayList<>(List.of(scanner.nextLine().split(", ")));
    }
}
