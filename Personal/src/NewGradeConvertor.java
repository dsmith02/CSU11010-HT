import java.util.ArrayList;
import java.util.Scanner;

public class NewGradeConvertor
{
    static final double COMPENSATION_BOUNDARY = 3.5;
    static final int LOWER_FAIL_CODE = 0;
    static final int COMPENSATED_FAIL_CODE = 1;
    static final int THIRD_CLASS_CODE = 2;
    static final int SECOND_CLASS_TWO_CODE = 3;
    static final int SECOND_CLASS_ONE_CODE = 4;
    static final int FIRST_CLASS_CODE = 5;
    static final String END_PROGRAM = "quit";
    static final String VALID_PERCENTAGE = "(100.?0?|[0-9]+.?[0-9]*|quit|QUIT)";
    static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> gradeList = new ArrayList<>();

    public static void main(String[] args)
    {
        String userInput = "";
        while (!userInput.equalsIgnoreCase(END_PROGRAM))
        {

        }
    }

    public static String getUserInput()
    {
        System.out.print("Enter the grade you wish to convert> ");
        String input = scanner.nextLine();
        while (!input.matches(VALID_PERCENTAGE))
        {
            System.out.println("Invalid percentage. Number must be -> 0.0 <= number <= 100.0");
            System.out.print("Enter the grade you wish to convert> ");
            input = scanner.nextLine();
        }
        return input;
    }
    public static void computeGradeClass(double percentage)
    {
        int numberOfTens = (int) percentage / 10;
        switch (numberOfTens)
        {
            case 1:
            case 2:
            case 3:
                if (percentage / 10 <= COMPENSATION_BOUNDARY)
                {
                    addGradeToList(LOWER_FAIL_CODE);
                }
                else
                {
                    addGradeToList(COMPENSATED_FAIL_CODE);
                }
                break;
            case 4:
                addGradeToList(THIRD_CLASS_CODE);
                break;
            case 5:
                addGradeToList(SECOND_CLASS_TWO_CODE);
                break;
            case 6:
                addGradeToList(SECOND_CLASS_ONE_CODE);
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                addGradeToList(FIRST_CLASS_CODE);
        }
    }

    public static void addGradeToList(int code)
    {
        gradeList.set(code, gradeList.get(code) + 1);
    }
}
