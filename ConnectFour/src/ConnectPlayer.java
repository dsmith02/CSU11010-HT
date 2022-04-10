public abstract class ConnectPlayer
{
    public static final int PLAYER_ONE_ID = 1;
    public static final int PLAYER_TWO_ID = 2;
    private String colour;
    private int playerID;

    public ConnectPlayer(int playerID, String color)
    {
        if (playerID != PLAYER_ONE_ID && playerID != PLAYER_TWO_ID)
        {
            return;
        }
    }
    public String getColour()
    {
        return colour;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public int getPlayerID()
    {
        return playerID;
    }

    public void setPlayerID(int playerID)
    {
        this.playerID = playerID;
    }

    public abstract void chooseColumn();

}
