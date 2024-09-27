
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import java.util.stream.Collectors;

import java.awt.Color;

public class playerOptions extends JFrame {
    private JPanel player1, player2, player3, player4, bigOne, numberPlayers, bottomButton;
    private JComboBox p1, p2, p3, p4, ai2, ai3, ai4;
    private JTextField user1, user2, user3, user4;
    private JCheckBox comp2, comp3, comp4;
    private JButton number2, number3, number4, nextButton, backButton;
    private JLabel numberOfPlayers;

    private static int numOfplayers = 2;
    private static String nameOfPlayers1 = "Player1";
    private static String nameOfPlayers2 = "Player2";
    private static String nameOfPlayers3 = "Player3";
    private static String nameOfPlayers4 = "Player4";
    // Flag
    boolean nextTrue = false;

    // ArrayLists
    public ArrayList<JComboBox> ai;
    public ArrayList<Object> playerShapes;
    public ArrayList<String> availablePlayerShapes;
    public ArrayList<JTextField> playerNames;
    public ArrayList<JComboBox> shapeDropdowns;

    // Final Values
    String[] finalStuff;

    public static ArrayList<ArrayList> finalValues;

    public playerOptions() {
        this.setResizable(false);
        this.setSize(500, 550);
        this.setTitle("Player Options");

        ai = new ArrayList<JComboBox>();
        playerShapes = new ArrayList<Object>();
        shapeDropdowns = new ArrayList<JComboBox>();
        playerNames = new ArrayList<JTextField>();

        finalValues = new ArrayList<ArrayList>();

        // Initializing Final values stuff

        // Big Panel and Players Panel
        bigOne = new JPanel();
        bigOne.setPreferredSize(new Dimension(400, 500));
        bigOne.setBorder(BorderFactory.createLineBorder(Color.black));

        numberPlayers = new JPanel();
        numberPlayers.setPreferredSize(new Dimension(200, 80));
        numberPlayers.setBorder(BorderFactory.createLineBorder(Color.black));

        bottomButton = new JPanel();
        bottomButton.setPreferredSize(new Dimension(200, 80));

        // Player panels
        Dimension panelSize = new Dimension(300, 80);

        player1 = new JPanel();
        player1.setPreferredSize(panelSize);

        player2 = new JPanel();
        player2.setPreferredSize(panelSize);

        player3 = new JPanel();
        player3.setPreferredSize(panelSize);

        player4 = new JPanel();
        player4.setPreferredSize(panelSize);

        // Setting Layouts and borders

        player1.setLayout(new FlowLayout());
        player1.setBorder(BorderFactory.createLineBorder(Color.black));

        player2.setLayout(new FlowLayout());
        player2.setBorder(BorderFactory.createLineBorder(Color.black));

        player3.setLayout(new FlowLayout());
        player3.setBorder(BorderFactory.createLineBorder(Color.black));

        player4.setLayout(new FlowLayout());
        player4.setBorder(BorderFactory.createLineBorder(Color.black));

        // Checkboxes for human or ai

        comp2 = new JCheckBox();
        comp2.addActionListener(e -> setAi(comp2, 0));

        comp3 = new JCheckBox();
        comp3.setEnabled(false);
        comp3.addActionListener(e -> setAi(comp3, 1));

        comp4 = new JCheckBox();
        comp4.setEnabled(false);
        comp4.addActionListener(e -> setAi(comp4, 2));

        // DropDowns For Shapes
        String[] ShapeOptions = { "Choose Shape", "Circle", "Square", "Star", "Diamond" };
        availablePlayerShapes = new ArrayList<String>(Arrays.asList(ShapeOptions));

        p1 = new JComboBox(ShapeOptions);
        shapeDropdowns.add(p1);

        p2 = new JComboBox(ShapeOptions);
        shapeDropdowns.add(p2);

        p3 = new JComboBox(ShapeOptions);
        shapeDropdowns.add(p3);
        p3.setEnabled(false);

        p4 = new JComboBox(ShapeOptions);
        shapeDropdowns.add(p4);
        p4.setEnabled(false);

        p1.addActionListener(e -> shapeSetter(p1));

        p2.addActionListener(e -> shapeSetter(p2));

        p3.addActionListener(e -> shapeSetter(p3));

        p4.addActionListener(e -> shapeSetter(p4));

        // DropDowns For Difficulty

        String[] difficultyOptions = { "Choose Difficulty", "Easy", "Hard" };

        ai2 = new JComboBox(difficultyOptions);
        ai2.setEnabled(false);
        ai.add(ai2);

        ai3 = new JComboBox(difficultyOptions);
        ai3.setEnabled(false);
        ai.add(ai3);

        ai4 = new JComboBox(difficultyOptions);
        ai4.setEnabled(false);
        ai.add(ai4);

        // TextInput

        Dimension textSize = new Dimension(100, 20);

        user1 = new JTextField("Player1");
        user1.setEditable(true);
        playerNames.add(user1);
        user1.setPreferredSize(textSize);
        // nameOfPlayers1 = playerNames.get(0).getText();
        user1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // System.out.println("Text changed to: " + user2.getText());
                nameOfPlayers1 = user1.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //
            }

            public void changedUpdate(DocumentEvent e) {
                // not called for plain text documents
            }
        });

        user2 = new JTextField("Player2");
        user2.setEditable(true);
        playerNames.add(user2);
        user2.setPreferredSize(textSize);
        // nameOfPlayers2 = user2.getText();

        user2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                nameOfPlayers2 = user2.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            public void changedUpdate(DocumentEvent e) {
                // not called for plain text documents
            }
        });

        user3 = new JTextField("Player3");
        user3.setEditable(true);
        playerNames.add(user3);
        user3.setPreferredSize(textSize);
        user3.setEnabled(false);
        nameOfPlayers3 = user3.getText();

        user3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //
                nameOfPlayers3 = user3.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //
            }

            public void changedUpdate(DocumentEvent e) {
                // not called for plain text documents
            }
        });

        user4 = new JTextField("Player4");
        user4.setEditable(true);
        playerNames.add(user4);
        user4.setPreferredSize(textSize);
        user4.setEnabled(false);
        nameOfPlayers4 = user4.getText();

        user4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // System.out.println("Text changed to: " + user2.getText());
                nameOfPlayers4 = user4.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //
            }

            public void changedUpdate(DocumentEvent e) {
                //
            }
        });

        // Button and Labels for Number of Players

        numberOfPlayers = new JLabel("Choose number of players :");

        number2 = new JButton("2");
        number2.addActionListener(e -> chooseNumberOfPlayers(number2));

        number3 = new JButton("3");
        number3.addActionListener(e -> chooseNumberOfPlayers(number3));

        number4 = new JButton("4");
        number4.addActionListener(e -> chooseNumberOfPlayers(number4));

        // Last two buttons

        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> nextButtonAction());

        backButton = new JButton("Back");
        backButton.addActionListener(e -> backButtonAction());

        // Adding stuff

        player1.add(user1);
        player1.add(p1);

        player2.add(comp2);
        player2.add(user2);
        player2.add(p2);
        player2.add(ai2);

        player3.add(comp3);
        player3.add(user3);
        player3.add(p3);
        player3.add(ai3);

        player4.add(comp4);
        player4.add(user4);
        player4.add(p4);
        player4.add(ai4);

        numberPlayers.add(numberOfPlayers);
        numberPlayers.add(number2);
        numberPlayers.add(number3);
        numberPlayers.add(number4);

        bottomButton.add(backButton);
        bottomButton.add(nextButton);

        // Adding things to main panel : bigOne

        bigOne.add(numberPlayers);

        bigOne.add(player1);
        bigOne.add(player2);
        bigOne.add(player3);
        bigOne.add(player4);

        bigOne.add(bottomButton);

        getContentPane().add(bigOne);

        setVisible(true);

        setLocationRelativeTo(null);
    }

    // Functions and stuff

    public void chooseNumberOfPlayers(JButton curButton) {
        if (curButton.getText() == "2") {
            comp3.setEnabled(false);
            user3.setEnabled(false);
            p3.setEnabled(false);
            ai3.setEnabled(false);

            comp4.setEnabled(false);
            user4.setEnabled(false);
            p4.setEnabled(false);
            ai4.setEnabled(false);

            numOfplayers = 2;

        } else if (curButton.getText() == "3") {
            comp3.setEnabled(true);
            user3.setEnabled(true);
            p3.setEnabled(true);
            ai3.setEnabled(false);

            comp4.setEnabled(false);
            user4.setEnabled(false);
            p4.setEnabled(false);
            ai4.setEnabled(false);

            numOfplayers = 3;

        }

        else if (curButton.getText() == "4") {
            comp3.setEnabled(true);
            user3.setEnabled(true);
            p3.setEnabled(true);
            ai3.setEnabled(false);

            comp4.setEnabled(true);
            user4.setEnabled(true);
            p4.setEnabled(true);
            ai4.setEnabled(false);

            numOfplayers = 4;
        }
    }

    public static int getNumberOfPlayers() {
        System.out.println("num :" + numOfplayers);
        return numOfplayers;
    }

    public static String getNameOfPlayers1() {
        return nameOfPlayers1;
    }

    public static String getNameOfPlayers2() {
        return nameOfPlayers2;
    }

    public static String getNameOfPlayers3() {
        return nameOfPlayers3;
    }

    public static String getNameOfPlayers4() {
        return nameOfPlayers4;
    }

    public void setAi(JCheckBox curBox, Integer i) {

        if (curBox.isSelected()) {
            ai.get(i).setEnabled(true);
        } else if (curBox.isSelected() == false) {
            ai.get(i).setEnabled(false);
        }
    }

    public void shapeSetter(JComboBox dropDown) {
        for (int i = 0; i < 4; i++) {
            if (shapeDropdowns.get(i) != dropDown) {
                if ((shapeDropdowns.get(i).getSelectedItem() == dropDown.getSelectedItem())
                        && (shapeDropdowns.get(i).getSelectedItem() != shapeDropdowns.get(i).getItemAt(0))) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "That shape has already been chosen!");
                    dropDown.setSelectedIndex(0);
                    break;
                }
            }
        }
    }

    public void aiDefaulter() {
        for (int i = 0; i < 3; i++) {
            if (ai.get(i).isEnabled()) {
                if (ai.get(i).getSelectedItem() == ai.get(i).getItemAt(0)) {
                    JFrame frame = new JFrame();
                    String message = "Difficulty has not been chosen,setting it to easy mode!";
                    JOptionPane.showMessageDialog(frame, message);
                    ai.get(i).setSelectedIndex(1);
                    break;
                }

            } else {
                continue;
            }
        }
    }

    public void shapeDefaulter() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (shapeDropdowns.get(i).isEnabled()) {
                if (shapeDropdowns.get(i).getSelectedItem() == shapeDropdowns.get(i).getItemAt(0)) {
                    JFrame frame = new JFrame();
                    String message = "Shape has not been chosen for player:" + Integer.toString(i + 1);
                    JOptionPane.showMessageDialog(frame, message);
                    break;
                } else {
                    count++;
                }
            }
        }
        if (count == numOfplayers) {
            nextTrue = true;
        }
    }

    public void savingFinal() {

        if (finalValues.size() != numOfplayers) {
            finalValues.clear();
        }

        ArrayList<String> temp;
        for (int i = 0; i < numOfplayers; i++) {

            temp = new ArrayList<String>();

            String compOrNot = "No";
            String currPlayer = "";
            String shape = "";
            String difficulty = "NA";

            if (i != 0) {
                difficulty = aidiffSelector(i);
                if (difficulty != "NA") {
                    compOrNot = "Yes";
                }
            }

            currPlayer = playerNames.get(i).getText();

            shape = (shapeDropdowns.get(i).getSelectedItem()).toString();

            temp.add(compOrNot);

            temp.add(currPlayer);
            temp.add(shape);
            temp.add(difficulty);

            finalValues.add(temp);

        }

    }

    public String aidiffSelector(Integer i) {
        if (ai.get(i - 1).isEnabled()) {
            return ai.get(i - 1).getSelectedItem().toString();
        }
        return "NA";
    }

    public void nextButtonAction() {
        shapeDefaulter();
        aiDefaulter();
        if (nextTrue == true) {
            savingFinal();
            showFinalValues();
            DisplaySetting display = new DisplaySetting();
            setVisible(false);
        }
    }

    public void showFinalValues() {
        JFrame frame = new JFrame();
        String listString = finalValues.stream().map(Object::toString).collect(Collectors.joining(", "));

        listString = listString.substring(1, listString.length() - 1);

        listString = listString.replace("], [", "\n");
        JOptionPane.showMessageDialog(frame, "Comp,Username,Shape,Difficulty\n" + listString);
    }

    public void backButtonAction() {
        setVisible(false);
    }

    public void addValues(ArrayList temp) {
        finalValues.add(temp);
    }

    // public static void main(String[] args) {
    // playerOptions start = new playerOptions();
    // }

}