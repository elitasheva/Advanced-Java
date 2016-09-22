import java.util.Scanner;

public class SumBigNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();

        int diff = 0;
        String repeated = "";
        if (firstNumber.length() > secondNumber.length()) {
            diff = firstNumber.length() - secondNumber.length();
            repeated = new String(new char[diff]).replace("\0", "0");
            secondNumber = repeated + secondNumber;
        }

        if (secondNumber.length() > firstNumber.length()) {
            diff = secondNumber.length() - firstNumber.length();
            repeated = new String(new char[diff]).replace("\0", "0");
            firstNumber = repeated + firstNumber;
        }

        StringBuilder first = new StringBuilder(firstNumber);
        StringBuilder second = new StringBuilder(secondNumber);

        StringBuilder result = findSum(first, second);
        int i = 0;
        while (result.charAt(i) == '0'){
            result.deleteCharAt(i);

        }
        System.out.println(result);

    }

    private static StringBuilder findSum(StringBuilder first, StringBuilder second) {

        StringBuilder result = new StringBuilder();
        int reminder = 0;
        for (int i = first.length() - 1; i >= 0; i--) {

            int currentSum = Integer.parseInt(String.format("%c", first.charAt(i))) +
                    Integer.parseInt(String.format("%c", second.charAt(i))) + reminder;
            result.append(currentSum % 10);
            reminder = currentSum /10;

        }

        if (reminder != 0){
            result.append(reminder);
        }

        return result.reverse();
    }
}
