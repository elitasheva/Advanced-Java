import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] initialNames = scanner.nextLine().split("\\s+");

        ArrayList<String> names = new ArrayList<String>(Arrays.asList(initialNames));
        String line = scanner.nextLine();
        while (!"Party!".equals(line)) {

            String[] data = line.split("\\s+");
            String command = data[1];
            switch (command) {
                case "StartsWith":
                    names = applayPredicate(names, data[0], x -> x.startsWith(data[2]));
                    break;
                case "EndsWith":
                    names = applayPredicate(names, data[0], x -> x.endsWith(data[2]));
                    break;
                case "Length":
                    names = applayPredicate(names, data[0], x -> x.length() == Integer.parseInt(data[2]));
                    break;
            }


            line = scanner.nextLine();
        }

        if (names.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {

            String out = names.stream().collect(Collectors.joining(", "));
            System.out.printf("%s are going to the party!",out);

        }

    }

    private static ArrayList<String> applayPredicate(ArrayList<String> names, String state, Predicate<String> predicate) {

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {

            if (predicate.test(names.get(i))) {
                if (state.equals("Double")) {
                    result.add(names.get(i));
                    result.add(names.get(i));
                }
                if (state.equals("Remove")) {
                    continue;
                }

            } else {
                result.add(names.get(i));
            }
        }

        return result;
    }
}
