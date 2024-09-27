
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.namespace.QName;

import java.util.ArrayList;

public class dataMaker {
        public String[][] finalValues;

        public ArrayList<String> displayValues;

        private String player1xy = "";
        private String player2xy = "null";
        private String player3xy = "null";
        private String player4xy = "null";

        private String player3 = "null";
        private String player4 = "null";

        public dataMaker() {
                super();
                player1xy = makingPlayerXData(GameController.playerTrackers.get(0));
                player2xy = makingPlayerXData(GameController.playerTrackers.get(1));

                if (playerOptions.finalValues.size() == 3) {
                        player3 = playerOptions.finalValues.get(2).toString();
                        player3xy = makingPlayerXData(GameController.playerTrackers.get(2));

                } else if (playerOptions.finalValues.size() == 4) {
                        player3 = playerOptions.finalValues.get(2).toString();
                        player4 = playerOptions.finalValues.get(3).toString();

                        player3xy = makingPlayerXData(GameController.playerTrackers.get(2));
                        player4xy = makingPlayerXData(GameController.playerTrackers.get(3));

                }

                displayValues = DisplaySetting.getValues();
                String[][] dataS = {
                                {
                                                "displayOptions", displayValues.get(0),
                                                displayValues.get(1),
                                                displayValues.get(2)
                                },
                                {
                                                "playerOptions", Integer.toString(playerOptions.getNumberOfPlayers()),
                                                playerOptions.finalValues.get(0).toString(),
                                                playerOptions.finalValues.get(1).toString(), player3, player4
                                },
                                { "Player1Shape positions(x and y)", player1xy },
                                { "Player2Shape positions(x and y)", player2xy },
                                { "Player3Shape positions(x and y)", player3xy },
                                { "Player4Shape positions(x and y)", player4xy },

                };

                finalValues = dataS;

        }

        public String makingPlayerXData(ArrayList<Shape> tracker) {
                String playerx = "";
                String playery = "";
                for (int i = 0; i < tracker.size(); i++) {

                        playerx += tracker.get(i).getXcoord().toString() + ";";
                        playery += tracker.get(i).getYcoord().toString() + ";";
                }
                return playerx + "," + playery;
        }

}
