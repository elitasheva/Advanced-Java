import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(\\b[A-Z][a-z]+) (\\b[A-Z][a-z]+\\b)");
        while (!"end".equals(input)){

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){

                System.out.println(matcher.group());
            }

            input = scanner.nextLine();

        }
    }
}
