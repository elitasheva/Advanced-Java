import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Integer[] numbers = IntStream.rangeClosed(1, number).boxed().toArray(Integer[]::new);

        Integer[] deviders = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        List<Integer> result = new ArrayList<>();

        for (Integer integer : numbers) {

            boolean isDivideble = true;
            for (Integer devider : deviders) {
                Predicate<Integer> predicate = x -> x % devider == 0;
                if (!predicate.test(integer)) {
                    isDivideble = false;
                    break;
                }
            }
            if (isDivideble) {
                result.add(integer);
            }
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

}

