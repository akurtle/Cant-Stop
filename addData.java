import java.util.*;

import java.io.*;

public class addData {
    public addData(File file, String[][] data) {
        super();

        // Writing to file

        try (FileWriter fileWriter = new FileWriter(file);) {
            for (int i = 0; i < data.length; i++) {
                fileWriter.write(data[i][0] + ":,");
                for (int j = 1; j < data[i].length; j++) {
                    fileWriter.write(data[i][j] + ",");

                }
                fileWriter.write("\n");
            }
        } catch (IOException e) {

        }
        // try (FileWriter fileWriter = new FileWriter(file);) {
        // fileWriter.write(data[0][0] + ":,");
        // for (int i = 1; i < data[0].length; i++) {
        // fileWriter.write(data[0][i] + ",");
        // }
        // fileWriter.write("\n");

        // fileWriter.write(data[1][0] + ":,");
        // for (int i = 1; i < data[1].length; i++) {
        // fileWriter.write(data[1][i] + ",");
        // }
        // fileWriter.write("\n");

        // fileWriter.write(data[2][0] + ":,");
        // for (int i = 1; i < data[2].length; i++) {
        // fileWriter.write(data[2][i] + ",");

        // }

        // fileWriter.write("\n");

        // fileWriter.write(data[3][0] + ":,");
        // for (int i = 1; i < data[3].length; i++) {
        // fileWriter.write(data[3][i] + ",");
        // if (i % 2 == 0) {
        // fileWriter.write("\n");
        // }
        // }

        // fileWriter.write("\n");

        // fileWriter.write(data[4][0] + ":,");
        // for (int i = 1; i < data[4].length; i++) {
        // fileWriter.write(data[4][i] + ",");

        // }

        // fileWriter.write("\n");

        // fileWriter.write(data[5][0] + ":,");
        // for (int i = 1; i < data[5].length; i++) {
        // fileWriter.write(data[5][i] + ",");
        // }
        // fileWriter.write("\n");

        // fileWriter.write(data[6][0] + ":,");
        // for (int i = 1; i < data[6].length; i++) {
        // fileWriter.write(data[6][i] + ",");
        // }
        // fileWriter.write("\n");

        // fileWriter.write(data[7][0] + ":,");
        // for (int i = 1; i < data[7].length; i++) {
        // fileWriter.write(data[7][i] + ",");
        // }
        // fileWriter.write("\n");

        // fileWriter.write(data[5][0] + ":,");
        // for (int i = 1; i < data[5].length; i++) {
        // fileWriter.write(data[5][i] + ",");
        // }
        // fileWriter.write("\n");

        // catch (IOException e) {
        // // TODO: handle exception
        // }

    }

}
