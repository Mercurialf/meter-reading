import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Interface {
    JFrame frame = new JFrame("Meter Reading");
    JLabel[] indicationName = new JLabel[8];
    JTextField[] indicationValue = new JTextField[8];
    JButton[] mainMenuButton = new JButton[6];
    Main.ScoresList indicationList;

    Interface() {

        JLabel titleLabel = new JLabel("Enter Month Name/Year: ");
        titleLabel.setBounds(10, 10, 300, 25);
        titleLabel.setFont(Config.titleFont);
        JTextField titleTextField = new JTextField();
        titleTextField.setBounds(300, 10, 150, 25);
        titleTextField.setFont(Config.standardFont);


        for (int i = 0; i < indicationName.length; i++) {
            indicationName[i] = new JLabel(Config.titlesOfScoresText[i]);
            indicationName[i].setFont(Config.standardFont);
        }
        indicationName[0].setBounds(10, 50, 300, 25);
        indicationName[1].setBounds(10, 75, 300, 25);
        indicationName[2].setBounds(10, 100, 300, 25);
        indicationName[3].setBounds(10, 125, 300, 25);
        indicationName[4].setBounds(10, 150, 300, 25);
        indicationName[5].setBounds(10, 175, 300, 25);
        indicationName[6].setBounds(10, 200, 300, 25);
        indicationName[7].setBounds(10, 225,300, 25);

        for (int i = 0; i < indicationValue.length; i++) {
            indicationValue[i] = new JTextField();
            indicationValue[i].setFont(Config.standardFont);
        }

        indicationValue[0].setBounds(300, 50, 150, 25);
        indicationValue[1].setBounds(300, 75, 150, 25);
        indicationValue[2].setBounds(300, 100, 150, 25);
        indicationValue[3].setBounds(300, 125, 150, 25);
        indicationValue[4].setBounds(300, 150, 150, 25);
        indicationValue[5].setBounds(300, 175, 150, 25);
        indicationValue[6].setBounds(300, 200, 150, 25);
        indicationValue[7].setBounds(300, 225, 150, 25);

        for (int i = 0; i < mainMenuButton.length; i++) {
            mainMenuButton[i] = new JButton(Config.mainMenuOptions[i]);
        }

        JTextArea outputTextField = new JTextArea();
        outputTextField.setBounds(10, 270, 660, 200);
        outputTextField.setEditable(false);
        outputTextField.setFont(Config.standardFont);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        outputTextField.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        mainMenuButton[0].setBounds(470, 10, 200, 35);
        mainMenuButton[0].addActionListener(e -> {
            double[] indication = new double[8];
            String indicationSeason = titleTextField.getText();
            for (int i = 0; i < 8; i++) {
                indication[i] = Double.parseDouble(indicationValue[i].getText());
            }
            indicationList = new Main.ScoresList(indicationSeason, indication);
            outputTextField.setText("Testimony taken!");
        });

        mainMenuButton[1].setBounds(470, 50, 200, 35);
        mainMenuButton[1].addActionListener(e -> {
            outputTextField.setText(indicationList.monthOfReceipt + "\n" +
                    Config.titlesOfScoresText[0] + indicationList.titlesOfScoresValue[0] + "\n" +
                    Config.titlesOfScoresText[1] + indicationList.titlesOfScoresValue[1] + "\n" +
                    Config.titlesOfScoresText[2] + indicationList.titlesOfScoresValue[2] + "\n" +
                    Config.titlesOfScoresText[3] + indicationList.titlesOfScoresValue[3] + "\n" +
                    Config.titlesOfScoresText[4] + indicationList.titlesOfScoresValue[4] + "\n" +
                    Config.titlesOfScoresText[5] + indicationList.titlesOfScoresValue[5] + "\n" +
                    Config.titlesOfScoresText[6] + indicationList.titlesOfScoresValue[6] + "\n" +
                    Config.titlesOfScoresText[7] + indicationList.titlesOfScoresValue[7] + "\n" );
        });

        mainMenuButton[2].setBounds(470,90, 200, 35);
        mainMenuButton[3].setBounds(470, 130, 200, 35);
        mainMenuButton[4].setBounds(470,170,200, 35);
        mainMenuButton[5].setBounds(470, 210, 200, 35);


        frame.add(titleLabel);
        frame.add(titleTextField);
        frame.add(outputTextField);

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

        frame.setSize(695, 520);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Interface();
    }
}
