public abstract class ConnectPlayer
{
    public static final int PLAYER_ONE_ID = 1;
    public static final int PLAYER_TWO_ID = 2;
    private int playerID;

    public ConnectPlayer(int playerID)
    {
        if (playerID != PLAYER_ONE_ID && playerID != PLAYER_TWO_ID)
        {
            return;
        }
        this.playerID = playerID;
    }

    public int getPlayerID()
    {
        return playerID;
    }

    public abstract int chooseColumn();

}
