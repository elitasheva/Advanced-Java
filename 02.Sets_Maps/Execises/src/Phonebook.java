import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Phonebook {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phones = new LinkedHashMap<>();

        String input = scanner.nextLine();

        if ("stop".equals(input.toLowerCase())){
            return;
        }
        while (!"search".equals(input.toLowerCase())) {

            String[] data = input.split("-");

            phones.put(data[0], data[1]);

            input = scanner.nextLine();

        }

        while (true) {

            String out = scanner.nextLine();
            if (out.equals("stop")) {
                break;
            }

            if (phones.containsKey(out)) {

                String a = phones.get(out);
                System.out.printf("%s -> %s%n", out, a);

            } else {
                System.out.printf("Contact %s does not exist.%n", out);
            }
        }

    }
}
