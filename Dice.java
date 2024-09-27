 
import java.awt.Color;
//import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
public class Dice extends JButton {// implements ActionListener{
	
	private int value;
	private Image img;
	private Boolean selected;
    private Random random;
	
    public Dice() {
        super();
        random = new Random();
        value=random.nextInt(6)+1;
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(40,40));
        //this.addActionListener(this);
        setImage(value);
        selected = false;
    }
    public void setValue(int val) {
    	this.value=val;
    	setImage(value);
    	selected =false;
    }
    
    public int getValue() {
    	return value;
    }
    
    public Boolean getSelected() {
    	return selected;
    }
    
    public void setSelected(Boolean truthVal) {
    	selected=truthVal;
    }
    
    public String imageName(int Val) {
    	return "ShapeImages/dice"+Integer.toString(Val)+".png";
    }
    public String selectedImageName(int Val) {
    	return "ShapeImages/dice"+Integer.toString(Val)+"selected.png";
    }
    public void setImage(int val) {
    	String fileName = imageName(val);
    	imageSetting(fileName);
    	selected=false;
    }
    
    public void setSelectedImage(int val) {
    	String fileName = selectedImageName(val);
    	imageSetting(fileName);
    	selected=true;
    }
    
    public void imageSetting(String fileName) {
    	try {
	    	img = ImageIO.read(getClass().getResource(fileName));
	    	Image newimg = img.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	    	ImageIcon imageIcon = new ImageIcon(newimg);  // transform it back
	    	this.setIcon(imageIcon);
    	}
    	catch (Exception ex) {
    		System.out.println(ex);
    	}
    }
    
    public void unselectDice() {
    	this.setImage(value);
    	selected=false;
    }
    /*
    public void actionPerformed(ActionEvent aevt) {
        Object selectedButton = aevt.getSource();
        if (selectedButton.equals(this)) {
        	this.setSelectedImage(value);
        	selected = true;
        }
    }*/
}
