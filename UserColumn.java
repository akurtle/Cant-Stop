import java.util.HashMap;

public class UserColumn {
	private int userColNum;
	private int ycoord;
	// private Boolean containsRunner;
	private HashMap<Shape, Integer> shapeHashMap;
	private Shape circleForReference;
	private Shape squareForReference;
	private Shape starForReference;
	private Shape diamondForReference;

	private int runnerRow;
	private Grid grid;
	private Boolean claimed;
	private int topRow;

	public UserColumn(int colNum, Grid grid) {
		this.grid = grid;
		runnerRow = -1;
		userColNum = colNum;
		ycoord = colNum - 1;
		// containsRunner= false;
		shapeHashMap = new HashMap<Shape, Integer>();
		circleForReference = new Shape("Circle");
		squareForReference = new Shape("Square");
		starForReference = new Shape("Star");
		diamondForReference = new Shape("Diamond");
		shapeHashMap.put(circleForReference, -1);
		shapeHashMap.put(squareForReference, -1);
		shapeHashMap.put(starForReference, -1);
		shapeHashMap.put(diamondForReference, -1);
		claimed = false;
	}

	public int getRunnerRow() {
		return runnerRow;
	}

	public void setRunnerRow(int rowNum) {
		runnerRow = rowNum;
	}

	public int getShapeRow(Shape shape) {
		return shapeHashMap.get(getReferenceShape(shape));
	}

	public void setShapeRow(Shape shape, Integer rowNum) {
		shapeHashMap.put(getReferenceShape(shape), rowNum);
	}

	public Grid getGrid() {
		return grid;
	}

	public Square getSquare(int x) {
		return grid.getSquare(x, ycoord);
	}

	public int getYcoord() {
		return ycoord;
	}

	public int getUserColNum() {
		return userColNum;
	}

	public int getTopRow() {
		return topRow;
	}

	public void setTopRow(int rowNum) {
		topRow = rowNum;
	}

	public Boolean getClaimedVal() {
		return claimed;
	}

	public void claimColumn() {
		claimed = true;
	}
	/*
	 * public Boolean getContainsRunner() {
	 * return containsRunner;
	 * }
	 * 
	 * public void setContainsRunner(Boolean truthVal) {
	 * containsRunner = truthVal;
	 * }
	 */

	public Shape getReferenceShape(Shape shape) {
		if (shape.getShapeName().equals("Circle")) {
			return circleForReference;
		} else if (shape.getShapeName().equals("Square")) {
			return squareForReference;
		} else if (shape.getShapeName().equals("Star")) {
			return starForReference;
		} else if (shape.getShapeName().equals("Diamond")) {
			return diamondForReference;
		}
		return null;
	}
	/*
	 * public Boolean getContainsShape(Shape shape) {
	 * return shapeHashMap.get(getreferenceShape(shape));
	 * }
	 * 
	 * public void setContainsShape(Shape shape, Boolean truthVal) {
	 * shapeHashMap.put(getreferenceShape(shape),truthVal);
	 * }
	 */
}
