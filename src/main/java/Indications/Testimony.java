package Indications;

import Utilities.Config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public abstract class Testimony implements Tariff{
    public String monthOfReceipt;
    public HashMap<String, Double> scores = new HashMap<>();
    public HashMap<String, Double> indication = new HashMap<>();

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
