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
        if (!checkColumnValidity(column))
        {
            System.out.println("That column is invalid. It must be in the range 1-7 and must not be full!");
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

        int dx = 1;
        int dy = 0;
        int sum = 0;

        // Check left-right
        for (int row = lastPieceRow; row < NUM_GRID_ROWS && sum != 4; row += dy)
        {
            for (int col = lastPieceColumn; col < NUM_GRID_COLUMNS; col += dx)
            {
                int currentPiece = grid[row][col];
                if (currentPiece == lastPiecePlayerID)
                {
                    sum++;
                }
            }
        }
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

    private int getNextFreeSlot(int column)
    {
        if (checkColumnValidity(column))
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
        }
        return -1;
    }

    private boolean checkColumnValidity(int column)
    {
        return isValidColumn(column) && !isColumnFull(column);
    }

}
