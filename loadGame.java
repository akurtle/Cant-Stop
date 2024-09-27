import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;

import javax.swing.border.Border;

public class loadGame {

    public ArrayList<String[]> data;

    public ArrayList<Shape> shape1;
    public ArrayList<Shape> shape2;
    public ArrayList<Shape> shape3;
    public ArrayList<Shape> shape4;

    public ArrayList<String> player3;

    public ArrayList<String> player4;

    ArrayList<String> player1x;
    ArrayList<String> player1y;

    ArrayList<String> player2x;
    ArrayList<String> player2y;

    ArrayList<String> player1;
    ArrayList<String> player2;

    public ArrayList<String> player3x;
    public ArrayList<String> player3y;

    public ArrayList<String> player4x;
    public ArrayList<String> player4y;

    public String threePlayer;
    public String fourPlayer;

    public HashMap<String, Color> stringToColor;

    Board demo;

    GameController gameController;

    public loadGame() {
        super();
        data = loadData.datas;
        player1 = new ArrayList<String>();
        player2 = new ArrayList<String>();
        player3 = new ArrayList<String>();
        player4 = new ArrayList<String>();

        playerOptions oldGame = new playerOptions();
        oldGame.setVisible(false);

        if (Integer.parseInt(data.get(1)[1]) == 3) {

            System.out.println("in three");

            addData(player3, 10);

            threePlayer = data.get(1)[11];

        } else if (Integer.parseInt(data.get(1)[1]) == 4) {
            System.out.println("in four of this");

            System.out.println("Adding in four");

            addData(player3, 10);

            threePlayer = data.get(1)[11].strip();

            addData(player4, 14);

            fourPlayer = data.get(1)[15].strip();
        }

        // threePlayer = loadData.threePlayer;

        // fourPlayer = loadData.fourPlayer;

        System.out.println(Integer.parseInt(data.get(1)[1]));

        System.out.println(threePlayer);
        System.out.println(fourPlayer);

        addData(player1, 2);

        addData(player2, 6);

        oldGame.addValues(player1);
        oldGame.addValues(player2);
        oldGame.addValues(player3);
        oldGame.addValues(player4);

        System.out.println(Integer.parseInt(data.get(1)[1]));
        System.out.println("Size");

        System.out.println(data.get(0)[3]);

        System.out.println(data.get(0)[2]);

        System.out.println(data.get(1)[3].strip());
        System.out.println(data.get(1)[7].strip());

        stringToColor = new HashMap<String, Color>();
        stringToColor.put("Blue", Color.blue);
        stringToColor.put("Red", Color.red);
        stringToColor.put("Yellow", Color.yellow);
        stringToColor.put("Green", Color.green);
        stringToColor.put("Gray", Color.gray);

        demo = new Board(stringToColor.get(data.get(0)[3]),
                stringToColor.get(data.get(0)[2]), data.get(0)[1].strip(),
                Integer.parseInt(data.get(1)[1]), data.get(1)[3].strip(), data.get(1)[7].strip(), threePlayer,
                fourPlayer);

        gameController = new GameController(demo);

        shape1 = new ArrayList<Shape>();
        shape2 = new ArrayList<Shape>();
        shape3 = new ArrayList<Shape>();
        shape4 = new ArrayList<Shape>();

        String shapeString11 = (String) playerOptions.finalValues.get(1 - 1).get(2);

        Shape playerShape11 = new Shape(shapeString11);
        Shape playerShape12 = new Shape(shapeString11);
        Shape playerShape13 = new Shape(shapeString11);

        shape1.add(playerShape11);
        shape1.add(playerShape12);
        shape1.add(playerShape13);

        player1x = new ArrayList<String>(Arrays.asList(data.get(2)[1].split(";")));

        player1y = new ArrayList<String>(Arrays.asList(data.get(2)[2].split(";")));

        player2x = new ArrayList<String>(Arrays.asList(data.get(3)[1].split(";")));

        player2y = new ArrayList<String>(Arrays.asList(data.get(3)[2].split(";")));

        for (int i = 0; i < player1x.size(); i++) {
            putPieces(shape1.get(i), player1x, player1y, i, 0);
        }

        String shapeString2 = (String) playerOptions.finalValues.get(2 - 1).get(2);

        Shape playerShape21 = new Shape(shapeString2);
        Shape playerShape22 = new Shape(shapeString2);
        Shape playerShape23 = new Shape(shapeString2);

        shape2.add(playerShape21);
        shape2.add(playerShape22);
        shape2.add(playerShape23);

        for (int i = 0; i < player2x.size(); i++) {
            putPieces(shape2.get(i), player2x, player2y, i, 1);
        }

        if (Integer.parseInt(data.get(1)[1]) == 3) {

            System.out.println("in Three!!");

            player3x = new ArrayList<String>(Arrays.asList(data.get(4)[1].split(";")));

            player3y = new ArrayList<String>(Arrays.asList(data.get(4)[2].split(";")));

            System.out.println("Created ArrayLists");

            String shapeString3 = (String) playerOptions.finalValues.get(3 - 1).get(2);

            Shape playerShape31 = new Shape(shapeString3);
            Shape playerShape32 = new Shape(shapeString3);
            Shape playerShape33 = new Shape(shapeString3);

            System.out.println("Shapes made!");

            shape3.add(playerShape31);
            shape3.add(playerShape32);
            shape3.add(playerShape33);

            for (int i = 0; i < player3x.size(); i++) {
                putPieces(shape3.get(i), player3x, player3y, i, 2);
            }

        } else if (Integer.parseInt(data.get(1)[1]) == 4) {

            player3x = new ArrayList<String>(Arrays.asList(data.get(4)[1].split(";")));

            player3y = new ArrayList<String>(Arrays.asList(data.get(4)[2].split(";")));

            player4x = new ArrayList<String>(Arrays.asList(data.get(5)[1].split(";")));

            player4y = new ArrayList<String>(Arrays.asList(data.get(5)[2].split(";")));

            System.out.println("in four");

            System.out.println(playerOptions.finalValues.size());

            System.out.println((String) playerOptions.finalValues.get(3 - 1).get(2));

            String shapeString3 = (String) playerOptions.finalValues.get(3 - 1).get(2);

            Shape playerShape31 = new Shape(shapeString3);
            Shape playerShape32 = new Shape(shapeString3);
            Shape playerShape33 = new Shape(shapeString3);

            shape3.add(playerShape31);
            shape3.add(playerShape32);
            shape3.add(playerShape33);

            for (int i = 0; i < player3x.size(); i++) {
                putPieces(shape3.get(i), player3x, player3y, i, 2);
            }

            String shapeString4 = (String) playerOptions.finalValues.get(4 - 1).get(2);

            Shape playerShape41 = new Shape(shapeString4);
            Shape playerShape42 = new Shape(shapeString4);
            Shape playerShape43 = new Shape(shapeString4);

            shape4.add(playerShape41);
            shape4.add(playerShape42);
            shape4.add(playerShape43);

            for (int i = 0; i < player4x.size(); i++) {
                putPieces(shape4.get(i), player4x, player4y, i, 3);
            }

        }

        System.out.println("failed!2");

    }

    public void putPieces(Shape playerShape, ArrayList playerx, ArrayList playery, Integer shapeNum,
            Integer playerNum) {

        playerShape.setXcoord(Integer.parseInt(playerx.get(shapeNum).toString()));
        playerShape.setYcoord(Integer.parseInt(playery.get(shapeNum).toString()));

        playerShape
                .setCurColumn(gameController.columnsList.get(Integer.parseInt(playery.get(shapeNum).toString()) + 1));

        System.out.println(playerx.size());
        System.out.println("Player Size:");

        System.out.println(playerx.get(shapeNum).toString());
        System.out.println(playery.get(shapeNum).toString());

        gameController.columnsList.get(Integer.parseInt(playery.get(shapeNum).toString()) + 1).setShapeRow(playerShape,
                Integer.parseInt(playerx.get(shapeNum).toString()));

        playerShape.moveTo(gameController.columnsList.get(Integer.parseInt(playery.get(shapeNum).toString()) + 1)
                .getSquare(Integer.parseInt(playerx.get(shapeNum).toString())));

        GameController.playerTrackers.get(playerNum).add(playerShape);

        System.out.println("End of putpieces");

    }

    public void addData(ArrayList<String> temp, Integer start) {
        for (int i = 0; i < 4; i++) {
            temp.add(data.get(1)[start + i].strip());
            System.out.println(data.get(1)[start + i].strip());
        }
    }
}