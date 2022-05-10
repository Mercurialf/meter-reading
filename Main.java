public class Main {
    public static class ScoresList {
        String monthOfReceipt;
        double beginningOfThePeriod, paid, subscriptionServices, accrued,
                recalculation, compensation, penaltyCosts, toBePaid;
        double[] titlesOfScoresValue;
        public ScoresList (String month, double[] payslipList) {
            this.monthOfReceipt = month;
            this.beginningOfThePeriod = payslipList[0];
            this.paid = payslipList[1];
            this.subscriptionServices = payslipList[2];
            this.accrued = payslipList[3];
            this.recalculation = payslipList[4];
            this.compensation = payslipList[5];
            this.penaltyCosts = payslipList[6];
            this.toBePaid = payslipList[7];
            this.titlesOfScoresValue = payslipList;
        }

        public void tariffCalculation(int oldIndication, int newIndication) {
            String repeated = Utils.repeatString("-", 60);
            String correctTariffFormat = "%s%n%-40s%20.2f%n%s%n";
            double minimumTariff = 250.00;
            double result = newIndication - oldIndication;

            if (result < minimumTariff) {
                System.out.printf(correctTariffFormat, repeated, "Tariff result: " , (result * 1.44), repeated);
            } else if (result > minimumTariff) {
                double firstTariff= 250.0;
                result -= 250.00;
                System.out.printf(correctTariffFormat, repeated, "Tariff result: ",
                        ((firstTariff * 1.44) + (result * 1.68)), repeated);
            }
        }

        public void totalScoreCorrectTest() {
            String repeated = Utils.repeatString("-", 60);
            String correctTestFormat = "%s%n%-40s%20.2f%n%-40s%20.2f%n%-40s%n";
            double result;

            if (this.recalculation >= 0) {
                result = (beginningOfThePeriod + subscriptionServices + accrued + recalculation +
                                compensation + penaltyCosts) - paid;
                System.out.printf(correctTestFormat, repeated, "In total you have to pay: ",
                        result, "On the receipt: ", toBePaid, repeated);
            } else if (this.recalculation <= 0) {
                result = (beginningOfThePeriod + subscriptionServices + accrued + compensation +
                        penaltyCosts - recalculation) - paid;
                System.out.printf(correctTestFormat, repeated, "In total you have to pay: ",
                        result, "On the receipt: ", toBePaid, repeated);
            }
        }

        public void printScores() {
            String repeated = Utils.repeatString("-", 60);
            String firstFormat = "%s%n%30s%n%s%n";
            String format = "%-40s%20.2f%n%s%n";

            for (int i = 0; i < 8; i++) {
                if (i == 0) {
                    System.out.printf(firstFormat, repeated, monthOfReceipt, repeated);
                }
                System.out.printf(format, Config.titlesOfScoresText[i], titlesOfScoresValue[i], repeated);
            }
        }
    }

    public static class MainMenu {

        public static void printWelcome() {
            String repeat = Utils.repeatString("-", 60);
            System.out.println(repeat + "\nWelcome 'Meter Reading'!");
            System.out.println("Enter character to jump:");

            String format = "%-40s%20d%n";
            System.out.printf(format, "1. Print Scores:", 1);
            System.out.printf(format, "2. Total score correct test:", 2);
            System.out.printf(format, "3. Tariff calculation:", 3);
        }
    }


    public static void main(String[] args) {

        String indicationSeason = Utils.getStringFromUser();
        double[] indication = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        Utils.getDoubleFromUser(indication);

        ScoresList waterTest = new ScoresList(indicationSeason, indication);
        waterTest.printScores();

        Files.createFile();
        Files.readFile();

        MainMenu.printWelcome();
    }
}