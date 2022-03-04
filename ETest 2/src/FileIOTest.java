import java.io.File;
import java.util.ArrayList;

public class FileIOTest
{
    public static void main(String[] args)
    {
        File file = new File("example.txt");
        ArrayList<String> fileAsArray = FileIO.fileToArray(file);
        String longestWord = FileIO.findLongestWord(file);
        System.out.println("The longest word in the file is: " + longestWord);
        System.out.print("The lines of the file are:\n[");
        int lastIndex = fileAsArray.size() - 1;
        for (int index = 0; index < fileAsArray.size(); index++)
        {
            String line = fileAsArray.get(index);
            String endOfLineString = (index == lastIndex) ? "]" : "";
            System.out.print(line + endOfLineString);
        }

    }
}
