import java.util.*;
import java.util.stream.Collectors;

public class CalculateSequenceWithQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = Long.parseLong(scanner.nextLine());
        Queue<Long> queue = new ArrayDeque<>();
        queue.add(n);
        List<Long> result = new ArrayList<>();

        while (result.size() < 50) {

            long current = queue.poll();
            result.add(current);
            long first = current + 1;
            queue.add(first);
            long second = 2 * current + 1;
            queue.add(second);
            long third = current + 2;
            queue.add(third);

        }

        String str = result.stream().map(Object::toString).collect(Collectors.joining(" "));
        System.out.println(str);
    }
}
