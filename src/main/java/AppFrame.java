import Utilities.Config;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

    AppFrame(){
        this.setPreferredSize(new Dimension(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT));
        this.setTitle("Meter Reading");
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
