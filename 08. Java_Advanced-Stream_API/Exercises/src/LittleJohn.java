import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {

    public static void main(String[] args) {

        int countOfStrings = 4;
        Scanner scanner = new Scanner(System.in);
        String patternSmallArrow = "(?<!>)(>----->)";
        String patternMediumArrow = "(>>----->)";
        String patternLargeArrow = "(>>>----->>)";

        String[] patterns = {patternLargeArrow, patternMediumArrow, patternSmallArrow};
        int[] countArrows = new int[patterns.length];

        for (int i = 0; i < countOfStrings; i++) {

            String line = scanner.nextLine();

            for (int j = 0; j < countArrows.length; j++) {

                Pattern currentPattern = Pattern.compile(patterns[j]);
                Matcher matcher = currentPattern.matcher(line);

                while (matcher.find()) {
                    countArrows[j] += 1;
                    line = line.replaceFirst(matcher.group(), "");
                }

            }
        }

        String concat = "";
        for (int i = countArrows.length - 1; i >= 0; i--) {
            concat += countArrows[i];
        }

        Integer concatNumber = Integer.parseInt(concat);
        String binary = Integer.toBinaryString(concatNumber);
        String newBinary = new StringBuilder(binary).reverse().toString();
        Integer newNumber = Integer.parseInt(binary+newBinary,2);
        System.out.println(newNumber);

    }
}
