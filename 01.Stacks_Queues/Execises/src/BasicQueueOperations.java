import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BasicQueueOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        int countAdd = Integer.parseInt(data[0]);
        int countPoll = Integer.parseInt(data[1]);
        int searchedElement = Integer.parseInt(data[2]);

        String[] numbers = scanner.nextLine().split("\\s+");
        Queue<Integer> nums = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < countAdd; i++) {
            int current = Integer.parseInt(numbers[i]);
            nums.add(current);

        }
        for (int i = 0; i < countPoll; i++) {

            nums.poll();
        }

        if (nums.size() == 0){
            System.out.println(0);
            return;
        }

        int minVlaue = Integer.MAX_VALUE;
        for (Integer num : nums) {

            if (num == searchedElement){
                System.out.println("true");
                return;
            }
            if (num < minVlaue){
                minVlaue = num;
            }

        }
        System.out.println(minVlaue);

//        if (nums.contains(searchedElement)) {
//
//        } else {
//            if (nums.size() == 0) {
//                System.out.println(0);
//            } else {
//
//
//                for (int i = 0; i < nums.size(); i++) {
//
//                    int current = nums.poll();
//                    if (current < minVlaue) {
//                        minVlaue = current;
//                    }
//                }
//                System.out.println(minVlaue);
//            }
//        }

    }
}
