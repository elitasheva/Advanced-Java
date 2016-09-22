import java.util.*;

public class CustomComparator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s+");
        List<Integer> nums = new ArrayList<>();
        for (String s : input) {
            if (s.equals("")){
                continue;
            }
            nums.add(Integer.parseInt(s));
        }
        Integer[] numbers = nums.stream().mapToInt(i -> i).boxed().toArray(Integer[]::new);

        Arrays.sort(numbers,customComparator);
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }

    private static Comparator<Integer> customComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer num1, Integer num2) {
            if (num1 % 2 == 0 && num2 % 2 != 0){
                return -1;
            }else if (num1 % 2 != 0 && num2 % 2 == 0){
                return 1;
            }else {
                if (num1 < num2){
                    return -1;
                }else if (num1 > num2){
                    return 1;
                }else {
                    return 0;
                }
            }
        }
    };
}
