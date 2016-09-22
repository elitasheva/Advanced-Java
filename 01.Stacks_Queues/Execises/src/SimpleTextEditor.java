import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Stack<String> stack = new Stack<>();
        stack.push("");
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");

            String command = input[0];

            switch (command) {

                case "1":
                    text.append(input[1]);
                    stack.push(text.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(input[1]);
                    text.delete(text.length() - count, text.length());
                    stack.push(text.toString());
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(input[1]) - 1));
                    break;
                case "4":
                    stack.pop();
                    if (stack.size() > 0) {
                        text = new StringBuilder(stack.peek());
                    }else {
                        text = new StringBuilder();
                    }
                    break;
            }
        }
    }
}
