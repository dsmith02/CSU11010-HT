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
    static ArrayList<Integer> gradeList = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        do
        {
            boolean correctInput = false;
            System.out.print("Enter the grade you wish to convert> ");
            while(!correctInput)
            {
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("quit"))
                {
                    break;
                }
                System.out.println("Invalid input! It must be a decimal number!");
                System.out.print("Enter the grade you wish to convert> ");
            }
            double percentage = scanner.nextDouble();
            if (!input.equalsIgnoreCase("quit"))
            {

            }
        } while (!input.equalsIgnoreCase("quit"));
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
