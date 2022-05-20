import javax.swing.*;
import java.awt.*;

public class Interface {
    JFrame frame = new JFrame("Meter Reading");
    Font titleFont = new Font("Dialog", Font.BOLD,14);
    JLabel[] indicationName = new JLabel[7];
    JTextField[] indicationValue = new JTextField[7];

    Interface() {

        JLabel titleLabel = new JLabel("Enter Month Name/Year: ");
        titleLabel.setBounds(10, 10, 200, 25);
        titleLabel.setFont(titleFont);
        JTextField titleTextField = new JTextField();
        titleTextField.setBounds(210, 10, 150, 25);
        titleLabel.setFont(titleFont);

        for (int i = 0; i < indicationName.length; i++) {
            indicationName[i] = new JLabel(Config.titlesOfScoresText[i]);
        }
        indicationName[0].setBounds(10, 50, 200, 25);
        indicationName[1].setBounds(10, 75, 200, 25);
        indicationName[2].setBounds(10, 100, 200, 25);
        indicationName[3].setBounds(10, 125, 200, 25);
        indicationName[4].setBounds(10, 150, 200, 25);
        indicationName[5].setBounds(10, 175, 200, 25);
        indicationName[6].setBounds(10, 200, 200, 25);

        for (int i = 0; i < indicationValue.length; i++) {
            indicationValue[i] = new JTextField();
        }

        indicationValue[0].setBounds(210, 50, 150, 25);
        indicationValue[1].setBounds(210, 75, 150, 25);
        indicationValue[2].setBounds(210, 100, 150, 25);
        indicationValue[3].setBounds(210, 125, 150, 25);
        indicationValue[4].setBounds(210, 150, 150, 25);
        indicationValue[5].setBounds(210, 175, 150, 25);
        indicationValue[6].setBounds(210, 200, 150, 25);


        frame.add(titleLabel);
        frame.add(titleTextField);

        for (JLabel jLabel : indicationName) {
            frame.add(jLabel);
        }

        for (JTextField jTextField : indicationValue) {
            frame.add(jTextField);
        }

        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Interface();
    }
}
