import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileIO
{
    public static ArrayList<String> parseWords(ArrayList<String> array)
    {
        ArrayList<String> parsedWords = new ArrayList<>();
        for (String current : array)
        {
            String[] currentStringArray = current.split(" ");
            for (String individualWord : currentStringArray)
            {
                parsedWords.add(individualWord
                        .replace(",", "")
                        .replace(".", ""));
            }
        }
        return parsedWords;
    }
    public static String findLongestWord(File file)
    {
        ArrayList<String> stringArray = fileToArray(file);
        stringArray = parseWords(stringArray);
        String longestString = stringArray.get(0);
        for (int index = 1; index < stringArray.size(); index++)
        {
            long currentStringLen = stringArray.get(index).length();
            if (currentStringLen > longestString.length())
            {
                longestString = stringArray.get(index);
            }
        }
        return longestString;
    }

    public static ArrayList<String> fileToArray(File file)
    {
        ArrayList<String> fileArray = new ArrayList<>();
        try
        {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean isEndOfFile = false;
            while(!isEndOfFile)
            {
                String line = bufferedReader.readLine();
                if (line != null)
                {
                    if (line.equalsIgnoreCase(""))
                    {
                        fileArray.add(", ,");
                    }
                    else
                    {
                        fileArray.add(line);
                    }
                }
                else
                {
                    isEndOfFile = true;
                }
            }
            return fileArray;
        }
        catch (FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}
