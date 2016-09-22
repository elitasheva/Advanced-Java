import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<Character, Character> parentheses = new LinkedHashMap<>();
        parentheses.put('(', ')');
        parentheses.put('{', '}');
        parentheses.put('[', ']');


        boolean areBalanced = true;

        if (input.length() == 0) {
            areBalanced = false;
        } else if ((input.length() % 2) != 0) {
            areBalanced = false;
        } else {

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {

                if (parentheses.containsKey(input.charAt(i))){
                    stack.push(input.charAt(i));
                }else if (stack.empty() || input.charAt(i) != parentheses.get(stack.pop())){
                    areBalanced = false;
                }

            }

        }

        if (areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }

}
