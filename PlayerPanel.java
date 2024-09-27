 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class PlayerPanel extends JPanel{
    Color colour = Color.white;
    public PlayerPanel(Shape shape){
        super();
        this.setPreferredSize(new Dimension(100,120));
        this.setBackground(colour);
////////////////////////////////////////////////////////////////////////////////
        //code for piece on panel
        this.setLayout(new BorderLayout());
        this.add(shape,BorderLayout.CENTER);
        shape.setHorizontalAlignment(JLabel.CENTER);
////////////////////////////////////////////////////////////////////////////////

    }
}
