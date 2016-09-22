import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.asList(scanner.nextLine().split("\\s+"));
        HashMap<String, HashMap<String, Predicate<String>>> filters = new HashMap<>();

        String line = scanner.nextLine();
        while (!"Print".equals(line)) {

            String[] data = line.split(";");
            String command = data[0];
            String modifier = data[1];
            String variable = data[2];

            Predicate<String> predicate = createPredicate(modifier, variable);

            if (command.equals("Add filter")) {
                if (!filters.containsKey(modifier)) {
                    filters.put(modifier, new HashMap<>());
                }
                filters.get(modifier).put(variable, predicate);
            } else if (command.equals("Remove filter")) {
                if (filters.containsKey(modifier)) {
                    if (filters.get(modifier).containsKey(variable)) {
                        filters.get(modifier).remove(variable);
                    }
                }
            }


            line = scanner.nextLine();
        }

        List<String> result = filter(input, filters);
        String out = result.stream().collect(Collectors.joining(" "));
        System.out.println(out);
    }

    private static List<String> filter(List<String> input, HashMap<String, HashMap<String, Predicate<String>>> filters) {

        List<String> result = new ArrayList<>();
        for (String currentString : input) {

            boolean filtered = false;
            for (Map.Entry<String, HashMap<String, Predicate<String>>> entry : filters.entrySet()) {
                for (Map.Entry<String, Predicate<String>> stringPredicateEntry : entry.getValue().entrySet()) {
                    Predicate<String> currentFilter = stringPredicateEntry.getValue();
                    if (currentFilter.test(currentString)) {
                        filtered = true;
                        break;
                    }

                }
            }
            if (!filtered){
                result.add(currentString);
            }

        }

        return result;
    }

    private static Predicate<String> createPredicate(String modifier, String variable) {

        switch (modifier) {
            case "Starts with":
                return x -> x.startsWith(variable);
            case "Ends with":
                return x -> x.endsWith(variable);
            case "Length":
                return x -> x.length() == Integer.valueOf(variable);
            case "Contains":
                return x -> x.contains(variable);
            default:
                return null;
        }
    }
}
