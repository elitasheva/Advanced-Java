import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();
        Pattern pattern = Pattern.compile("IP\\s*=(.+?) message=\\s*'(.*?)' user=(.+)");

        while (!input.equals("end")) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {

                String ip = matcher.group(1).trim();
                String username = matcher.group(3).trim();

                if (!data.containsKey(username)) {
                    data.put(username, new LinkedHashMap<>());
                }
                if (!data.get(username).containsKey(ip)) {
                    data.get(username).put(ip, 0);
                }
                data.get(username).put(ip, data.get(username).get(ip) + 1);
            }

            input = scanner.nextLine();
        }

        int count = 0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> stringLinkedHashMapEntry : data.entrySet()) {

            System.out.println(stringLinkedHashMapEntry.getKey() + ":");
            count = stringLinkedHashMapEntry.getValue().size();
            for (Map.Entry<String, Integer> s : stringLinkedHashMapEntry.getValue().entrySet()) {

                count--;
                if (count > 0) {
                    System.out.printf("%s => %d, ", s.getKey(), s.getValue());
                } else {
                    System.out.printf("%s => %d.", s.getKey(), s.getValue());
                }
            }
            System.out.println();
        }
    }
}
