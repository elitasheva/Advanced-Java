import java.util.Scanner;
import java.util.Stack;

public class StackFibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Stack<Long> numbers = new Stack<>();
        numbers.push(0l);
        numbers.push(1l);
        while (n > 0){

            long a = numbers.pop();
            long b = numbers.pop();

            long sum = a+b;
            numbers.push(a);
            numbers.push(sum);
            n--;
        }

        System.out.println(numbers.peek());
    }
}
