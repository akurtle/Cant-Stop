
import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class help extends JFrame {

    public JTextArea helpArea;
    public JPanel helpPanel;

    public help() {
        this.setResizable(false);
        this.setSize(500, 550);

        getContentPane().add(helpPanel);

    }
}
