
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextArea;

public class TopWindow extends JFrame implements ActionListener {

    private JButton button1, button2, button3, button4;

    public TopWindow() {
        setTitle("CAN'T STOP GAME");

        // Create a panel for the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Image backgroundImage = ImageIO.read(getClass().getResource("ShapeImages/back.jpg"));// new
                                                                                                         // ImageIcon("ShapeImages/back.jpg").getImage();
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        };
        JLabel textLabel = new JLabel("Welcome to the Game!");
        textLabel.setBounds(50, 20, 300, 50);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        backgroundPanel.add(textLabel);

        JMenuBar menuBar = new JMenuBar();
        JMenu helpMenu = new JMenu("Help");
        // helpMenu.addActionListener(e -> help());
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();

        buttonPanel.setOpaque(false); // Make the panel transparent

        // Add the buttons to the button panel
        button1 = new JButton("Start Game");
        button1.addActionListener(this);
        JButton button2 = new JButton("Load Game");
        button2.addActionListener(e -> loadingGame());

        JButton button3 = new JButton("Leaderboard");
        button1.setBounds(100, 80, 150, 50);
        button2.setBounds(100, 180, 150, 50);
        button3.setBounds(100, 280, 150, 50);
        buttonPanel.setLayout(null);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        // Add the panels to the frame
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);
        add(backgroundPanel);

        // Set the size and show the frame
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            playerOptions player = new playerOptions();
            // Board demo = new Board(Color.blue, Color.gray, "FullScreen",4);
        }

    }

    // public void help() {
    // JFrame helper = new JFrame();

    // JTextArea helpArea = new JTextArea("Can’t Stop (designed by Sid Sackson)" +
    // "Can’t Stop has been in and out of print several times since 1980. Currently
    // it’s out of print, so we’re playing on a"
    // +
    // "simple paper gameboard, using generic wooden cubes as playing pieces.");

    // JOptionPane.showMessageDialog(helper, helpArea);

    // }

    public void loadingGame() {
        loadData load = new loadData();

        if (load.checker == true) {
            this.setVisible(false);
        }

    }

}
