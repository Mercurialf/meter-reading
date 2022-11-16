package Utilities;

import java.awt.*;

public class Config {
    public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 520;

    public static final String[] SCORES_NAME = {"At the beginning of the period", "Paid", "Subscriber services", "Accrued",
            "Recalculation", "Compensation", "Penalty/Legal costs", "To be paid"};
    public static final String[] mainMenuOptions = {"Make a statement", "Show readings", "Checking payment",
            "Tariff calculation", "Write receipt to file",
            "Read receipt from file"};

    public static final int mainBackgroundColor = 0xF4DED6;

    public static final Font standardFont = new Font("Ink Free", Font.PLAIN, 16);
    public static final Font titleFont = new Font("Ink Free", Font.BOLD, 18);

    public static final int[] coordinatesIndication = {50, 75, 100, 125, 150, 175, 200, 225};
    public static final int[] coordinatesButton = {10, 50, 90, 130, 170, 210};
}
