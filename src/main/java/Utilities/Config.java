package Utilities;
import java.awt.*;

public class Config {

    public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 520;

    public static final Font standardFont = new Font("Ink Free", Font.PLAIN, 16);
    public static final Font titleFont = new Font("Ink Free", Font.BOLD,18);

    public static final String[] titlesOfScoresText = {"1. At the beginning of the period: ", "2. Paid: ", "3. Subscriber services: ",
            "4. Accrued: ", "5. Recalculation: ", "6. Compensation: ",
            "7. Penalty\\Legal costs: ", "8. To be paid: "};
    public static final String[] mainMenuOptions = {"Make a statement", "Show readings", "Checking payment",
            "Tariff calculation", "Write receipt to file",
            "Read receipt from file"};
}
