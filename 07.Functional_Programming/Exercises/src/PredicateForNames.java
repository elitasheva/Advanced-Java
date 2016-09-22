import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> predicate = x -> x.length() <= number;

        for (String name : names) {

            if (predicate.test(name)){
                System.out.println(name);
            }
        }
    }
}
