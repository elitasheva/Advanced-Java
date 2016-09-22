import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\b([a-zA-Z]\\w{2,24})\\b");
        Matcher matcher = pattern.matcher(text);

        List<String> matches = new ArrayList<>();
        while (matcher.find()) {
            matches.add(matcher.group(1));
        }

        if (matches.size() == 0) {
            System.out.println("No matches.");
        } else {

            int biggestSum = 0;
            String firstUsername = "";
            String secondUsername = "";
            for (int i = 0; i < matches.size() - 1; i++) {

                int currentSum = matches.get(i).length() + matches.get(i + 1).length();
                if (currentSum > biggestSum) {
                    biggestSum = currentSum;
                    firstUsername = matches.get(i);
                    secondUsername = matches.get(i + 1);
                }
            }

            System.out.println(firstUsername);
            System.out.println(secondUsername);
        }

    }
}
