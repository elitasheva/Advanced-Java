import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {

    public static void main(String[] args) {

        //\b([A-Z](.+?)\s)?(is|Is)\s([^\.!\?]+)[\.!\?]
        //(\b([A-Z](.+?)\s)?(is|Is)\s(.+?)[\.!\?])
        //[^\.\?!]*(?<=[\.\?\s!])is(?=[\s\.\?!])[^\.\?!]*[\.\?!]

        Scanner scanner = new Scanner(System.in);
        String keyWord = scanner.nextLine();
        String text = scanner.nextLine();
        String patternString = String.format("[^\\.\\?!]*(?<=[\\.\\?\\s!])%s(?=[\\s\\.\\?!])[^\\.\\?!]*[\\.\\?!]", keyWord);
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
