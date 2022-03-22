import java.util.Scanner;

public class Lotto
{
    static final String VALID_OPTION = "([a-f]|[A-F])";
    static final String DIVIDER = "********************";
    static final String MENU = "Please select one of the following options:" +
        "\nA. Enter your six numbers" +
        "\nB. Display your six chosen numbers" +
        "\nC. Sort the numbers in ascending order" +
        "\nD. Check for win" +
        "\nE. Display frequency of chosen numbers in current run" +
        "\nF. Exit program" +
        "\nPlease enter your option> ";
    static final Scanner scanner = new Scanner(System.in);
    static final char EXIT_PROGRAM = 'f';

    public static void main(String[] args)
    {
        char option = getOption();
        while (option != EXIT_PROGRAM)
        {

        }
    }

    public static char getOption()
    {
        System.out.println(DIVIDER);
        System.out.print("Welcome to the Lottery! " + MENU);
        String option = scanner.nextLine();
        while (!option.matches(VALID_OPTION))
        {
            System.out.println("Invalid option!");
            System.out.print(MENU);
            option = scanner.nextLine();
        }
        return option.toLowerCase().charAt(0);
    }
}
