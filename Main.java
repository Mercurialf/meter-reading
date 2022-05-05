public class Main {
    // Функция проверки корректности суммы к оплате.
    public static boolean totalScore (double b, double p, double s, double a,
                                      double r, double c, double f, double t) {
        if (r > 0) {
            return (b + s + a + r + c + f) - p == t;
        } else if (r < 0) {
            return ((b + s + a + c + f - r) - p == t);
        }

        return false;
    }

    public static class ScoresList {
        // Добавить функцию расчета суммы необходимой оплаты с помощью тарифа.
        double beginningOfThePeriod, paid, subscriptionServices, accrued,
                recalculation, compensation, penaltyCosts, toBePaid;
        public ScoresList (double[] payslipList) {
            this.beginningOfThePeriod = payslipList[0];
            this.paid = payslipList[1];
            this.subscriptionServices = payslipList[2];
            this.accrued = payslipList[3];
            this.recalculation = payslipList[4];
            this.compensation = payslipList[5];
            this.penaltyCosts = payslipList[6];
            this.toBePaid = payslipList[7];
        }

        double tariff2022 = 250.00;
        public void tariffCalculation(int oldScores, int newScores) {
            double result = newScores - oldScores;
            if (result < tariff2022) {
                System.out.print("Tariff result: " + (result * 1.44));
            } else if (result > tariff2022) {
                double firstTariff= 250.0;
                result -= 250.00;
                System.out.print("Tariff result: " + ((firstTariff * 1.44) + (result * 1.68)));
            }
        }

        public void totalScoreCorrectTest() {
            double result;
            if (this.recalculation >= 0) {
                result = (beginningOfThePeriod + subscriptionServices + accrued + recalculation +
                                compensation + penaltyCosts) - paid;
                System.out.println("In total you have to pay: " + result + "\\" + toBePaid);
            } else if (this.recalculation <= 0) {
                result = (beginningOfThePeriod + subscriptionServices + accrued + compensation +
                        penaltyCosts - recalculation) - paid;
                System.out.println("In total you have to pay: " + result + "\\" + toBePaid);
            }
        }

        String[] titlesOfScores = {"1. At the beginning of the period: ", "2. Paid: ", "3. Subscriber services: ",
                                    "4. Accrued: ", "5. Recalculation: ", "6. Compensation: ",
                                    "7. Penalty\\Legal costs: ", "8. To be paid: "};
        public void printScores() {
            String repeated = repeatString("-", 60);
            String firstFormat = "%s%n%-40s%20.2f%n%s%n";
            String format = "%-40s%20.2f%n%s%n";

            // Попробовать реализовать вывод в консоль с помощью цикла.
            System.out.printf(firstFormat, repeated, titlesOfScores[0], beginningOfThePeriod, repeated);
            System.out.printf(format, titlesOfScores[1], paid, repeated);
            System.out.printf(format, titlesOfScores[2], subscriptionServices, repeated);
            System.out.printf(format, titlesOfScores[3], accrued, repeated);
            System.out.printf(format, titlesOfScores[4], recalculation, repeated);
            System.out.printf(format, titlesOfScores[5], compensation, repeated);
            System.out.printf(format, titlesOfScores[6], penaltyCosts, repeated);
            System.out.printf(format, titlesOfScores[7], toBePaid, repeated);

        }
    }

    public static String repeatString(String s, int count) {
        StringBuilder r = new StringBuilder();
        int i = 0;
        while (i < count) {
            r.append(s);
            i++;
        }
        return r.toString();
    }

    public static void main(String[] args) {
        double[] payslip = {980.54, 200.00, 0.0, 191.52, 31.68, 0.0, 0.0, 1003.74};
        ScoresList water = new ScoresList(payslip);
        water.printScores();
        water.totalScoreCorrectTest();
        water.tariffCalculation(10, 888);
    }
}