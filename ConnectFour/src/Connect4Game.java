import java.util.Scanner;

public class Connect4Game
{
    /* SELF ASSESSMENT
Connect4Game class (35 marks) 35
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win.
Comment: Yes, all references are created and I ask the user would they like to play.

Connect4Grid interface (10 marks) 10
I define all 7 methods within this interface.
Comment: Yep.

Connect4Grid2DArray class (25 marks) 25
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: All done.

ConnectPlayer abstract class (10 marks) 10
My class provides at lest one non-abstract method and at least one abstract method.
Comment: chooseColumn (abstract) and getPlayerID (concrete).

C4HumanPlayer class (10 marks) 10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment: Provides its own functionality for choosing a piece.

C4RandomAIPlayer class (10 marks) 10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality.
Comment: Provides AI functionality.
Total Marks out of 100: 100
 */
    public static final Scanner scanner = new Scanner(System.in);
    private static String input;
    private static String PLAYER_SELECTION_REGEX = "(Y|N|y|n)";
    private static Connect4Grid2DArray grid;
    private static ConnectPlayer playerOne;
    private static ConnectPlayer playerTwo;
    private static ConnectPlayer winner;

    public static void main(String[] args)
    {
        System.out.println("Welcome to the Connect-4 Game." +
                "\nProgrammed by Diarmuid Smith for CSU11010 @ TCD." +
                "\nPlayer 1 shall be reds." +
                "\nPlayer 2 shall be yellows." +
                "\nThis game supports functionality for both human and AI players.");
        System.out.print("Press enter to play or type quit> ");
        while (!scanner.nextLine().equalsIgnoreCase("quit"))
        {
            // Setup player and grid.
            playerOne = setupPlayer(ConnectPlayer.PLAYER_ONE_ID);
            playerTwo = setupPlayer(ConnectPlayer.PLAYER_TWO_ID);
            grid = new Connect4Grid2DArray();
            while (!grid.isGridFull() && winner == null)
            {
                System.out.println(grid);
                makeMove(playerOne);
                System.out.println(grid);
                if (grid.didLastPieceConnect4())
                {
                    winner = playerOne;
                }
                else
                {
                    makeMove(playerTwo);
                    System.out.println(grid);
                    if (grid.didLastPieceConnect4())
                    {
                        winner = playerTwo;
                    }
                }
            }
            System.out.printf("The game ended with a %s", winner == null ? "draw."
                    : winner == playerOne ? "win for player 1." : "win for player 2.");
            System.out.print("\nThank you for playing. Goodbye");
            break;
        }
    }

    private static void makeMove(ConnectPlayer player)
    {
        int column = player.chooseColumn() - 1;
        while (!grid.isValidColumn(column) || grid.isColumnFull(column))
        {
            System.out.println("Your column choice is invalid. Please choose again.");
            column = player.chooseColumn() - 1;
        }
        grid.dropPiece(player, column);
    }

    private static ConnectPlayer setupPlayer(int playerID)
    {
        System.out.printf("Do you or someone else wish to play as player %d (Y/N)?" +
                "\nSelection> ", playerID);
        while (!(input = scanner.nextLine()).matches(PLAYER_SELECTION_REGEX))
        {
            System.out.printf("Invalid selection. You must enter either Y or N." +
                    "\nDo you or someone else wish to play as player %d (Y/N)?" +
                    "\nSelection> ", playerID);
        }
        return (input.equalsIgnoreCase("y")) ? new C4HumanPlayer(playerID) : new C4RandomAIPlayer(playerID);
    }
}
