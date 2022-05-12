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
            if (i == 0) {
                System.out.println(repeatString("-", 60));
            }
            System.out.print(Config.titlesOfScoresText[i]);
            double num = in.nextDouble();
            scoreList[i] = num;

            if (i == 7) {
                System.out.println(repeatString("-", 60));
            }
        }
    }

    public static String getStringFromUser() {
        String repeatChar = repeatString("-", 60);
        String firstForm = "%s%n%s";
        String lastForm = "%s%n";

        System.out.printf(firstForm, repeatChar, "Enter Month and Year: ");
        Scanner in = new Scanner(System.in);
        String result = in.nextLine();

        if (result.equals("")) {
            result = "Default";
        }

        System.out.printf(lastForm, repeatChar);
        return result;
    }

    public static int getIntegerFromUser() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}
