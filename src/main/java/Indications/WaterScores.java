package Indications;

public class WaterScores extends Testimony{
    public WaterScores(String monthOfReceipt, double[] scores, int oldIndication, int newIndication) {
        super(monthOfReceipt, scores, oldIndication, newIndication);
    }

    @Override
    public double tariffCalculation() {
        double result = getDifferenceInIndications();
        return ((result * 17.532) + (result * 16.512));
    }
}
