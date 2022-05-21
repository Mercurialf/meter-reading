import javax.swing.*;
import java.awt.*;

public class Interface {
    JFrame frame = new JFrame("Meter Reading");
    Font titleFont = new Font("Dialog", Font.PLAIN,18);
    Font standardFont = new Font("Dialog", Font.PLAIN, 16);
    JLabel[] indicationName = new JLabel[7];
    JTextField[] indicationValue = new JTextField[7];
    JButton[] mainMenuButton = new JButton[6];

    Interface() {

        JLabel titleLabel = new JLabel("Enter Month Name/Year: ");
        titleLabel.setBounds(10, 10, 300, 25);
        titleLabel.setFont(titleFont);
        JTextField titleTextField = new JTextField();
        titleTextField.setBounds(350, 10, 150, 25);
        titleTextField.setFont(standardFont);


        for (int i = 0; i < indicationName.length; i++) {
            indicationName[i] = new JLabel(Config.titlesOfScoresText[i]);
            indicationName[i].setFont(standardFont);
        }
        indicationName[0].setBounds(10, 50, 300, 25);
        indicationName[1].setBounds(10, 75, 300, 25);
        indicationName[2].setBounds(10, 100, 300, 25);
        indicationName[3].setBounds(10, 125, 300, 25);
        indicationName[4].setBounds(10, 150, 300, 25);
        indicationName[5].setBounds(10, 175, 300, 25);
        indicationName[6].setBounds(10, 200, 300, 25);

        for (int i = 0; i < indicationValue.length; i++) {
            indicationValue[i] = new JTextField();
            indicationValue[i].setFont(standardFont);
        }

        indicationValue[0].setBounds(350, 50, 150, 25);
        indicationValue[1].setBounds(350, 75, 150, 25);
        indicationValue[2].setBounds(350, 100, 150, 25);
        indicationValue[3].setBounds(350, 125, 150, 25);
        indicationValue[4].setBounds(350, 150, 150, 25);
        indicationValue[5].setBounds(350, 175, 150, 25);
        indicationValue[6].setBounds(350, 200, 150, 25);

        for (int i = 0; i < mainMenuButton.length; i++) {
            mainMenuButton[i] = new JButton(Config.mainMenuOptions[i]);
        }

        mainMenuButton[0].setBounds(505, 10, 160, 30);
        mainMenuButton[1].setBounds(505, 45, 160, 30);
        mainMenuButton[2].setBounds(505,80, 160, 30);
        mainMenuButton[3].setBounds(505, 115, 160, 30);
        mainMenuButton[4].setBounds(505,150,160, 30);
        mainMenuButton[5].setBounds(505, 195, 160, 40);


        frame.add(titleLabel);
        frame.add(titleTextField);

        for (JLabel jLabel : indicationName) {
            frame.add(jLabel);
        }

        for (JTextField jTextField : indicationValue) {
            frame.add(jTextField);
        }

        frame.add(mainMenuButton[0]);
        frame.add(mainMenuButton[1]);
        frame.add(mainMenuButton[2]);
        frame.add(mainMenuButton[3]);
        frame.add(mainMenuButton[4]);
        frame.add(mainMenuButton[5]);

        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Interface();
    }
}
