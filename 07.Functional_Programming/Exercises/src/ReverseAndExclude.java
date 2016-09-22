import java.util.*;
import java.util.function.Predicate;

public class ReverseAndExclude {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.asList(scanner.nextLine().split("\\s+")).stream().mapToInt(Integer::parseInt).toArray();
        int number = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> predicate = x -> x % number != 0;
        int[] result = filter(array, predicate);
        for (int num : result) {
            System.out.print(num + " ");
        }


    }

    private static int[] filter(int[] array, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (int num : array) {

            if (predicate.test(num)) {
                result.add(num);
            }

        }
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
