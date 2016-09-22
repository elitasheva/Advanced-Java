import java.util.*;
import java.util.stream.Collectors;

public class FixEmails {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> data = new LinkedHashMap<>();

        while (true) {

            String name = scanner.nextLine();
            if ("stop".equals(name)) {
                break;
            }
            String email = scanner.nextLine();

            if (!email.toLowerCase().endsWith("us") && !email.toLowerCase().endsWith("uk")) {

                data.put(name, email);

            }

        }

        for (Map.Entry<String, String> stringStringEntry : data.entrySet()) {

            System.out.printf("%s -> %s%n", stringStringEntry.getKey(), stringStringEntry.getValue());
        }
    }
}
