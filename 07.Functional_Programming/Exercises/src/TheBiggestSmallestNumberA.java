import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class TheBiggestSmallestNumberA {

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

        List<Integer> evenCollection = new ArrayList<>();
        List<Integer> oddCollection = new ArrayList<>();
        Integer output = 0;
        String command = scanner.nextLine();
        switch (command) {
            case "minEven":
                evenCollection = getEvenCollection(numbers);
                output = findMin.apply(evenCollection);
                break;
            case "maxEven":
                evenCollection = getEvenCollection(numbers);
                output = findMax.apply(evenCollection);
                break;
            case "minOdd":
                oddCollection = getOddCollection(numbers);
                output = findMin.apply(oddCollection);
                break;
            case "maxOdd":
                output = findMax.apply(oddCollection);
                break;
        }

        String result = "";
        if (output != Integer.MAX_VALUE && output != Integer.MIN_VALUE){
            System.out.println(output);
        }else {
            System.out.println(result);
        }

    }

    private static List<Integer> getOddCollection(List<Integer> numbers){
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (!isEven().test(number)){
                result.add(number);
            }
        }
        return result;
    }

    private static List<Integer> getEvenCollection(List<Integer> numbers){
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (isEven().test(number)){
                result.add(number);
            }
        }
        return result;
    }

    private static Predicate<Integer> isEven() {
        return x -> x % 2 == 0;
    }


}
