import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer
{
    public C4HumanPlayer(int playerID)
    {
        super(playerID);
    }

    @Override
    public int chooseColumn()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the column of your next move> ");
        while (!scanner.hasNextInt())
        {
            scanner.nextLine();
            System.out.print("You must enter an integer!");
            System.out.print("\nPlease enter the column of your next move> ");
        }
        return scanner.nextInt();
    }
}
