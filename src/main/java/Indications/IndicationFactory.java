package Indications;

public class IndicationFactory {
    public Testimony createTestimony(int choice, String indicationSeason, double[] indication,
                                     int oldTestimony, int newTestimony) {


        switch (choice) {
            case 0 -> {
                return new WaterScores(indicationSeason, indication, oldTestimony, newTestimony);
            }
            case 1 -> {
                return new LightScores(indicationSeason, indication, oldTestimony, newTestimony);
            }
            case 2 -> {
                return new GasScores(indicationSeason, indication, oldTestimony, newTestimony);
            }
            default -> throw new IllegalArgumentException("Unknown channel " + choice);
        }
    }
}
