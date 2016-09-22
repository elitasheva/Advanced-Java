import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {

    //<a\s*(.*?)href\s*=\s*(["|']*)([^"'>\s]+)\2(.*?)>

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        String line = scanner.nextLine();
        while (!"END".equals(line)){

            input.append(line);
            line = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile("<a\\s+([^>]+\\s+)?href\\s*=\\s*('([^']*)'|\"([^\"\"]*)\"|([^\\s>]+))[^>]*>");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){

            String currentMatch = matcher.group(3);
            if (currentMatch == null)
            {
                currentMatch = matcher.group(4);
                if (currentMatch == null)
                {
                    currentMatch = matcher.group(5);
                }
            }

            System.out.println(currentMatch);

        }
    }

}
