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
}
