import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InfernoIII {

    public static void main(String[] args) {

        HashMap<String, List<Integer>> data = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> gems = new ArrayList<>();
        for (String s : input) {
            if (s.equals("")) {
                continue;
            }
            gems.add(Integer.parseInt(s));
        }

        String line = scanner.nextLine();
        while (!"Forge".equals(line)) {

            String[] tokens = line.split(";");
            String command = tokens[0];
            String filterType = tokens[1];
            Integer parameter = Integer.parseInt(tokens[2]);

            if ("Exclude".equals(command)) {
                if (!data.containsKey(filterType)) {
                    data.put(filterType, new ArrayList<>());
                }
                data.get(filterType).add(parameter);

            } else if ("Reverse".equals(command)) {

                if (data.containsKey(filterType)) {
                    data.get(filterType).remove(parameter);
                }
            }

            line = scanner.nextLine();
        }


        List<Integer> indices = applayCommands(gems, data);
        for (Integer index : indices) {
            gems.remove(index);
        }
        String str = gems.stream().map(Object::toString).collect(Collectors.joining(" "));
        System.out.println(str);

    }

    private static List<Integer> applayCommands(List<Integer> gems, HashMap<String, List<Integer>> data) {

        List<Integer> indices = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> stringListEntry : data.entrySet()) {
            for (Integer integer : stringListEntry.getValue()) {

                for (int i = 0; i < gems.size(); i++) {
                    int currentGem = gems.get(i);
                    Predicate<Integer> predicate = getCurrentPredicate(stringListEntry.getKey(), integer, gems, i);
                    if (predicate.test(currentGem)) {
                        indices.add(gems.get(i));
                    }
                }
            }

        }

        return indices;
    }

    private static Predicate<Integer> getCurrentPredicate(String filterType, Integer parameter, List<Integer> gems, int index) {

        switch (filterType) {
            case "Sum Left":
                int leftNeighbor = index > 0 ? gems.get(index - 1) : 0;
                return x -> x + leftNeighbor == parameter;

            case "Sum Right":
                int rightNeighbor = index < gems.size() - 1 ? gems.get(index + 1) : 0;
                return x -> x + rightNeighbor == parameter;

            case "Sum Left Right":
                int leftNeighbor1 = index > 0 ? gems.get(index - 1) : 0;
                int rightNeighbor1 = index < gems.size() - 1 ? gems.get(index + 1) : 0;
                return x -> leftNeighbor1 + x + rightNeighbor1 == parameter;

            default:
                return null;
        }
    }
}
