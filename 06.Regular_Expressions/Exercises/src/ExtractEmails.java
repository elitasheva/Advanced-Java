import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) {

        //"(?:(?<=\\s)|^)([a-z1-9]+[\\-\\._]?[a-z1-9]+)@(?:[a-z]+[\\-]?[a-z]+)(:?\\.[a-z]+[\\-]?[a-z]+){1,}"

        //(?<=\s)([a-z1-9]+[\.\_\-]*[a-z1-9]+)@([a-z1-9]+[\-]*[a-z]+)(\.[a-z]+){1,}

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<=\\s)([a-z1-9]+[\\.\\_\\-]*[a-z1-9]+)@([a-z1-9]+[\\-]*[a-z]+)(\\.[a-z]+){1,}");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
