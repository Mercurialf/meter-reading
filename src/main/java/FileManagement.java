import Utilities.Config;
import Indications.*;

import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileManagement {
    public static void SaveFile(Testimony testimony, JTextArea outputTextField) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));

        int response = fileChooser.showSaveDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            File file;
            PrintWriter fileOut = null;

            file = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".txt");
            try {
                fileOut = new PrintWriter(file);
                fileOut.println(testimony.getMonthOfReceipt());
                for (int i = 0; i < testimony.scores.size(); i++) {
                    fileOut.println(Config.SCORES_NAME[i] + " : " + testimony.getScores().get(Config.SCORES_NAME[i]));
                }
                fileOut.println("New indication: " + testimony.getIndication().get("New Indication"));
                fileOut.println("Old indication: " + testimony.getIndication().get("Old Indication"));
                outputTextField.setText("File saving completed successfully");

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } finally {
                assert fileOut != null;
                fileOut.close();
            }
        }
    }

    public static void LoadFile(JTextArea outputTextField) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);

        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            Scanner fileIn = null;

            try {
                fileIn = new Scanner(file);
                if (file.isFile()) {
                    outputTextField.setText("");
                    while (fileIn.hasNextLine()) {
                        String line = fileIn.nextLine() + "\n";
                        outputTextField.append(line);
                    }
                }

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            finally {
                assert fileIn != null;
                fileIn.close();
            }
        }
    }
}
