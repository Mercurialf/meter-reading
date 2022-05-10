import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;

public class Files {
    public static void createFile() {
        try (FileWriter file = new FileWriter("test.txt", true)) {
            file.write("\ntest");
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readFile() {
        try (FileReader file = new FileReader("test.txt")) {
            Scanner scan = new Scanner(file);
            int i = 1;

            while (scan.hasNextLine()) {
                System.out.println(i + " : " + scan.nextLine());
                i++;
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
