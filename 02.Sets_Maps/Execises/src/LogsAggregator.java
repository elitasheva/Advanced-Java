import java.util.*;

public class LogsAggregator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Integer> nameAndDuration = new TreeMap<>();
        HashMap<String, TreeSet<String>> nameAndIp = new HashMap<>();
        for (int i = 0; i < count; i++) {

            String[] input = scanner.nextLine().split(" ");
            String ip = input[0];
            String name = input[1];
            int duration = Integer.parseInt(input[2]);

            if (!nameAndDuration.containsKey(name)) {
                nameAndDuration.put(name, 0);
            }
            nameAndDuration.put(name, nameAndDuration.get(name) + duration);

            if (!nameAndIp.containsKey(name)) {
                nameAndIp.put(name, new TreeSet<String>());
            }
            nameAndIp.get(name).add(ip);

        }

        for (Map.Entry<String,Integer> pair : nameAndDuration.entrySet()) {

            System.out.printf("%s: %d %s",pair.getKey(),pair.getValue(),nameAndIp.get(pair.getKey()));
            System.out.println();

        }
    }
}
