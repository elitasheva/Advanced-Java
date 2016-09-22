import java.util.Scanner;

public class StringLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        if (input.length() >= 20){
            result.append(input.substring(0,20));
        }else {

            result.append(input);
            int diff = 20-input.length();
            for (int i = 0; i < diff; i++) {
                result.append("*");
            }
        }

        System.out.println(result);
    }
}
