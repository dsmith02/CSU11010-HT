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
        String representation = "    THE GRID";
        for (int row = 0; row < NUM_GRID_ROWS; row++)
        {
            representation += "\n" + (row + 1);
            for (int col = 0; col < NUM_GRID_COLUMNS; col++)
            {
                representation += grid[row][col] == NO_PIECE ? " E" : grid[row][col] == PLAYER_ONE ? " R"
                        : grid[row][col] == PLAYER_TWO ? " Y" : " ";
            }
        }
        representation += "\n  1 2 3 4 5 6 7\nE = EMPTY, R = REDS, Y = YELLOW";
        return representation;
    }

    @Override
    public boolean isValidColumn(int column)
    {
        if (column >= 0 && column < NUM_GRID_COLUMNS)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean isColumnFull(int column)
    {
        return grid[0][column] != NO_PIECE;
    }

    @Override
    public void dropPiece(ConnectPlayer player, int column)
    {
        int row = getNextFreeSlot(column);
        grid[row][column] = player.getPlayerID();
        lastPiecePlayerID = player.getPlayerID();
        lastPieceRow = row;
        lastPieceColumn = column;
    }

    // This was horrible to code, apologies for the convoluted mess that it is. I attempted to do this in one day and this
    // was the best algorithm I came up with given my limited time - DS.
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
        adjustment = (NUM_GRID_COLUMNS - 2) - lastPieceColumn;
        sequence = 0;
        col = Math.min(lastPieceColumn + adjustment, NUM_GRID_COLUMNS - 1);
        for (row = Math.max((lastPieceRow - adjustment), 0); row < NUM_GRID_ROWS && col >= 0 && sequence != 4; row++, col--)
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
        for (int col = 0; col < grid.length; col++)
        {
            if (grid[0][col] == NO_PIECE)
            {
                return false;
            }
        }
        return true;
    }

    private int getNextFreeSlot(int column)
    {
        for (int row = 0; row < NUM_GRID_ROWS; row++)
        {
            int currentSlotValue = grid[row][column];
            if ((row == NUM_GRID_ROWS - 1 && currentSlotValue == NO_PIECE)
                    || (currentSlotValue == 0 && grid[row + 1][column] != NO_PIECE))
            {
                return row;
            }
        }
        return -1;
    }
}

