import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        while (!"END".equals(line)) {
            sb.append(line);
            line = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile("<a\\s+([^>]+\\s+)?href\\s*=\\s*('([^']*)'|\"([^\"]*)\"|([^\\s>]+))[^>]*>");
        Matcher matcher = pattern.matcher(sb);

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
