import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Pattern pattern = Pattern.compile("([A-Za-z])(\\d+)([A-Za-z])");
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < input.length; i++) {

            String current = input[i];
            Matcher matcher = pattern.matcher(current);
            if (matcher.find()) {
                char firstLetter = matcher.group(1).charAt(0);
                BigDecimal number = new BigDecimal(matcher.group(2));
                char secondLetter = matcher.group(3).charAt(0);

                if (Character.isUpperCase(firstLetter)) {
                    int num = firstLetter - 64;
                    number = number.divide(new BigDecimal(num),5,BigDecimal.ROUND_HALF_UP);
                } else {
                    int num = firstLetter - 96;
                    number = number.multiply(new BigDecimal(num));
                }

                if (Character.isUpperCase(secondLetter)) {
                    int num = secondLetter - 64;
                    number = number.subtract(new BigDecimal(num));
                } else {
                    int num = secondLetter - 96;
                    number = number.add(new BigDecimal(num));
                }
                sum = sum.add(number);
            }

        }

        //DecimalFormat format = new DecimalFormat("#.00");
        //System.out.println(format.format(sum.setScale(2,BigDecimal.ROUND_HALF_UP)));
        System.out.println(sum.setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
