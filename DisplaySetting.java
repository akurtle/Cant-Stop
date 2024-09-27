
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.util.ArrayList;
import java.util.HashMap;

public class DisplaySetting extends JFrame {

    // playerOptions player = new playerOptions();
    JRadioButton editColorButton, defaultButton, windowButton, fullButton;
    public JComboBox<String> boardComboBox, backgroundComboBox, runnerComboBox;
    JButton nextButton, closeButton;
    String mode = "WindowSize";
    int totalPlayer = 4;
    String onePlayer = "w";
    String twoPlayer = "x";
    String threePlayer = "y";
    String fourPlayer = "z";
    Board demo;
    public static Color object;
    GameController gameController;
    HashMap<String, Color> stringToColor;

    public static ArrayList<String> values;

    public DisplaySetting() {
        // Code added by mirza
        values = new ArrayList<String>();

        JFrame frame = new JFrame("Display Settings");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel screenLabel = new JLabel("Choose Window Mode:");
        ButtonGroup screenButtonGroup = new ButtonGroup();
        windowButton = new JRadioButton("Window Size", true);
        windowButton.addActionListener((e) -> {
            // code to be executed when the radio button is clicked

            mode = "WindowSize";
        });
        fullButton = new JRadioButton("Full Screen");
        fullButton.addActionListener((e) -> {
            // code to be executed when the radio button is clicked

            mode = "FullScreen";
        });

        // playerOptions player = new playerOptions();
        // player.dispose();
        totalPlayer = playerOptions.getNumberOfPlayers();
        // totalPlayer = 4;

        onePlayer = playerOptions.getNameOfPlayers1();

        twoPlayer = playerOptions.getNameOfPlayers2();

        threePlayer = playerOptions.getNameOfPlayers3();
        fourPlayer = playerOptions.getNameOfPlayers4();

        screenButtonGroup.add(windowButton);
        screenButtonGroup.add(fullButton);

        JLabel optionLabel = new JLabel("Choose Display Options:");
        ButtonGroup optionButtonGroup = new ButtonGroup();
        defaultButton = new JRadioButton("Default", true);
        defaultButton.addActionListener((e) -> {
            // code to be executed when the radio button is clicked
            System.out.println("Clicked");
            // runnerComboBox.setEnabled(false);
            boardComboBox.setEnabled(false);
            backgroundComboBox.setEnabled(false);
        });
        editColorButton = new JRadioButton("Edit Colors");
        editColorButton.addActionListener((e) -> {
            // code to be executed when the radio button is clicked
            System.out.println("Clicked");
            // runnerComboBox.setEnabled(true);
            boardComboBox.setEnabled(true);
            backgroundComboBox.setEnabled(true);
        });

        optionButtonGroup.add(defaultButton);
        optionButtonGroup.add(editColorButton);

        JLabel blankLabel = new JLabel("         ");

        JLabel backgroundLabel = new JLabel("Choose Background Color:");
        backgroundComboBox = new JComboBox<String>();

        backgroundComboBox.setEnabled(false);
        backgroundComboBox.addItem("Gray");
        backgroundComboBox.addItem("Red");
        backgroundComboBox.addItem("Yellow");
        backgroundComboBox.addItem("Green");
        backgroundComboBox.addItem("Blue");

        backgroundComboBox.setSize(new Dimension(90, 40));

        JLabel boardLabel = new JLabel("Choose Board Color:");

        boardComboBox = new JComboBox<String>();

        boardComboBox.setEnabled(false);
        boardComboBox.addItem("Red");
        boardComboBox.addItem("Yellow");
        boardComboBox.addItem("Green");
        boardComboBox.addItem("Blue");

        boardComboBox.setSize(new Dimension(90, 40));

        stringToColor = new HashMap<String, Color>();
        stringToColor.put("Blue", Color.blue);
        stringToColor.put("Red", Color.red);
        stringToColor.put("Yellow", Color.yellow);
        stringToColor.put("Green", Color.green);
        stringToColor.put("Gray", Color.gray);

        nextButton = new JButton("Next");
        nextButton.addActionListener((e) -> {
            // code to be executed when the button is clicked
            demo = new Board(stringToColor.get(boardComboBox.getSelectedItem()),
                    stringToColor.get(backgroundComboBox.getSelectedItem()), mode,
                    totalPlayer, onePlayer, twoPlayer, threePlayer, fourPlayer);
            gameController = new GameController(demo);
            // code added by Mirza
            this.addValues();

            frame.setVisible(false);
        });

        closeButton = new JButton("Back");
        closeButton.addActionListener((e) -> {
            // code to be executed when the radio button is clicked
            frame.dispose();
        });

        panel.add(blankLabel);
        panel.add(optionLabel);
        panel.add(defaultButton);
        panel.add(editColorButton);
        panel.add(blankLabel);

        panel.add(backgroundLabel);
        panel.add(backgroundComboBox);
        panel.add(blankLabel);
        panel.add(boardLabel);
        panel.add(boardComboBox);

        panel.add(blankLabel);
        panel.add(screenLabel);
        panel.add(windowButton);
        panel.add(fullButton);
        panel.add(blankLabel);
        // panel.add(runnerLabel);
        // panel.add(runnerComboBox);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // code for fixing UI for Back and Next buttons
        JPanel frameForBottomButtons = new JPanel();
        frameForBottomButtons.setLayout(new FlowLayout());
        frameForBottomButtons.add(closeButton);
        frameForBottomButtons.add(nextButton);
        panel.add(frameForBottomButtons);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        frame.add(panel);
        frame.setVisible(true);

        // Code added by Mirza

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

    }

    public void addValues() {
        values.add(mode);
        values.add(backgroundComboBox.getSelectedItem().toString());
        values.add(boardComboBox.getSelectedItem().toString());
        object = stringToColor.get(values.get(0));
    }

    public static ArrayList getValues() {
        return values;
    }

    public Board getBoard() {
        return demo;
    }

    public static Color getBackgroundColor() {

        return object;
    }

    // public void actionPerformed(ActionEvent e) {
    // if (e.getSource() == editColorButton) {
    // System.out.println("Clicked");
    // // runnerComboBox.setEnabled(true);
    // // boardComboBox.setEnabled(true);
    // // backgroundComboBox.setEnabled(true);
    // }
    // }

    // public static void main(String[] args) {
    // new DisplaySetting();
    // }
}
