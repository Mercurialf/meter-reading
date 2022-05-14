public class Main {
    public static class ScoresList {
        String monthOfReceipt;
        double beginningOfThePeriod, paid, subscriptionServices, accrued,
                recalculation, compensation, penaltyCosts, toBePaid;
        double[] titlesOfScoresValue;
        String repeatChar = Utils.repeatString("-", 60);
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

            String correctTariffFormat = "%s%n%-40s%20.2f%n%s%n";
            double minimumTariff = 250.00;
            double result = newIndication - oldIndication;

            if (result < minimumTariff) {
                System.out.printf(correctTariffFormat, repeatChar, "Tariff result: " , (result * 1.44), repeatChar);
            } else if (result > minimumTariff) {
                double firstTariff= 250.0;
                result -= 250.00;
                System.out.printf(correctTariffFormat, repeatChar, "Tariff result: ",
                        ((firstTariff * 1.44) + (result * 1.68)), repeatChar);
            }
        }

        public void totalScoreCorrectTest() {

            String correctTestFormat = "%s%n%-40s%20.2f%n%-40s%20.2f%n%-40s%n";
            double result;

            if (this.recalculation >= 0) {
                result = (beginningOfThePeriod + subscriptionServices + accrued + recalculation +
                                compensation + penaltyCosts) - paid;
                System.out.printf(correctTestFormat, repeatChar, "In total you have to pay: ",
                        result, "On the receipt: ", toBePaid, repeatChar);
            } else if (this.recalculation <= 0) {
                result = (beginningOfThePeriod + subscriptionServices + accrued + compensation +
                        penaltyCosts - recalculation) - paid;
                System.out.printf(correctTestFormat, repeatChar, "In total you have to pay: ",
                        result, "On the receipt: ", toBePaid, repeatChar);
            }
        }

        public void printScores() {

            String firstFormat = "%s%n%30s%n%s%n";
            String format = "%-40s%20.2f%n%s%n";

            for (int i = 0; i < 8; i++) {
                if (i == 0) {
                    System.out.printf(firstFormat, repeatChar, monthOfReceipt, repeatChar);
                }
                System.out.printf(format, Config.titlesOfScoresText[i], titlesOfScoresValue[i], repeatChar);
            }
        }

        public void writeReadingsToFile () {
            Files.createFile(monthOfReceipt, titlesOfScoresValue);
        }
    }

    public static class MainMenu {
        String repeatChar = Utils.repeatString("-", 60);
        int choice = 0;
        ScoresList water;

        public void printWelcome() {

            System.out.println(repeatChar + "\nWelcome to Meter Reading!\n" + repeatChar);
            while (choice != 9) {

                System.out.println(repeatChar);
                for (int i = 0; i < Config.mainMenuOptions.length; i++) {
                    System.out.println(Config.mainMenuOptions[i] + " : " + i);
                }

                choice = Utils.getIntegerFromUser();

                switch (choice) {
                    case 1 -> {
                        String indicationSeason = Utils.getStringFromUser();
                        double[] indication = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
                        Utils.getDoubleFromUser(indication);
                        water = new ScoresList(indicationSeason, indication);
                    }
                    case 2 -> water.printScores();
                    case 3 -> water.totalScoreCorrectTest();
                    case 4 -> water.tariffCalculation(0, 0);
                    case 5 -> water.writeReadingsToFile();
                    case 6 -> Files.readFile();
                }
            }
        }
    }


    public static void main(String[] args) {

        MainMenu start = new MainMenu();
        start.printWelcome();

    }
}