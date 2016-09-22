import java.util.Scanner;
import java.util.Stack;

public class BasicStackOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        int countPush = Integer.parseInt(data[0]);
        int countPop = Integer.parseInt(data[1]);
        int searchedElement = Integer.parseInt(data[2]);

        String[] numbers = scanner.nextLine().split("\\s+");
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < countPush; i++) {
            int current = Integer.parseInt(numbers[i]);
            nums.push(current);

        }
        for (int i = 0; i < countPop; i++) {

            nums.pop();
        }

        if (nums.contains(searchedElement)) {
            System.out.println("true");
        } else {
            if (nums.size() == 0) {
                System.out.println(0);
            } else {

                int minVlaue = Integer.MAX_VALUE;
                for (int i = 0; i < nums.size(); i++) {

                    int current = nums.pop();
                    if (current < minVlaue) {
                        minVlaue = current;
                    }
                }
                System.out.println(minVlaue);
            }
        }

    }
}
