import Utilities.Config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

interface Tariff {
    double tariffCalculation();
}

public abstract class Testimony implements Tariff {
    protected String monthOfReceipt;
    protected HashMap<String, Double> scores = new HashMap<>();
    protected HashMap<String, Double> indication = new HashMap<>();

    public Testimony(String monthOfReceipt, double[] scores, double oldIndication, double newIndication) {

        setMonthOfReceipt(monthOfReceipt);
        setScores(scores);
        setIndication(oldIndication, newIndication);
    }

    public String getMonthOfReceipt() {
        return monthOfReceipt;
    }

    private void setMonthOfReceipt(String month) {
        DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy '@' HH:mm:ss");
        if (!month.equals("")) {
            monthOfReceipt = month + "|" + dateFormat.format(Calendar.getInstance().getTime());
        } else {
            monthOfReceipt = dateFormat.format(Calendar.getInstance().getTime());
        }
    }

    public HashMap<String, Double> getScores() {
        return scores;
    }

    private void setScores(double[] scores) {
        for (int i = 0; i < scores.length; i++) {
            this.scores.put(Config.SCORES_NAME[i], scores[i]);
        }
    }

    public HashMap<String, Double> getIndication() {
        return indication;
    }

    private void setIndication(double oldIndication, double newIndication) {
        indication.put("Old Indication", oldIndication);
        indication.put("New Indication", newIndication);
    }

    public double getDifferenceInIndications() {
        double newIndication = indication.get("New Indication");
        double oldIndication = indication.get("Old Indication");

        if (newIndication > oldIndication) {
            return (newIndication - oldIndication);
        } else {
            return 0;
        }
    }

    public double totalScoreCorrectTest() {
        double result = 0;
        if (scores.get("Recalculation") >= 0) {
            result = ((scores.get("At the beginning of the period") + scores.get("Subscriber services") +
                    scores.get("Accrued") + scores.get("Recalculation") + scores.get("Compensation") +
                    scores.get("Penalty/Legal costs")) - scores.get("To be paid"));
        }
        if (scores.get("Recalculation") <= 0) {
            result = (scores.get("At the beginning of the period") + scores.get("Subscriber services") +
                    scores.get("Accrued") + scores.get("Compensation") + scores.get("Penalty/Legal costs")) -
                    scores.get("Recalculation");
            result -= scores.get("To be paid");
        }
        return result;
    }
}

class LightScores extends Testimony {
    public LightScores(String monthOfReceipt, double[] scores, int oldIndication, int newIndication) {
        super(monthOfReceipt, scores, oldIndication, newIndication);
    }

    @Override
    public double tariffCalculation() {
        double minimumTariff = 250;
        double result = getDifferenceInIndications();

        if (result < minimumTariff) {
            result *= 1.44;
        }
        if (result > minimumTariff) {
            double firstTariff = 250;
            result -= firstTariff;
            result = (firstTariff * 1.44) + (result * 1.68);
        }
        return result;
    }
}

class WaterScores extends Testimony {
    public WaterScores(String monthOfReceipt, double[] scores, int oldIndication, int newIndication) {
        super(monthOfReceipt, scores, oldIndication, newIndication);
    }

    @Override
    public double tariffCalculation() {
        double result = getDifferenceInIndications();
        return ((result * 17.532) + (result * 16.512));
    }
}

class GasScores extends Testimony {
    public GasScores(String monthOfReceipt, double[] scores, int oldIndication, int newIndication) {
        super(monthOfReceipt, scores, oldIndication, newIndication);
    }

    @Override
    public double tariffCalculation() {
        double result = getDifferenceInIndications();
        return (result * 7.99);
    }
}