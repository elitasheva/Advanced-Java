import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class QueryMess {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, List<String>> data = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            String newLine = line.replaceAll("%20", " ").replaceAll("\\+", " ");
            String newLine2 = newLine.replaceAll("\\s+", " ");
            String newLine3 = newLine2.replaceAll(".+?(?=\\?)(\\?)+", "");

            Pattern pattern = Pattern.compile("([^=&]+)=([^&]*)");
            Matcher matcher = pattern.matcher(newLine3);

            while (matcher.find()) {
                if (!data.containsKey(matcher.group(1).trim())) {
                    data.put(matcher.group(1).trim(), new LinkedList<>());
                }
                data.get(matcher.group(1).trim()).add(matcher.group(2).trim());
            }

            for (Map.Entry<String, List<String>> stringListEntry : data.entrySet()) {
                //String res = stringListEntry.getValue().stream().collect(Collectors.joining(", "));
                sb.append(String.format("%s=%s", stringListEntry.getKey(),stringListEntry.getValue()));
            }


            data.clear();
            sb.append("\n");
            line = scanner.nextLine();
        }

        System.out.println(sb.toString().trim());
    }
}
