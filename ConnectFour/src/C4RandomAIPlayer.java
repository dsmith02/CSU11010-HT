import java.security.SecureRandom;
import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer
{
    public C4RandomAIPlayer(int playerID)
    {
        super(playerID);
    }

    @Override
    public int chooseColumn()
    {
        Random random = new Random();
        int column = random.nextInt(Connect4Grid2DArray.NUM_GRID_COLUMNS) + 1;
        return column;
    }
}