import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Function<Integer[],Integer> findMin = collection -> {
            int minElement = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < collection.length; i++) {

                if (collection[i] <= minElement){
                    minElement = collection[i];
                    index = i;
                }
            }
            return index;
        };

        int min = findMin.apply(numbers);
        System.out.println(min);


    }
}
