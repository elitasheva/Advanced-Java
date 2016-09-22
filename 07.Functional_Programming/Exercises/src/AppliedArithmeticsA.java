import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class AppliedArithmeticsA {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("")){
                continue;
            }
            nums.add(Integer.parseInt(data[i]));
        }

        String input = scanner.nextLine();
        while (!"end".equals(input)){

            switch (input){
                case "add":
                    nums = applayFunc(nums,add);
                    break;
                case "multiply":
                    nums = applayFunc(nums, multiply);
                    break;
                case "subtract":
                    nums = applayFunc(nums, subtract);
                    break;
                case "print":
                    for (Integer num : nums) {
                        System.out.print(num + " ");
                    }
                    break;
            }

            input = scanner.nextLine();

        }
    }

    private static List<Integer> applayFunc(List<Integer> nums, Function<List<Integer>,List<Integer>> func){
       return func.apply(nums);
    }

    private static Function<List<Integer>, List<Integer>> add = new Function<List<Integer>, List<Integer>>() {
        @Override
        public List<Integer> apply(List<Integer> integers) {
            List<Integer> result = new ArrayList<>();
            if (integers.size() == 0){
                return null;
            }
            for (Integer integer : integers) {
                result.add(integer+1);
            }
            return result;
        }
    };

    private static Function<List<Integer>, List<Integer>> multiply = new Function<List<Integer>, List<Integer>>() {
        @Override
        public List<Integer> apply(List<Integer> integers) {
            List<Integer> result = new ArrayList<>();
            if (integers.size() == 0){
                return null;
            }
            for (Integer integer : integers) {
                result.add(integer*2);
            }
            return result;
        }
    };

    private static Function<List<Integer>, List<Integer>> subtract = new Function<List<Integer>, List<Integer>>() {
        @Override
        public List<Integer> apply(List<Integer> integers) {
            List<Integer> result = new ArrayList<>();
            if (integers.size() == 0){
                return null;
            }
            for (Integer integer : integers) {
                result.add(integer-1);
            }
            return result;
        }
    };

}
