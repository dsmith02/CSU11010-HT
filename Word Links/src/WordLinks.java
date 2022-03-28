import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/* SELF ASSESSMENT
1. readDictionary
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes
- My method reads the words from the "words.txt" file. [Mark out of 5: 5]
- Comment: Yes
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5: 5]
- Comment: Yes, as an ArrayList of String objects.

2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: All correct.
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5: 5]
- Comment: Yep, delimits based on the commas.

3. isUniqueList
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yep.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5: 5]
- Comment: Yes, very inefficiently, however.
- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
- Comment: Yep using an if-statement.
- Returns true is all the words are unique and false otherwise. [Mark out of 5:]
- Comment: Yes.

4. isEnglishWord
- I have the correct method definition [Mark out of 5:]
- Comment: Yes.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:]
- Comment: Yep, uses the method.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2: 2]
- Comment: Yes, but I test on the opposite condition.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: Yep.

6. isWordChain
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes.
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:]
- Comment: Yes.

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10: 10]
- Comment: Yes.
- Asks the user for input and calls isWordChain [Mark out of 5: 5]
- Comment: Yes, does that.

 Total Mark out of 100 (Add all the previous marks): 100
*/

public class WordLinks
{
    static ArrayList<String> dictionary = null;
    static final String VALID = "Valid chain of words from Lewis Carroll's word-links game.";
    static final String INVALID = "Not a valid chain of words from Lewis Carroll's word-links game.";

    public static void main(String[] args)
    {
        dictionary = readDictionary(new File("words.txt"));
        boolean quit = false;
        while (!quit)
        {
            ArrayList<String> wordList = readWordList();
            if (wordList == null)
            {
                quit = true;
            }
            else
            {
                System.out.println(isWordChain(wordList) ? VALID : INVALID);
            }
        }
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
                String word = bufferedReader.readLine();
                if (word == null)
                {
                    isEndOfFile = true;
                }
                else
                {
                    words.add(word);
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
        String input = "";
        boolean invalidInput = true;
        while (invalidInput)
        {
            System.out.println("Enter a comma separated list of words (or an empty list to quit):");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase(""))
            {
                return null;
            }
            else if (!input.contains(","))
            {
                System.out.println("Invalid input. Please try again.");
            }
            else
            {
                invalidInput = false;
            }
        }
        ArrayList<String> list = new ArrayList<>(List.of(input.trim().split(",")));
        for (int index = 0; index < list.size(); index++)
        {
            list.set(index, list.get(index).trim());
        }
        return list;
    }

    public static boolean isUniqueList(ArrayList<String> wordList)
    {
        for (int index = 0; index < wordList.size(); index++)
        {
            String currentWord = wordList.get(index);
            for (int indexInner = 0; indexInner < wordList.size(); indexInner++)
            {
                String compareWord = wordList.get(indexInner);
                if (currentWord.equalsIgnoreCase(compareWord) && indexInner != index)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEnglishWord(ArrayList<String> wordList, String word)
    {
        if (Arrays.binarySearch(wordList.toArray(), word) < 0)
        {
            return false;
        }
        return true;
    }

    public static boolean isDifferentByOne(String word, String comparison)
    {
        if (word.length() != comparison.length())
        {
            return false;
        }

        int differentCharacters = 0;
        for (int index = 0; index < word.length() && differentCharacters <= 1; index++)
        {
            if (word.charAt(index) != comparison.charAt(index))
            {
                differentCharacters++;
            }
        }
        return differentCharacters == 1;
    }

    public static boolean isWordChain(ArrayList<String> list)
    {
        if (!isUniqueList(list))
        {
            return false;
        }

        for (int index = 1; index < list.size(); index++)
        {
            String currentWord = list.get(index);
            String previousWord = list.get(index - 1);
            if (!isDifferentByOne(currentWord, previousWord) || !isEnglishWord(dictionary, previousWord))
            {
                return false;
            }
        }
        return true;
    }
}
