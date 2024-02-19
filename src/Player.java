public class Player
{
    private String name;
    private String leastUsed;
    private String mostUsed;
    private String lastUsed;

    private int rockCount = 0;
    private int paperCount = 0;
    private int scissorsCount = 0;

    public Player(String name)
    {
        this.name = name;
    }

    public String getLeastUsed()
    {
        return this.leastUsed;
    }

    public void setLeastUsed(String leastUsed)
    {
        this.leastUsed = leastUsed;
    }

    public String getMostUsed()
    {
        return this.mostUsed;
    }

    public void setMostUsed(String mostUsed)
    {
        this.mostUsed = mostUsed;
    }

    public String getLastUsed()
    {
        return lastUsed;
    }

    public void setLastUsed(String lastUsed)
    {
        this.lastUsed = lastUsed;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void updatePlayerChoices(String lastUsed)
    {
        this.lastUsed = lastUsed;
        if(lastUsed.equals("Rock"))
            this.rockCount++;
        else if (lastUsed.equals("Paper"))
            this.paperCount++;
        else if (lastUsed.equals("Scissors"))
            this.scissorsCount++;

        if(rockCount<paperCount && rockCount<scissorsCount)
        {
            this.leastUsed = "Rock";
        }
        else if (paperCount<rockCount && paperCount<scissorsCount)
        {
            this.leastUsed = "Paper";
        }
        else if(scissorsCount<rockCount && scissorsCount<paperCount)
        {
            this.leastUsed = "Scissors";
        }
        else
        {
            this.leastUsed = null;
        }

        if(rockCount>paperCount && rockCount>scissorsCount)
        {
            this.mostUsed = "Rock";
        }
        else if(paperCount>rockCount && paperCount>scissorsCount)
        {
            this.mostUsed = "Paper";
        }
        else if(scissorsCount>paperCount && scissorsCount>rockCount)
        {
            this.mostUsed = "Scissors";
        }
        else
        {
            this.mostUsed = null;
        }
    }
}