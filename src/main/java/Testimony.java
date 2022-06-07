public class Testimony {
    public static class ScoresList {
        String monthOfReceipt;
        double beginningOfThePeriod, paid, subscriptionServices, accrued,
                recalculation, compensation, penaltyCosts, toBePaid;
        double[] titlesOfScoresValue;

        public ScoresList(String month, double[] payslipList) {
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
                double firstTariff = 250.0;
                result -= 250.00;
                result = (firstTariff * 1.44) + (result * 1.68);
            }
            return String.valueOf(result);
        }

        public double totalScoreCorrectTest() {

            double result = 0;

            if (this.recalculation >= 0) {
                result = (beginningOfThePeriod + subscriptionServices + accrued + recalculation +
                        compensation + penaltyCosts) - paid;
            } else if (this.recalculation <= 0) {
                result = (beginningOfThePeriod + subscriptionServices + accrued + compensation +
                        penaltyCosts - recalculation) - paid;
            }
            return result;
        }

        public void writeReadingsToFile() {
            Files.createFile(monthOfReceipt, titlesOfScoresValue);
        }
    }
}