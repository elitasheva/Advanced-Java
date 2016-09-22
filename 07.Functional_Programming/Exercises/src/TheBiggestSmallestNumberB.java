import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
interface TriFunction<T1, T2, T3, TR> {
//    /**
//     * Applies this function to the given arguments.
//     *
//     * @param T1 the first function argument
//     * @param T2 the second function argument
//     * @param T3 the third function argument
//     * @return the function result
//     */

    public TR apply(T1 first, T2 second, T3 third);
}

public class TheBiggestSmallestNumberB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            if (s.equals("")) {
                continue;
            }
            numbers.add(Integer.parseInt(s));
        }

        Function<List<Integer>, Integer> findMin = collection -> {
            int minElement = Integer.MAX_VALUE;

            for (int i = 0; i < collection.size(); i++) {

                if (collection.get(i) <= minElement) {
                    minElement = collection.get(i);
                }
            }
            return minElement;
        };

        Function<List<Integer>, Integer> findMax = collection -> {
            int maxElement = Integer.MIN_VALUE;

            for (int i = 0; i < collection.size(); i++) {

                if (collection.get(i) >= maxElement) {
                    maxElement = collection.get(i);
                }
            }
            return maxElement;
        };

        TriFunction<Function<List<Integer>, Integer>, List<Integer>, Predicate<Integer>, Integer> triFunction =
                (function, collection, predicate) -> {
                    List<Integer> buffer = new ArrayList<>();
                    for (Integer integer : collection) {
                        if (predicate.test(integer)) {
                            buffer.add(integer);
                        }
                    }
                    if (buffer.size() > 0) {
                        return function.apply(buffer);
                    }
                    return null;
                };


        Integer output = 0;
        String command = scanner.nextLine();
        switch (command) {
            case "minEven":
                output = triFunction.apply(findMin, numbers, x -> x % 2 == 0);
                break;
            case "maxEven":
                output = triFunction.apply(findMax, numbers, x -> x % 2 == 0);
                break;
            case "minOdd":
                output = triFunction.apply(findMin, numbers, x -> x % 2 != 0);
                break;
            case "maxOdd":
                output = triFunction.apply(findMax, numbers, x -> x % 2 != 0);
                break;
        }
        System.out.println(output == null ? "":String.valueOf(output));

    }

}
