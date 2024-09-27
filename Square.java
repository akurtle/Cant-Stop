 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JPanel;
public class Square extends JPanel {
    private int xcoord, ycoord; //square location
    //private Boolean containsRunner;
    private Runner runnerOnSquare;
    /*
    private Boolean containsCircle;
    private Boolean containsSquare;
    private Boolean containsStar;
    private Boolean containsDiamond; */
    /*
    private HashMap<Shape, Boolean> containsShapeHashMap;
	private Shape circleForReference;
	private Shape squareForReference;
	private Shape starForReference;
	private Shape diamondForReference; */

    public Square(int xcoord, int ycoord)
    {
        super();
        this.setPreferredSize(new Dimension(44,44));
        this.xcoord=xcoord;
        this.ycoord=ycoord;
        this.setLayout(new GridLayout(2,2));
        //containsRunner = false;
        /*
        containsCircle = false;
        containsSquare = false;
        containsStar = false;
        containsDiamond = false;
        */
        /*
        containsShapeHashMap= new HashMap<Shape, Boolean>();
		circleForReference = new Shape("Circle");
		squareForReference = new Shape("Square");
		starForReference = new Shape("Star");
		diamondForReference = new Shape("Diamond");
		containsShapeHashMap.put(circleForReference, false);
		containsShapeHashMap.put(squareForReference, false);
		containsShapeHashMap.put(starForReference, false);
		containsShapeHashMap.put(diamondForReference, false);
		*/
    }

    public void setColorToWhite()
    {
        this.setBackground(Color.white);
    }

    public void setColorToRed() {
        this.setBackground(Color.red);
    }

    public void setColour(Color colour) {this.setBackground(colour);}
    public void setXcoord(int value)    { xcoord = value; }
    public void setYcoord(int value)    { ycoord = value; }
    public int getXcoord()              { return xcoord; }
    public int getYcoord()              { return ycoord; }
    
    public Runner getRunnerOnSquare() {
    	return runnerOnSquare;
    }
    
    public void setRunnerOnSquare(Runner runner) {
    	runnerOnSquare = runner;
    }
    
    /*
    public Boolean getContainsRunner() {
    	return containsRunner;
    }
    
    public void setContainsRunner(Boolean truthVal) {
    	containsRunner = truthVal;
    }*/
    /*
    public void setContainsRunnerToTrue() {
    	containsRunner = true;
    }
    
    public void setContainsRunnerToFalse() {
    	containsRunner = false;
    }
    */
    
    /*
    public Boolean getContainsCircle() {
    	return containsCircle;
    }
    
    public void setContainsCircle(Boolean truthVal) {
    	containsCircle = truthVal;
    }
    
    public Boolean getContainsSquare() {
    	return containsSquare;
    }
    
    public void setContainsSquare(Boolean truthVal) {
    	containsSquare = truthVal;
    }
    
    public Boolean getContainsStar() {
    	return containsStar;
    }
    
    public void setContainsStar(Boolean truthVal) {
    	containsStar = truthVal;
    }
    
    public Boolean getContainsDiamond() {
    	return containsDiamond;
    }
    
    public void setContainsDiamond(Boolean truthVal) {
    	containsDiamond = truthVal;
    }
    */
    /*
    public Shape getreferenceShape(Shape shape) {
		if (shape.getShapeName()=="Circle") {
			return circleForReference;
		}
		else if (shape.getShapeName()=="Square") {
			return squareForReference;
		}
		else if (shape.getShapeName()=="Star") {
			return starForReference;
		}
		else if (shape.getShapeName()=="Diamond") {
			return diamondForReference;
		}
		return null;
	}
    
    public Boolean getContainsShape(Shape shape) {
		return containsShapeHashMap.get(getreferenceShape(shape));
	}
	
	public void setContainsShape(Shape shape, Boolean truthVal) {
		containsShapeHashMap.put(getreferenceShape(shape),truthVal);
	} */
}