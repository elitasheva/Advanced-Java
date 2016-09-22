import java.util.*;
import java.util.function.Function;

public class CustomMinFunction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> nums = new ArrayList<>();
        for (String s : input) {

            if ("".equals(s)){
                continue;
            }
            nums.add(Integer.parseInt(s.trim()));
        }

        function(nums, findMin);
    }

    public static void function(List<Integer> nums, Function<List<Integer>, Integer> func){

        Integer result = func.apply(nums);
        if (result != null){

            System.out.println(func.apply(nums));
        }

    }

    private static Function<List<Integer>,Integer> findMin = new Function<List<Integer>, Integer>() {

        public Integer apply(List<Integer> integers) {
            if (integers.size() == 0){
                return null;
            }

            Integer min = Integer.MAX_VALUE;
            for (Integer i:integers) {
                if (i < min){
                    min = i;
                }

            }

            return min;
        }
    };

}
