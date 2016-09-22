import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseYourChainsBuddy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("<p>(.+?[\\n]*)<\\/p>");
        Matcher matcher = pattern.matcher(text);
        StringBuilder decryptedText = new StringBuilder();

        while (matcher.find()) {

            String message1 = matcher.group(1).replaceAll("[^a-z0-9]", " ");
            String message = message1.replaceAll("[\\s]+", " ");
            for (int i = 0; i < message.length(); i++) {
                char letter = message.charAt(i);
                if (letter >= 97 && letter <= 109) {
                    letter = (char) ((int) letter + 13);
                    decryptedText.append(letter);
                } else if (letter >= 110 && letter <= 122) {
                    letter = (char) ((int) letter - 13);
                    decryptedText.append(letter);
                } else {
                    decryptedText.append(letter);
                }
            }
        }

        System.out.println(decryptedText.toString());
    }
}


