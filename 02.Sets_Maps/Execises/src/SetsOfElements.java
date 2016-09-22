import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        String[] data = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);

        for (int i = 0; i < n; i++) {
            first.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < m; i++) {
            second.add(Integer.parseInt(scanner.nextLine()));

        }

        first.retainAll(second);

        for (Integer integer : first) {
            System.out.print(integer + " ");
        }

    }
}
