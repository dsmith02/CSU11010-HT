import java.io.File;
import java.util.ArrayList;

public class WordLinksTest
{
    public static void main(String[] args)
    {
        ArrayList<String> dictionary = WordLinks.readDictionary(new File("words.txt"));
        System.out.println(WordLinks.isEnglishWord(dictionary, "smile"));
    }
}
