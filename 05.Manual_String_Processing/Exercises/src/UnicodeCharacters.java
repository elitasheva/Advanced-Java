import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UnicodeCharacters {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[] stringAsChars = scanner.nextLine().toCharArray();
        String[] result = new String[stringAsChars.length];
        for (int i = 0; i < result.length; i++) {

            result[i] = String.format("\\u%04x", (int) stringAsChars[i]);
        }

        String str = Arrays.asList(result).stream().collect(Collectors.joining(""));
        System.out.println(str);
    }
}
