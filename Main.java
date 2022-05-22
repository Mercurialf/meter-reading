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

        public String tariffCalculation(int oldIndication, int newIndication) {

            double minimumTariff = 250.00;
            double result = newIndication - oldIndication;

            if (result < minimumTariff) {
                result *= 1.44;
            } else if (result > minimumTariff) {
                double firstTariff= 250.0;
                result -= 250.00;
                result = (firstTariff * 1.44) + (result * 1.68);
            }
            return String.valueOf(result);
        }

        public double totalScoreCorrectTest() {

            String correctTestFormat = "%s%n%-40s%20.2f%n%-40s%20.2f%n%-40s%n";
            double result = 0;

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
            return result;
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
}