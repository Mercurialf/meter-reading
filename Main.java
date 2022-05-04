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
        public void printScoresTest() {
            String repeated = repeatString("-", 60);
            String format = "%-40s%20.2f%n";

            System.out.println(repeated);
            System.out.printf(format, "At the beginning of the period: ", beginningOfThePeriod);
            System.out.println(repeated);
            System.out.printf(format, "Paid: " , paid);
            System.out.println(repeated);
            System.out.printf(format, "Subscriber services: ", subscriptionServices);
            System.out.println(repeated);
            System.out.printf(format, "Accrued: ", accrued);
            System.out.println(repeated);
            System.out.printf(format, "Recalculation: ", recalculation);
            System.out.println(repeated);
            System.out.printf(format, "Compensation: ", compensation);
            System.out.println(repeated);
            System.out.printf(format, "Penalty\\Legal costs: ", penaltyCosts);
            System.out.println(repeated);
            System.out.printf(format, "To be paid: ", toBePaid);
            System.out.println(repeated);

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
        water.printScoresTest();
    }
}