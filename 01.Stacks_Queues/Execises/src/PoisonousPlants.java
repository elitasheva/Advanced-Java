
import java.util.*;


public class PoisonousPlants {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] plants = new int[n];
        for (int i = 0; i < plants.length; i++) {
            plants[i] = scanner.nextInt();
        }
        Stack<Integer> proximityStack = new Stack<>();
        int[] days = new int[plants.length];
        proximityStack.push(0);
        for (int x = 1; x < plants.length; x++) {
            int maxDays = 0;
            while (proximityStack.size() > 0 && plants[proximityStack.peek()] >= plants[x]) {

                maxDays = Integer.max(days[proximityStack.pop()], maxDays);
            }
            if (proximityStack.size() > 0) {
                days[x] = maxDays + 1;
            }
            proximityStack.push(x);
        }
        System.out.printf("%d%n", Arrays.stream(days).max().getAsInt());
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        String[] input = scanner.nextLine().split("\\s+");
//        List<Integer> plants = new LinkedList<>();
//
//        for (int i = 0; i < input.length; i++) {
//            plants.add(Integer.parseInt(input[i]));
//        }
//
//        int days = 0;
//
//        while (true){
//            boolean hasToBreak = true;
//            for (int i = plants.size()-1; i > 0 ; i--) {
//
//                if (plants.get(i-1) < plants.get(i)){
//                    plants.remove(i);
//                    hasToBreak=false;
//                }
//            }
//
//            if (hasToBreak){
//                break;
//            }
//            days++;
//        }
//
//        System.out.println(days);
//    }



}
