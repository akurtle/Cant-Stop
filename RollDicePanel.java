
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RollDicePanel extends JPanel { // implements ActionListener{
    private JPanel topPanel, bottomPanel, movePanel;
    private JButton rollDiceButton;
    private Dice dice1, dice2, dice3, dice4;
    private Random random;
    private Boolean moveMade;

    public JLabel currMove;

    public Integer currentMove = 1;

    public RollDicePanel(Color colour) {
        super();
        moveMade = false;
        this.setLayout(new BorderLayout());
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        rollDiceButton = new JButton("Roll Dice");
        // rollDiceButton.addActionListener(this);
        // rollDiceButton.setPreferredSize(new Dimension(90,20));
        topPanel.add(rollDiceButton);
        topPanel.setBackground(colour);

        dice1 = new Dice();
        dice2 = new Dice();
        dice3 = new Dice();
        dice4 = new Dice();
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(colour);
        bottomPanel.add(dice1);
        bottomPanel.add(dice2);
        bottomPanel.add(dice3);
        bottomPanel.add(dice4);

        // Code by Mirza :

        movePanel = new JPanel();
        currMove = new JLabel("Current Turn : Player " + currentMove.toString());

        movePanel.add(currMove);
        movePanel.setBackground(DisplaySetting.getBackgroundColor());

        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.CENTER);
        this.add(movePanel, BorderLayout.SOUTH);
        this.setBackground(colour);
        random = new Random();
    }

    public JButton getRollDiceButton() {
        return rollDiceButton;
    }

    public Dice getDice1() {
        return dice1;
    }

    public Dice getDice2() {
        return dice2;
    }

    public Dice getDice3() {
        return dice3;
    }

    public Dice getDice4() {
        return dice4;
    }

    public int getDice1Value() {
        return dice1.getValue();
    }

    public int getDice2Value() {
        return dice2.getValue();
    }

    public int getDice3Value() {
        return dice3.getValue();
    }

    public int getDice4Value() {
        return dice4.getValue();
    }

    public Boolean getMoveMade() {
        return moveMade;
    }

    public void setMoveMade(Boolean truthVal) {
        moveMade = truthVal;
    }

    public void updatingPlayerMove() {
        currentMove += 1;
        if (currentMove > playerOptions.getNumberOfPlayers()) {
            currentMove = 1;
            currMove.setText("Current Turn : Player " + currentMove.toString());
        }

        currMove.setText("Current Turn : Player " + currentMove.toString());
    }

    public void rollAll4Dice() {
        dice1.setValue(random.nextInt(6) + 1);
        dice2.setValue(random.nextInt(6) + 1);
        dice3.setValue(random.nextInt(6) + 1);
        dice4.setValue(random.nextInt(6) + 1);

    }
    /*
     * @Override
     * public void actionPerformed(ActionEvent aevt) {
     * Object selected = aevt.getSource();
     * if (selected.equals(rollDiceButton)) {
     * rollAll4Dice();
     * }
     * }
     */
}
