import java.util.Scanner;

public class NoughtsAndCrosses
{
    public static final char BLANK = ' ';
    public static final char NOUGHT = 'O';
    public static final char CROSS = 'X';
    public static final int BOARD_SIZE = 3;

    public static void main(String[] args)
    {
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
        clearBoard(board);
        char currentPlayerPiece = CROSS;
        Scanner input = new Scanner(System.in);
        while ((!isBoardFull(board)) && (winner(board) == BLANK))
        {
            printBoard(board);
            int row = -1;
            int column = -1;
            do
            {
                System.out.print("Enter move for " + currentPlayerPiece + ": ");
                char[] inputCharacters = input.next().toCharArray();
                if ((inputCharacters.length >= 2) &&
                        (inputCharacters[0] >= 'A') && (inputCharacters[0] <= 'C') &&
                        (inputCharacters[1] >= '1') && (inputCharacters[1] <= '3'))
                {
                    row = (int) (inputCharacters[0] - 'A');
                    column = (int) (inputCharacters[1] - '1');
                    if (!canMakeMove(board, row, column))
                        System.out.println(" Invalid entry. This location is already occupied.");
                }
                else System.out.println(" Invalid entry. You must enter a row and column  (e.g.B2 is the center piece on the board).");
            } while ((row == -1) || (!canMakeMove(board, row, column)));
            makeMove(board, currentPlayerPiece, row, column);
            currentPlayerPiece = (currentPlayerPiece == CROSS) ? NOUGHT : CROSS;
        }
        printBoard(board);
        if (winner(board) == BLANK)
            System.out.println("It was a draw.");
        else System.out.println("The winner was " + winner(board));
        input.close();
    }

    public static void clearBoard(char[][] board)
    {
        if (board == null)
        {
            return;
        }

        for (int row = 0; row < board.length; row++)
        {
            for (int column = 0; column < board.length; column++)
            {
                board[row][column] = BLANK;
            }
        }
    }

    public static boolean isBoardFull(char[][] board)
    {
        if (board == null)
        {
             return false;
        }

        for (int row = 0; row < board.length; row++)
        {
            for (int column = 0; column < board.length; column++)
            {
                if (board[row][column] == BLANK)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static char winner(char[][] boards)
    {
        return BLANK;
    }

    public static void printBoard(char[][] board)
    {
        String[] printBoard = {" ---|---|---", "A " + board[0][0] + " |" + board[0][1] + "  |" + board[0][2],
                "B " + board[1][0] + " |" + board[1][1] + "  |" + board[1][2],
                "C " + board[2][0] + " |" + board[2][1] + "  |" + board[2][2], "  1   2   3"};
        System.out.println(printBoard[1] + "\n" + printBoard[0] + "\n" + printBoard[2] + "\n" + printBoard[0] + "\n" + printBoard[3] + "\n" + printBoard[4]);
    }

    public static boolean canMakeMove(char[][] board, int row, int column)
    {
        if (board[row][column] == BLANK)
        {
            return true;
        }
        return false;
    }

    public static void makeMove(char[][] board, char currentPlayerPiece, int row, int column)
    {
        board[row][column] = currentPlayerPiece;
    }
}
