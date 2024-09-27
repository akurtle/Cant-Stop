import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

import java.io.*;

public class newSave extends JFrame {
    public JFileChooser chooser;

    public newSave() {
        super();

        // Adds data to a String[][]
        dataMaker dataStuff = new dataMaker();

        // Saving a file without pop up

        // saveFile(dataStuff.finalValues);
        // System.exit(0);

        // Saving a file using pop up

        chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
        chooser.setFileFilter(filter);
        JFrame saving = new JFrame();
        int returnVal = chooser.showSaveDialog(saving);
        File f = chooser.getSelectedFile();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            if (f.getName().contains("csv")) {
                addData adding = new addData(f, dataStuff.finalValues);
                System.exit(0);
            } else {
                JFrame error = new JFrame();
                JOptionPane.showMessageDialog(error, "Please save to a csv file!(Add .csv to your file) \n Try again!");
            }

        }
    }

    // Saving a file without pop up
    public void saveFile(String[][] data) {
        File savedFile = new File("savedData.csv");
        addData adding = new addData(savedFile, data);
    }

}