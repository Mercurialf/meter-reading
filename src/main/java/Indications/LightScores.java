package Indications;

public class LightScores extends Testimony{
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
