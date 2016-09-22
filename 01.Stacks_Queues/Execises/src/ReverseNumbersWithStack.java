import java.util.Scanner;
import java.util.Stack;

public class ReverseNumbersWithStack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        if (input.length() == 0) {
            System.out.println("empty");
        } else {
            String[] numbers = input.split("\\s+");
            Stack<Integer> nums = new Stack<>();
            for (int i = 0; i < numbers.length; i++) {

                nums.push(Integer.parseInt(numbers[i]));
            }

            int count = nums.size();

//            for (int i = 0; i < count; i++) {
//                System.out.print(nums.pop() + " ");
//            }

            nums.stream().forEach(a -> System.out.println(a));
        }


    }
}
