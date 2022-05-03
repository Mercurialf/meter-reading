public class Main {
    // Функция проверки корректности суммы к оплате.
    public static boolean totalScore (double b, double p, double s, double a,
                                      double r, double c, double f, double t) {
        if (r > 0) {
            return (b + s + a + r + c + f) - p == t;
        } else if (r < 0) {
            return ((b + s + a + c + f) - (p + r)) == t;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(totalScore(980.54, 200.00, 0.0, 191.52,
                                            31.68, 0.0, 0.0, 1003.74));
        System.out.println(totalScore(377.22,160.00,0.0,126.48,
                                            -30.76,0.0,0.0,312.95));
    }
}