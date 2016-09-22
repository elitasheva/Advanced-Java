import java.util.Scanner;

public class MultiplyBigNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstNumber = scanner.nextLine();
        Integer secondNumber = Integer.parseInt(scanner.nextLine());

        if (secondNumber == 0){
            System.out.println(0);
            return;
        }

        StringBuilder result = findProduct(firstNumber, secondNumber);
        int i = 0;
        while (result.charAt(i) == '0'){
            result.deleteCharAt(i);

        }
        System.out.println(result);

    }

    private static StringBuilder findProduct(String first, Integer second) {

        StringBuilder result = new StringBuilder();
        int reminder = 0;
        for (int i = first.length() - 1; i >= 0; i--) {

            int currentSum = (Integer.parseInt(String.format("%c", first.charAt(i))) *
                    second) + reminder;
            result.append(currentSum % 10);
            reminder = currentSum /10;

        }

        if (reminder != 0){
            result.append(reminder);
        }

        return result.reverse();
    }
}
