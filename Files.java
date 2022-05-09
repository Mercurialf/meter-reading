import java.io.*;
import java.io.FileWriter;

public class Files {
    public static void createFile () {
        try (FileWriter file = new FileWriter("test.txt", false)) {
            file.write("test");
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
