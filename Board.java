import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Board extends JFrame implements ActionListener {
    private JPanel bottomPanel, leftPanel, rightPanel;
    private RollDicePanel topPanel;
    private Grid centerPanel;
    private JButton finishTurnButton, saveButton;
    private PlayerPanel player1, player2, player3, player4;
    private JPanel panelforpanel;
    private JPanel panelforpanelforpanel;
    private JLabel playerLabel;
    private Color boardColour;
    private Color backgroundColour;

    private int noOfPlayers;

    // private Color runnerColour = Color.white;
    public Board(Color userBoardColour, Color userBackgroundColour, String mode, int numberOfPlayers,
            String playerName1, String playerName2, String playerName3, String playerName4) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        noOfPlayers = numberOfPlayers;

        this.boardColour = userBoardColour;
        this.backgroundColour = userBackgroundColour;

        topPanel = new RollDicePanel(backgroundColour);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        finishTurnButton = new JButton("Finish Turn");
        // finishTurnButton.addActionListener(this);

        bottomPanel.add(finishTurnButton);
        bottomPanel.setBackground(backgroundColour);

        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(backgroundColour);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        player1 = new PlayerPanel(new Shape((String) playerOptions.finalValues.get(0).get(2)));/////////// NEW CODE
        System.out.println(playerOptions.finalValues.get(1).get(0).toString().replace("[", "").strip());
        player2 = new PlayerPanel(new Shape((String) playerOptions.finalValues.get(1).get(2)));/////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        panelforpanel = new JPanel();
        panelforpanel.add(player1);
        panelforpanel.setBackground(backgroundColour);
        playerLabel = new JLabel(playerName1);
        playerLabel.setHorizontalAlignment(JLabel.CENTER);
        panelforpanelforpanel = new JPanel();
        panelforpanelforpanel.setBackground(backgroundColour);
        panelforpanelforpanel.setLayout(new BorderLayout());
        panelforpanelforpanel.add(panelforpanel, BorderLayout.NORTH);
        panelforpanelforpanel.add(playerLabel, BorderLayout.SOUTH);
        leftPanel.add(panelforpanelforpanel, BorderLayout.NORTH);
        panelforpanel = new JPanel();
        panelforpanel.add(player2);
        panelforpanel.setBackground(backgroundColour);

        if (playerOptions.finalValues.get(1).get(0).toString().replace("[",
                "").strip().equals("Yes")) {
            System.out.println("Yes I am AI");
            if (playerOptions.finalValues.get(1).get(3).toString().replace("]",
                    "").strip().equals("Easy")) {
                playerLabel = new JLabel(playerName2 + "(EasyAI)");
            } else {
                playerLabel = new JLabel(playerName2 + "(HardAI)");
            }

        } else {
            playerLabel = new JLabel(playerName2);
        }

        playerLabel.setHorizontalAlignment(JLabel.CENTER);
        panelforpanelforpanel = new JPanel();
        panelforpanelforpanel.setBackground(backgroundColour);
        panelforpanelforpanel.setLayout(new BorderLayout());
        panelforpanelforpanel.add(panelforpanel, BorderLayout.NORTH);
        panelforpanelforpanel.add(playerLabel, BorderLayout.SOUTH);
        leftPanel.add(panelforpanelforpanel, BorderLayout.SOUTH);

        // Code added by Mirza

        saveButton = new JButton("Save and Quit!");
        saveButton.addActionListener(this);
        bottomPanel.add(saveButton);

        // code added by Suvo
        JMenuBar menuBar = new JMenuBar();
        JMenu exitMenu = new JMenu("Exit Game");
        menuBar.add(exitMenu);
        exitMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // add your event handling code here
                setVisible(false);
            }
        });

        setJMenuBar(menuBar);

        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBackground(backgroundColour);
        if (numberOfPlayers >= 3) {
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            player3 = new PlayerPanel(new Shape((String) playerOptions.finalValues.get(2).get(2)));// new code
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            panelforpanel = new JPanel();
            panelforpanel.add(player3);
            panelforpanel.setBackground(backgroundColour);
            if (playerOptions.finalValues.get(2).get(0).toString().replace("[",
                    "").strip().equals("Yes")) {
                System.out.println("Yes I am AI");
                if (playerOptions.finalValues.get(2).get(3).toString().replace("]",
                        "").strip().equals("Easy")) {
                    playerLabel = new JLabel(playerName3 + "(EasyAI)");
                } else {
                    playerLabel = new JLabel(playerName3 + "(HardAI)");
                }

            } else {
                playerLabel = new JLabel(playerName3);
            }
            playerLabel.setHorizontalAlignment(JLabel.CENTER);
            panelforpanelforpanel = new JPanel();
            panelforpanelforpanel.setBackground(backgroundColour);
            panelforpanelforpanel.setLayout(new BorderLayout());
            panelforpanelforpanel.add(panelforpanel, BorderLayout.NORTH);
            panelforpanelforpanel.add(playerLabel, BorderLayout.SOUTH);
            rightPanel.add(panelforpanelforpanel, BorderLayout.NORTH);
            if (numberOfPlayers >= 4) {
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                player4 = new PlayerPanel(new Shape((String) playerOptions.finalValues.get(3).get(2))); // new code
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                panelforpanel = new JPanel();
                panelforpanel.add(player4);
                panelforpanel.setBackground(backgroundColour);
                /////////////
                if (playerOptions.finalValues.get(3).get(0).toString().replace("[",
                        "").strip().equals("Yes")) {
                    System.out.println("Yes I am AI");
                    if (playerOptions.finalValues.get(3).get(3).toString().replace("]",
                            "").strip().equals("Easy")) {
                        playerLabel = new JLabel(playerName4 + "(EasyAI)");
                    } else {
                        playerLabel = new JLabel(playerName4 + "(HardAI)");
                    }

                } else {
                    playerLabel = new JLabel(playerName4);
                }
                playerLabel.setHorizontalAlignment(JLabel.CENTER);
                panelforpanelforpanel = new JPanel();
                panelforpanelforpanel.setBackground(backgroundColour);
                panelforpanelforpanel.setLayout(new BorderLayout());
                panelforpanelforpanel.add(panelforpanel, BorderLayout.NORTH);
                panelforpanelforpanel.add(playerLabel, BorderLayout.SOUTH);
                rightPanel.add(panelforpanelforpanel, BorderLayout.SOUTH);
            }
        }

        centerPanel = new Grid(boardColour);
        JPanel panelForCenterPanel = new JPanel();
        panelForCenterPanel.add(centerPanel);
        panelForCenterPanel.setBackground(backgroundColour);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        getContentPane().add(leftPanel, BorderLayout.WEST);
        getContentPane().add(rightPanel, BorderLayout.EAST);
        getContentPane().add(panelForCenterPanel, BorderLayout.CENTER);
        getContentPane().setBackground(Color.red);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (mode.equals("FullScreen")) {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public int getNoOfPlayers() {
        return noOfPlayers;
    }

    public Dice getDice1() {
        return topPanel.getDice1();
    }

    public Dice getDice2() {
        return topPanel.getDice2();
    }

    public Dice getDice3() {
        return topPanel.getDice3();
    }

    public Dice getDice4() {
        return topPanel.getDice4();
    }

    public int getDice1Value() {
        return topPanel.getDice1Value();
    }

    public int getDice2Value() {
        return topPanel.getDice2Value();
    }

    public int getDice3Value() {
        return topPanel.getDice3Value();
    }

    public int getDice4Value() {
        return topPanel.getDice4Value();
    }

    public Grid getGrid() {
        return centerPanel;
    }

    public Square getSquareFromGrid(int x, int y) {
        return centerPanel.getSquare(x, y);
    }

    public JButton getFinishTurnButton() {
        return finishTurnButton;
    }

    public JButton getRollDiceButton() {
        return topPanel.getRollDiceButton();
    }

    public RollDicePanel getRollDicePanel() {
        return topPanel;
    }

    public void actionPerformed(ActionEvent aevt) {
        Object selected = aevt.getSource();
        if (selected.equals(finishTurnButton)) {

            // add functionality for finish turn button here
        } else if (selected == saveButton) {
            newSave save = new newSave();
        }
    }

}