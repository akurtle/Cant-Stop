 
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Grid extends JPanel{
    private Integer[][] gridSquareInts = new Integer[13][13];
    private Square[][] gridSquares = new Square[13][13];
    private String[] intText = new String[] {
    		"0000002000000",
    		"0000021200000",
    		"0000211120000",
    		"0002111112000",
    		"0021111111200",
    		"0211111111120",
            "0111111111110",
            "0111111111110",
            "0011111111100",
            "0001111111000",
            "0000111110000",
            "0000011100000",
            "0000001000000"};

    public Grid(Color colour) {
        super();
        this.setLayout(new GridLayout(13,13));
        this.setBackground(colour);
        //intText = new String[13];
        for (int i=0; i<13; i++) {
            for (int j=0; j<13; j++) {
                String text = intText[i];
                int val = Integer.parseInt(text.substring(j,j+1));
                gridSquareInts[i][j] = val;
            }
        }
        int rowNum=0;
        for (Integer[] row : gridSquareInts) {
            int colNum=0;
            for (int element: row) {
                JPanel panelForPanel = new JPanel();
                gridSquares[rowNum][colNum] = new Square(rowNum, colNum);
                if (element==0) {
                    gridSquares[rowNum][colNum].setColour(colour);
                }
                else {
                    gridSquares[rowNum][colNum].setColorToWhite();
                    gridSquares[rowNum][colNum].setXcoord(rowNum);
                    gridSquares[rowNum][colNum].setYcoord(colNum);
                }
                gridSquares [rowNum][colNum].setOpaque(true);
                if (element==2) {
                    JLabel ColumnNumber = new JLabel(Integer.toString(colNum+1));
                    ColumnNumber.setFont(new Font(ColumnNumber.getName(),Font.PLAIN,22));
                    gridSquares[rowNum][colNum].add(ColumnNumber);
                }
                panelForPanel.add(gridSquares[rowNum][colNum]);
                panelForPanel.setBackground(colour);
                this.add(panelForPanel);
                colNum+=1;
            }
            rowNum+=1;
        }

    }
    
    public Square getSquare(int x, int y) {
    	return gridSquares[x][y];
    }
    
    public Square[][] getGridSquares() {
    	return gridSquares;
    }
}
