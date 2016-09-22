import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

    public static void main(String[] args) {

        //Scanner scanner = new Scanner(System.in);
        try(BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(scanner.readLine());
            Stack<Integer> nums = new Stack<>();
            Stack<Integer> maxNumbers = new Stack<>();
            int maxElement = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {

//            String[] data = scanner.nextLine().split("\\s+");
//            int query = Integer.parseInt(data[0]);
                int[] data = Arrays.asList(scanner.readLine().split("\\s+")).stream().mapToInt(Integer::parseInt).toArray();
                int query = data[0];

                if (query == 1) {

                    //int numberToPush = Integer.parseInt(data[1]);
                    int numberToPush = data[1];
                    nums.push(numberToPush);
                    if (numberToPush >= maxElement) {
                        maxElement = numberToPush;
                        maxNumbers.push(maxElement);
                    }
                } else if (query == 2) {
                    int currentMaxNumber = maxNumbers.peek();
                    int itemAtTop = nums.pop();

                    if (currentMaxNumber == itemAtTop) {
                        maxNumbers.pop();

                        if (maxNumbers.size() > 0) {
                            maxElement = maxNumbers.peek();
                        } else {
                            maxElement = Integer.MIN_VALUE;
                        }
                    }
                } else {

                    System.out.println(maxNumbers.peek());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
