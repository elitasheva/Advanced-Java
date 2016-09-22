import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHTML {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            lines.add(line);
            line = scanner.nextLine();
        }

        Pattern openingPattern = Pattern.compile("(<div)(.*?)(\\s+?(id|class)(\\s+)?=(\\s+)?\"(.*?)\"\\s*)(\\s.*?)?>");

        for (int i = 0; i < lines.size(); i++) {

            Matcher matcher = openingPattern.matcher(lines.get(i));
            if (matcher.find()) {
                String oldValue = matcher.group(1);
                String newValue = "<" + matcher.group(7);
                lines.set(i, lines.get(i).replaceAll(oldValue, newValue));
                lines.set(i, lines.get(i).replaceAll(matcher.group(3), ""));
                lines.set(i, lines.get(i).replaceAll("\\s+>", ">"));
                lines.set(i, lines.get(i).replaceAll("\\s+=\\s+"," = "));

            }
        }

        Pattern closingPattern = Pattern.compile("<\\/div>\\s*<!--\\s*(.*?)-->");

        for (int i = 0; i < lines.size(); i++) {

            Matcher matcher = closingPattern.matcher(lines.get(i));
            if (matcher.find()) {

                String oldValue = matcher.group();
                String newValue = "</" + matcher.group(1).trim() + ">";
                lines.set(i, lines.get(i).replaceAll(oldValue, newValue));
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }

    }
}
