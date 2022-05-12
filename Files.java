import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;

public class Files {
    static String path = "";
    public static void createFile(String title, double[] indication) {
        try (FileWriter file = new FileWriter("Indication/" + title + ".txt", true)) {
            for (int i = 0; i < 8; i++) {
                if (i == 0) {
                    file.write(title + "\n");
                }
                file.write(Config.titlesOfScoresText[i] + " : " + indication[i] + "\n");
            }
            path = title;
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readFile() {
        try (FileReader file = new FileReader("Indication/" + path + ".txt")) {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
