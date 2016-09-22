import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

@FunctionalInterface
interface TriFunctionA<T1, T2, T3, TR> {

    TR apply(T1 first, T2 second, T3 third);
}

public class TriFunctionTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer number = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.asList(scanner.nextLine().split("\\s+"));

        BiFunction<String, Integer, Boolean> biFunc = (name, targetSum) -> {

            int sum = 0;
            for (int i = 0; i < name.length(); i++) {
                sum += name.charAt(i);
            }
            if (sum >= targetSum) {
                return true;
            }
            return false;
        };

        TriFunctionA<Integer, BiFunction<String, Integer, Boolean>, List<String>, String> triFunc =
                (targetSum, func, collection) -> {
                    for (String name : collection) {

                        if (func.apply(name, targetSum)) {
                            return name;
                        }
                    }
                    return "";
                };

        String result = triFunc.apply(number,biFunc,names);
        System.out.println(result);
    }
}
