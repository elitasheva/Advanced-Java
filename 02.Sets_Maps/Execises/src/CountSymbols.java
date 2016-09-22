import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        TreeMap<Character, Integer> chars = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {

            if (!chars.containsKey(input.charAt(i))){
                chars.put(input.charAt(i),0);
            }
            chars.put(input.charAt(i),chars.get(input.charAt(i))+1);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : chars.entrySet()) {

            System.out.printf("%c: %d time/s \n", characterIntegerEntry.getKey(), characterIntegerEntry.getValue());

        }
    }
}
