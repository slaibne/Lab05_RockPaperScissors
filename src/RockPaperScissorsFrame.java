import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Scanner;


public class RockPaperScissorsFrame extends JFrame
{


    ArtificialIntelligence CPU = new ArtificialIntelligence();

    static Scanner in = new Scanner(System.in);
    static Player s = new Player(SafeInput.getNonZeroLenString(in, "What is your name?"));


    int cpuScoreCount = 0;
    int userScoreCount = 0;
    int tieCount = 0;

    String userChoice;

    JPanel main = new JPanel();

    JPanel playPnl = new JPanel();
    JPanel scoreboardPnl = new JPanel();
    JPanel victoryDisplayPnl = new JPanel();

    JLabel title = new JLabel("Stone Parchment Shears Game");
    JLabel userWins = new JLabel("Player Victories");
    JTextField userScore = new JTextField(2);
    JLabel cpuWins = new JLabel("CPU Victories");
    JTextField cpuScore = new JTextField(2);
    JLabel ties = new JLabel("Tie Count");
    JTextField tieAmount = new JTextField(2);



    JTextArea scoreTxtArea = new JTextArea(10,45);

    JScrollPane scroller = new JScrollPane(scoreTxtArea);

    JButton rockBtn = new JButton("Rock", new ImageIcon("Rock.jpg"));
    JButton paperBtn = new JButton("Paper", new ImageIcon("paper.png"));
    JButton scissorsBtn = new JButton("Scissors", new ImageIcon("scissors.png"));
    JButton quitBtn = new JButton("Quit");

    public RockPaperScissorsFrame()
    {
        main.setLayout(new BorderLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createDisplayPanel();
        createPlayPanel();

        add(main);

    }


    /** decideVictor tests all variations of Rock Paper & Scissors to see who wins,
     * since we are making the userChoice and CPUChoice separate I figured it would be
     * easier to just take those values and check them on their own**/
    private String decideVictor()
    {
        String victoryLine = null;
        String cpuChoice = CPU.determineMove(s, userChoice);
        if(userChoice.equals(cpuChoice))
        {
            tieCount++;
            return "Both players chose " + userChoice + ", so it is a tie! " + CPU.getLastStrategy();
        }
        else if(userChoice.equals("Rock") && cpuChoice.equals("Paper"))
        {
            cpuScoreCount++;
            victoryLine = "CPU wins with Paper, covering "+ s.getName() +"'s Rock " + CPU.getLastStrategy();
        }
        else if(userChoice.equals("Scissors") && cpuChoice.equals("Rock"))
        {
            cpuScoreCount++;
            victoryLine = "CPU wins with Rock, breaking "+ s.getName() +"'s Scissors " + CPU.getLastStrategy();
        }
        else if(userChoice.equals("Paper") && cpuChoice.equals("Scissors"))
        {
            cpuScoreCount++;
            victoryLine = "CPU wins with Scissors, cutting "+ s.getName() +"'s Paper " + CPU.getLastStrategy();
        }
        else if(cpuChoice.equals("Rock") && userChoice.equals("Paper"))
        {
            userScoreCount++;
            victoryLine =  s.getName() +" wins with Paper, covering CPU's Rock " + CPU.getLastStrategy();
        }
        else if(cpuChoice.equals("Scissors") && userChoice.equals("Rock"))
        {
            userScoreCount++;
            victoryLine =  s.getName() +" wins with Rock, breaking CPU's Scissors " + CPU.getLastStrategy();
        }
        else if(cpuChoice.equals("Paper") && userChoice.equals("Scissors"))
        {
            userScoreCount++;
            victoryLine =  s.getName() +" wins with Scissors, cutting CPU's Paper " + CPU.getLastStrategy();
        }
        tieAmount.setText(String.valueOf(tieCount));
        cpuScore.setText(String.valueOf(cpuScoreCount));
        userScore.setText(String.valueOf(userScoreCount));
        s.updatePlayerChoices(userChoice);
        return victoryLine;
    }

    /**
     *
     */
    private void createPlayPanel()
    {
        Color white = new Color (255,255,255);
        playPnl.setLayout(new GridLayout(2,3, 10, 5));
        playPnl.setBorder(new TitledBorder(new EtchedBorder(), "Decide:"));

        playPnl.add(new JLabel());
        title.setFont(new Font("Italic", Font.ITALIC, 19));
        title.setHorizontalAlignment(JLabel.CENTER);
        playPnl.add(title);
        playPnl.add(new JLabel());

        rockBtn.setBackground(white);
        rockBtn.setFont(new Font("Bold", Font.BOLD, 20));
        rockBtn.setHorizontalTextPosition(JLabel.CENTER);
        rockBtn.setVerticalTextPosition(JLabel.BOTTOM);
        playPnl.add(rockBtn);
        rockBtn.addActionListener(e -> {
            userChoice = "Rock";
            scoreTxtArea.append(decideVictor()+"\n");
        });

        paperBtn.setBackground(white);
        paperBtn.setFont(new Font("Serif", Font.PLAIN, 18));
        paperBtn.setHorizontalTextPosition(JLabel.CENTER);
        paperBtn.setVerticalTextPosition(JLabel.BOTTOM);
        playPnl.add(paperBtn);
        paperBtn.addActionListener(e -> {
            userChoice = "Paper";
            scoreTxtArea.append(decideVictor()+"\n");
        });

        scissorsBtn.setBackground(white);
        scissorsBtn.setFont(new Font("Italic", Font.ITALIC, 20));
        scissorsBtn.setHorizontalTextPosition(JLabel.CENTER);
        scissorsBtn.setVerticalTextPosition(JLabel.BOTTOM);
        playPnl.add(scissorsBtn);
        scissorsBtn.addActionListener(e -> {
            userChoice = "Scissors";
            scoreTxtArea.append(decideVictor()+"\n");
        });

        main.add(BorderLayout.NORTH, playPnl);
    }

    /**
     *
     */
    private void createDisplayPanel() {
        scoreTxtArea.setFont(new Font("Serif", Font.BOLD, 18));
        victoryDisplayPnl.add(scroller);
        scoreboardPnl.setLayout(new GridLayout(3, 3));

        userWins.setHorizontalAlignment(JLabel.CENTER);
        scoreboardPnl.add(userWins);
        cpuWins.setHorizontalAlignment(JLabel.CENTER);
        scoreboardPnl.add(cpuWins);
        ties.setHorizontalAlignment(JLabel.CENTER);
        scoreboardPnl.add(ties);

        scoreboardPnl.add(userScore);
        scoreboardPnl.add(cpuScore);
        scoreboardPnl.add(tieAmount);

        scoreboardPnl.add(new JLabel());
        quitBtn.addActionListener(e -> System.exit(0));
        scoreboardPnl.add(quitBtn);
        scoreboardPnl.add(new JLabel());

        main.add(BorderLayout.SOUTH, scoreboardPnl);
        main.add(BorderLayout.CENTER, victoryDisplayPnl);

    }
}