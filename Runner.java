import java.awt.Dimension;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Runner extends JLabel{
	String fileName;
	Integer xcoord, ycoord;
	Square curSquare;
	UserColumn curColumn;
	//int columnNum;  //CHANGE THIS TO UserColumn
	
	public Runner() {
		fileName ="ShapeImages/Runner.png";
		imageSetting(fileName);
		this.setPreferredSize(new Dimension(22,22));
	}
	
	public Integer getXcoord() {
        return xcoord;
    }

    public Integer getYcoord() {
        return ycoord;
    }
    
    public void setXcoord(int xVal) {
    	xcoord = xVal;
    }
    
    public void setYcoord(int yVal) {
    	ycoord = yVal;
    }
    
    public Square getCurSquare() {
    	return curSquare;
    }
    
    public void setCurSquare(Square sq) {
    	curSquare = sq;
    }
    /*
    public int getColumnNum() {
    	return columnNum;
    }
    
    public void setColumnNum(int colNum) {
    	columnNum = colNum;
    }
    */
    
    public UserColumn getCurColumn() {
    	return curColumn;
    }
    
    public void setCurColumn(UserColumn col) {
    	curColumn = col;
    }
    
    public void imageSetting(String fileName) { //, JLabel place) {
        try {
            Image img = ImageIO.read(getClass().getResource(fileName));
            Image newimg = img.getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH);
            // scale it the smooth way
            ImageIcon imageIcon = new ImageIcon(newimg); // transform it back
            this.setIcon(imageIcon);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    /*
    public void moveUpColumn() {
    	UserColumn col = getCurColumn();
    	if (!(curSquare == null)) {
    		curSquare.revalidate();
        	curSquare.repaint();
        	curSquare.remove(this);
    	}
    	curSquare = col.getSquare(col.getRunnerRow()-1,col.getYcoord());
    	curSquare.revalidate();
    	curSquare.repaint();
    	curSquare.add(this);
    	setXcoord(curSquare.getXcoord());
    	setYcoord(curSquare.getYcoord());
    	
    }*/
    
    public void moveTo(Square sq) {
    	if (!(curSquare == null)) {
    		curSquare.revalidate();
        	curSquare.repaint();
        	curSquare.remove(this);
        	//curSquare.setContainsRunner(false);   //CHANGE THIS TO UserColumn
        	curSquare.setRunnerOnSquare(null);
    	}
    	sq.revalidate();
		sq.repaint();
    	sq.add(this);
    	//sq.setContainsRunner(true);   //CHANGE THIS TO UserColumn
    	sq.setRunnerOnSquare(this);
    	curSquare = sq;
    	//setColumnNum(sq.getYcoord()+1);
    	setXcoord(sq.getXcoord());
    	setYcoord(sq.getYcoord());
    	//System.out.println("X and Y: "+Integer.toString(getXcoord())+" "+Integer.toString(getYcoord()));
    }
}
