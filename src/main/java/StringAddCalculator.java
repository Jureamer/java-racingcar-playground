import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public int splitAndSum(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }

        if (string.length() == 1) {
            return Integer.parseInt(string);
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);
        if (m.find()) {
            String customDelimiter = m.group(1);
            int sum = addCalculator(customDelimiter, m.group(2));
            return sum;
        }

        return addCalculator("", string);
    }

    private int addCalculator(String delimiter, String string) {
        if (delimiter == "") {
            delimiter = ":|,";
        }

        String[] tokens= string.split(delimiter);
        int sum = 0;

        for (String t : tokens) {
            int parsedInt = Integer.parseInt(t.trim());
            if (parsedInt < 0) {
                throw new RuntimeException("음수는 허용되지 않습니다: " + parsedInt);
            }
            sum += parsedInt;
        }

        return sum;
    }
}
