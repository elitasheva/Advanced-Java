import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        int lower = Integer.parseInt(data[0]);
        int upper = Integer.parseInt(data[1]);
        List<Integer> nums = new ArrayList<>();
        for (int i = lower; i <= upper; i++) {
            nums.add(i);
        }
        String state = scanner.nextLine();

        if ("odd".equals(state)) {
            filter(nums, a -> a % 2 != 0);

        } else {
            filter(nums, a -> a % 2 == 0);
        }

    }

    public static void filter(List<Integer> nums, Predicate<Integer> predicate) {

        for (Integer num : nums) {

            if (predicate.test(num)) {
                System.out.print(num + " ");
            }
        }

    }
}
