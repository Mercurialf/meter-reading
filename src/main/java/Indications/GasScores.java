package Indications;

public class GasScores extends Testimony{
    public GasScores(String monthOfReceipt, double[] scores, int oldIndication, int newIndication) {
        super(monthOfReceipt, scores, oldIndication, newIndication);
    }

    @Override
    public double tariffCalculation() {
        double result = getDifferenceInIndications();
        return (result * 7.99);
    }
}
