import java.util.Scanner;

public class MelrahShake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String pattern = scanner.nextLine();
        StringBuilder result = new StringBuilder(text);

        while (true) {

            int first = result.indexOf(pattern);
            int last = result.lastIndexOf(pattern);

            if (first > -1 && last > -1 && pattern.length() != 0) {

                if (last+pattern.length() >= result.length()){
                    result.delete(last,result.length());
                }else {
                    result.delete(last, last + pattern.length());
                }

                result.delete(first, first + pattern.length());
                int indexToRemove = pattern.length() / 2;
                pattern = pattern.substring(0, indexToRemove) + pattern.substring(indexToRemove + 1, pattern.length());
                System.out.println("Shaked it.");

            } else {
                System.out.println("No shake.");
                System.out.println(result);
                break;
            }

        }

    }

}
