
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {

    public static void main(String[] args) {

        Set<String> names = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            names.add(input);

        }

        StringBuilder result = new StringBuilder();
        for (String name : names) {
            result.append(name+"\n");
            //System.out.println(name);

        }

        System.out.println(result.toString());

    }
}
