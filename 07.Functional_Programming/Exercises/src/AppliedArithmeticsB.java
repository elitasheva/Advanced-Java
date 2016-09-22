
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmeticsB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        Integer[] nums = new Integer[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("")) {
                continue;
            }
            nums[i] = Integer.parseInt(data[i]);
        }

        String input = scanner.nextLine();
        while (!"end".equals(input)) {

            switch (input) {
                case "add":
                    applyFunc(nums, x -> x + 1);
                    break;
                case "multiply":
                    applyFunc(nums, x -> x * 2);
                    break;
                case "subtract":
                    applyFunc(nums, x -> x - 1);
                    break;
                case "print":
                    applyConsumer(nums, x -> System.out.printf("%s ", x));
                    break;
                default:
                    break;
            }

            input = scanner.nextLine();

        }
    }

    private static void applyFunc(Integer[] nums, Function<Integer, Integer> func) {
        for (int i = 0; i < nums.length; i++) {

            nums[i] = func.apply(nums[i]);
        }
    }

    private static void applyConsumer(Integer[] nums, Consumer<Integer> consumer) {
        for (Integer num : nums) {
            consumer.accept(num);
        }
        System.out.println();
    }
}
