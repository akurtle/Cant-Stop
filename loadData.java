import javax.annotation.processing.Filer;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.FileWriter;

import java.util.*;

import java.io.*;

public class loadData extends JFrame {

    public static ArrayList<String[]> datas;

    public JFileChooser chooser;

    public static String threePlayer;
    public static String fourPlayer;

    public Boolean checker = false;

    String line = "";

    String splitter = ",";

    public loadData() {
        super();

        chooser = new JFileChooser();
        datas = new ArrayList<String[]>();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
        chooser.setFileFilter(filter);

        JFrame loading = new JFrame();
        int returnVal = chooser.showOpenDialog(loading);

        File f = chooser.getSelectedFile();

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            if (f.getName().contains("csv")) {
                try {

                    FileReader fileReader = new FileReader(f);
                    BufferedReader br = new BufferedReader(fileReader);

                    while ((line = br.readLine()) != null) {

                        // String[] datas = line.split(splitter);

                        datas.add(line.split(splitter));

                        // temp = new ArrayList<String>(Arrays.asList(line.split("/")));

                        // playerOptions.finalValues.add(temp);

                        // temp.clear();

                    }

                    br.close();

                    loadGame loader = new loadGame();

                    checker = true;

                } catch (Exception e) {
                    // TODO: handle exception
                }

            } else {
                JFrame error = new JFrame();
                JOptionPane.showMessageDialog(error, "Please save to a csv file!(Add .csv to your file) \n Try again!");
            }

        }
    }

}
