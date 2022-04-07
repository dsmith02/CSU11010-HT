import java.lang.reflect.Field;

public class Connect4Grid2DArray implements Connect4Grid
{
    public static final int NUM_GRID_COLUMNS = 7;
    public static final int NUM_GRID_ROWS = 6;
    public static final int NO_PIECE = 0;
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    private int[][] grid;

    public Connect4Grid2DArray()
    {
        grid = new int[NUM_GRID_ROWS][NUM_GRID_COLUMNS];
    }

    @Override
    public void emptyGrid()
    {
        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[row].length; col++)
            {
                grid[row][col] = NO_PIECE;
            }
        }
    }

    @Override
    public boolean isValidColumn(int column)
    {
        if (column >= 1 && column <= NUM_GRID_COLUMNS)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean isColumnFull(int column)
    {
        for (int row = 0; row < grid.length; row++)
        {
            if (grid[row][column] != 0)
            {
                return true;
            }
        }
        return true;
    }

    @Override
    public void dropPiece(ConnectPlayer player, int column)
    {
        if (!isValidColumn(column))
        {
            System.out.println("That column is invalid. It must be in the range 1-7.");
        }
        else if (isColumnFull(column))
        {
            System.out.println("The column is full, please try again.");
        }
        else
        {
            for (int row = 0; row < NUM_GRID_ROWS; row++)
            {
                int currentIndexValue = grid[row][column];
                if (row == NUM_GRID_ROWS - 1 && currentIndexValue == 0)
                {
                }
            }
        }
    }

    @Override
    public boolean didLastPieceConnect4()
    {
        return false;
    }

    @Override
    public boolean isGridFull()
    {
        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[row].length; col++)
            {
                if (grid[row][col] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }


}
