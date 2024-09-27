import java.awt.Dimension;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Shape extends JLabel {
	private String shapeName;
	String fileName;
	Integer xcoord;
	Integer ycoord;
	Square curSquare;
    private UserColumn curColumn;


	public Shape(String name) {
		shapeName = name;
		fileName = "ShapeImages/";
		if (shapeName.equals("Diamond")) {
			fileName += "GreenDiamond.png";
		} else if (shapeName.equals("Circle")) {
			fileName += "RedCircle.png";
		} else if (shapeName.equals("Star")) {
			fileName += "OrangeStar.png";          //////////////////////////NEW CODE////////////////////////////////
		} else if (shapeName.equals("Square")) {
			fileName += "BlueSquare.png";
		} else if (shapeName.equals("Runner")) {
			fileName += "Runner.png";
		}
		imageSetting(fileName);
		this.setPreferredSize(new Dimension(22,22));
	}

	public String getShapeName() {
		return shapeName;
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

	public void imageSetting(String fileName) { 
		try {
			Image img = ImageIO.read(getClass().getResource(fileName));
			Image newimg = img.getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			ImageIcon imageIcon = new ImageIcon(newimg); // transform it back
			this.setIcon(imageIcon);

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	

    public UserColumn getCurColumn() {
    	return curColumn;
    }
    
    public void setCurColumn(UserColumn col) {
    	curColumn = col;
    }

	public void moveTo(Square sq) {
		if (!(curSquare == null)) {
			curSquare.revalidate();
			curSquare.repaint();
			curSquare.remove(this);
		}
		sq.revalidate();
		sq.repaint();
		sq.add(this);
		curSquare = sq;
		setXcoord(sq.getXcoord());
		setYcoord(sq.getYcoord());
	}
}
