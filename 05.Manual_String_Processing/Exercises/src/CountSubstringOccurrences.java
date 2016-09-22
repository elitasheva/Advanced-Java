import java.util.Scanner;

public class CountSubstringOccurrences {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String pattern = scanner.nextLine();

        int count = 0;
        for (int i = 0; i <= text.length() - pattern.length(); i++) {

            String current = text.substring(i,i+pattern.length());
            if (current.toLowerCase().equals(pattern.toLowerCase())){
                count++;
            }
        }

        System.out.println(count);
    }
}
