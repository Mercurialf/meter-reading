import java.util.Scanner;
public class Utils {
    public static String repeatString(String s, int count) {
        StringBuilder r = new StringBuilder();
        int i = 0;
        while (i < count) {
            r.append(s);
            i++;
        }
        return r.toString();
    }

    public static void getDoubleFromUser(double[] scoreList) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 8; i++) {
            System.out.println("Input a double: ");
            double num = in.nextDouble();
            scoreList[i] = num;
        }
    }
}
