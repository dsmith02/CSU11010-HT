import java.lang.reflect.Field;

public class Connect4Grid2DArray implements Connect4Grid
{
    public static final int NUM_GRID_COLUMNS = 7;
    public static final int NUM_GRID_ROWS = 6;
    public static final int NO_PIECE = 0;
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    private int lastPiecePlayerID = -1;
    private int lastPieceRow = -1;
    private int lastPieceColumn = -1;
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
    public String toString()
    {
        String representation = " 1 2 3 4 5 6 7\n -------------";
        for (int row = 0; row < NUM_GRID_ROWS; row++)
        {
            representation += "\n" + (row - 1) + " |";
            for (int col = 0; col < NUM_GRID_COLUMNS; col++)
            {
                representation += grid[row][col] == 0 ? " " : grid[row][col] == 1 ? " 1" : " 2";
            }
        }
        return representation;
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
            int row = getNextFreeSlot(column);
            grid[row][column] = player.getPlayerID();
            lastPiecePlayerID = player.getPlayerID();
            lastPieceRow = row;
            lastPieceColumn = column;
        }
    }

    @Override
    public boolean didLastPieceConnect4()
    {
        if (lastPiecePlayerID == -1 || lastPieceColumn == -1 || lastPieceRow == -1)
        {
            return false;
        }

        int sequence = 0;
        int direction = 0;
        int row;
        int col;

        // Check left-right
        row = lastPieceRow;
        for (col = 0; col < NUM_GRID_COLUMNS && sequence != 4; col++)
        {
            if (grid[row][col] == lastPiecePlayerID)
            {
                sequence++;
            }
            else
            {
                sequence = 0;
            }
        }

        if (sequence == 4)
        {
            return true;
        }

        // Check up-down
        sequence = 0;
        col = lastPieceColumn;
        for (row = 0; row < NUM_GRID_ROWS && sequence != 4; row++)
        {
            if (grid[row][col] == lastPiecePlayerID)
            {
                sequence++;
            }
            else
            {
                sequence = 0;
            }
        }

        if (sequence == 4)
        {
            return true;
        }

        int adjustment = Math.min(lastPieceRow, lastPieceColumn);
        // Main diagonal
        sequence = 0;
        col = lastPieceColumn - adjustment;
        for (row = lastPieceRow - adjustment; row < NUM_GRID_ROWS
                && col < NUM_GRID_COLUMNS && sequence != 4; row++, col++)
        {
            if (grid[row][col] == lastPiecePlayerID)
            {
                sequence++;
            }
            else
            {
                sequence = 0;
            }
        }

        if (sequence == 4)
        {
            return true;
        }

        // Other diagonal
        sequence = 0;
        col = lastPieceColumn + adjustment;
        for (row = lastPieceRow + adjustment; row >= 0 && col >= 0 && sequence != 4; row--, col--)
        {
            if (grid[row][col] == lastPiecePlayerID)
            {
                sequence++;
            }
            else
            {
                sequence = 0;
            }
        }
        return sequence == 4;
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

    private int getNextFreeSlot(int column)
    {
        for (int row = 0; row < NUM_GRID_ROWS; row++)
        {
            int currentSlotValue = grid[row][column];
            if ((row == NUM_GRID_ROWS - 1 && currentSlotValue == 0)
                    || (currentSlotValue == 0 && grid[row + 1][column] != 0))
            {
                return row;
            }
        }
        return -1;
    }
}

