import java.util.ArrayList;

public class easyAi {

    public ArrayList<Integer> combinationSum;

    public static ArrayList<Dice> dices;

    public Double randToRemove;

    public easyAi() {
        super();
        combinationSum = new ArrayList<Integer>();
        dices = new ArrayList<Dice>();
    }

    public void selectColumn(Dice d1, Dice d2, Dice d3, Dice d4) {

        dices.add(d1);
        dices.add(d2);
        dices.add(d3);
        dices.add(d4);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (dices.get(i).equals(dices.get(j))) {
                } else {
                    if (j % 2 == 0) {
                    } else {
                        Integer diceSum = dices.get(i).getValue() + dices.get(j).getValue();
                        combinationSum.add(diceSum);
                    }
                }
            }
        }

    }
}
