import Utilities.Config;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
    private final JFrame frame;
    private final JLabel[] indicationName = new JLabel[8];
    private final JTextField[] indicationValue = new JTextField[8];
    private final JButton[] mainMenuButton = new JButton[6];
    private final JComboBox<String> comboBox;
    private final JTextField titleTextField;
    private final JTextField newTestimonyValue;
    private final JTextField oldTestimonyValue;
    private final JTextField differenceTestimonyValue;
    private final JTextArea outputTextField;
    private Testimony testimony;


    public Interface() {
        frame = new JFrame("Meter Reading");
        frame.getContentPane().setBackground(new Color(Config.mainBackgroundColor));

        {
            JLabel titleLabel = new JLabel("Enter Month Name/Year: ");
            titleLabel.setBounds(10, 10, 300, 25);
            titleLabel.setFont(Config.titleFont);
            frame.add(titleLabel);
        }

        {
            titleTextField = new JTextField();
            titleTextField.setBounds(300, 10, 150, 25);
            titleTextField.setFont(Config.standardFont);
            titleTextField.setText("Default date");
            frame.add(titleTextField);
        }

        for (int i = 0; i < indicationName.length; i++) {
            indicationName[i] = new JLabel(Config.SCORES_NAME[i]);
            indicationName[i].setFont(Config.standardFont);
            indicationName[i].setBounds(10, Config.coordinatesIndication[i], 300, 25);
            frame.add(indicationName[i]);
        }

        for (int i = 0; i < indicationValue.length; i++) {
            indicationValue[i] = new JTextField("0.0");
            indicationValue[i].setFont(Config.standardFont);
            indicationValue[i].setBounds(300, Config.coordinatesIndication[i], 150, 25);
            frame.add(indicationValue[i]);
        }

        for (int i = 0; i < mainMenuButton.length; i++) {
            mainMenuButton[i] = new JButton(Config.mainMenuOptions[i]);
            mainMenuButton[i].setEnabled(false);
            if (i == 0) {
                mainMenuButton[i].setEnabled(true);
            }
            mainMenuButton[i].setBounds(470, Config.coordinatesButton[i], 200, 35);
            frame.add(mainMenuButton[i]);
        }

        mainMenuButton[0].addActionListener(new MakeStatement());
        mainMenuButton[1].addActionListener(new ShowReadings());
        mainMenuButton[2].addActionListener(new ScoreCorrectTest());
        mainMenuButton[3].addActionListener(new TariffCalculation());
        mainMenuButton[4].addActionListener(new SaveNewFile());
        mainMenuButton[5].addActionListener(new LoadOldFile());

        {
            outputTextField = new JTextArea();
            outputTextField.setBounds(10, 270, 440, 200);
            outputTextField.setEditable(false);
            outputTextField.setFont(Config.standardFont);
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            outputTextField.setBorder(BorderFactory.createCompoundBorder(border,
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            frame.add(outputTextField);
        }

        {
            String[] services = {"Water", "Electricity", "Gas"};
            comboBox = new JComboBox<>(services);
            comboBox.setBounds(470, 270, 200, 25);
            frame.add(comboBox);
        }

        {
            JLabel newTestimony = new JLabel("New Testimony:");
            newTestimony.setBounds(470, 310, 150, 25);
            frame.add(newTestimony);

            JLabel oldTestimony = new JLabel("Old Testimony:");
            oldTestimony.setBounds(470, 360, 150, 25);
            frame.add(oldTestimony);

            JLabel differenceTestimony = new JLabel("Difference:");
            differenceTestimony.setBounds(470, 420, 150, 25);
            frame.add(differenceTestimony);
        }

        {
            newTestimonyValue = new JTextField("0");
            newTestimonyValue.setBounds(470, 335, 200, 25);
            frame.add(newTestimonyValue);

            oldTestimonyValue = new JTextField("0");
            oldTestimonyValue.setBounds(470, 385, 200, 25);
            frame.add(oldTestimonyValue);

            differenceTestimonyValue = new JTextField("0");
            differenceTestimonyValue.setBounds(470, 445, 200, 25);
            differenceTestimonyValue.setEditable(false);
            frame.add(differenceTestimonyValue);
        }

        frame.setSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Interface();
    }

    class MakeStatement implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double[] indication = new double[8];
            String indicationSeason = titleTextField.getText();
            int serviceSelection = comboBox.getSelectedIndex();
            int newTestimony = Integer.parseInt(newTestimonyValue.getText());
            int oldTestimony = Integer.parseInt(oldTestimonyValue.getText());

            for (int i = 0; i < 8; i++) {
                indication[i] = Double.parseDouble(indicationValue[i].getText());
            }

            switch (serviceSelection) {
                case 0 -> testimony = new WaterScores(indicationSeason, indication, oldTestimony, newTestimony);
                case 1 -> testimony = new LightScores(indicationSeason, indication, oldTestimony, newTestimony);
                case 2 -> testimony = new GasScores(indicationSeason, indication, oldTestimony, newTestimony);
            }

            outputTextField.setText("Testimony taken!");

            for (JButton jButton : mainMenuButton) {
                jButton.setEnabled(true);
            }
        }
    }

    class ShowReadings implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 8; i++) {
                if (i == 0) {
                    outputTextField.setText(testimony.getMonthOfReceipt() + "\n");
                }
                outputTextField.append(Config.SCORES_NAME[i] + testimony.getScores().get(Config.SCORES_NAME[i]) + "\n");
            }
        }
    }

    class TariffCalculation implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            differenceTestimonyValue.setText(String.valueOf(testimony.tariffCalculation()));
        }
    }

    class ScoreCorrectTest implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            outputTextField.setText("Correct test result: " + testimony.totalScoreCorrectTest());
        }
    }

    class SaveNewFile implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FileManagement.SaveFile(testimony, outputTextField);
        }
    }

    class LoadOldFile implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FileManagement.LoadFile(outputTextField);
        }
    }
}
