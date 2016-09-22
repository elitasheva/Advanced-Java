import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Palindromes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] words = input.split("([,\\?!\\.:\\s*])");

        Set<String> output = new HashSet<>();
        for (String word : words) {

            if (word.equals("")){
                continue;
            }
            String reversed = getReversed(word);
            if (word.equals(reversed)) {
                output.add(word);
            }

        }

        Collator collator = Collator.getInstance();
        List<String> sorted = output.stream().sorted((a, b) -> collator.compare(a, b)).collect(Collectors.toList());
        System.out.println(sorted);
        //output.stream().sorted((a, b) -> collator.compare(a, b)).forEach(a -> System.out.print(a +" "));
    }

    private static String getReversed(String word) {

        StringBuilder result = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            result.append(word.charAt(i));
        }

        return result.toString();
    }
}
