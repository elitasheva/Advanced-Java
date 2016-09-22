
import java.util.Scanner;

public class RecursiveFibonacci {

    private static long[] numbers;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        numbers = new long[n+2];
        numbers[1] = 1;
        numbers[2] = 1;
        long number = GetFibonacci(n + 1);
        System.out.println(number);
    }

    private static long GetFibonacci(int n) {

        if (numbers[n] != 0) {

            return numbers[n];
        }
        if (n <= 2) {
            return 1;
        }
        numbers[n] = GetFibonacci(n - 1) + (GetFibonacci(n - 2));

        return numbers[n];
    }
}
