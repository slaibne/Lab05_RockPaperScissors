import java.util.Random;

public class ArtificialIntelligence implements CPUStrategy
{
    String lastStrategy;
    String[] options;
    {
        options = new String[3];
        options[0] = "Rock";
        options[1] = "Paper";
        options[2] = "Scissors";
    }
    Random rnd = new Random();
    int x;
    @Override
    public String determineMove(Player s, String playerInput)
    {
        x = rnd.nextInt(100);
        if (x<10)
        {
            lastStrategy = "(Cheated)";
            if(playerInput.equals("Rock")){
                return "Paper";
            }
            if(playerInput.equals("Paper")){
                return "Scissors";
            }
            if(playerInput.equals("Scissors")) {
                return "Rock";
            }
        }
        else if (x<25 && s.getLeastUsed() != null)
        {
            lastStrategy = "(Least Used)";
            if(s.getLeastUsed().equals("Rock"))
            {
                return "Paper";
            }
            if(s.getLeastUsed().equals("Paper"))
            {
                return "Scissors";
            }
            if(s.getLeastUsed().equals("Scissors"))
            {
                return "Rock";
            }
        }
        else if (x<40 && s.getMostUsed() != null)
        {
            lastStrategy = "(Most Used)";
            if(s.getMostUsed()=="Rock")
            {
                return "Paper";
            }
            if(s.getMostUsed()=="Paper")
            {
                return "Scissors";
            }
            if(s.getMostUsed()=="Scissors")
            {
                return "Rock";
            }

        }
        else if (x<55 && s.getLastUsed() != null)
        {
            lastStrategy = "(Last Used)";
            return s.getLastUsed();
        }
        else
        {
            lastStrategy = "(Picked Randomly)";
            return options[rnd.nextInt(3)];
        }
        return null;
    }
    public String getLastStrategy()
    {
        return lastStrategy;
    }
}