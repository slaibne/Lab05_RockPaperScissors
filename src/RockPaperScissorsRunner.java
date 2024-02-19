import javax.swing.*;

public class RockPaperScissorsRunner {
    public static void main(String[] args)
    {
        RockPaperScissorsFrame rps = new RockPaperScissorsFrame();
        rps.setTitle("Rock Paper Scissors Game");
        rps.setSize(900, 700);
        rps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rps.setVisible(true);
    }
}