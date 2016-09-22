import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTag {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        while (!"end".equals(input)){

            result.append(input);

            input = scanner.nextLine();
        }

//        Pattern pattern = Pattern.compile("(<a\\s*href\\s*=\")([^>]+)(\">)(.+)?(<\\/a>)");
//        Matcher matcher = pattern.matcher(result);
//        String newString = "";
//        while (matcher.find()){
//
//            newString = result.toString().replaceAll(matcher.group(1),"[URL href=");
//            newString = newString.toString().replaceAll(matcher.group(3),"]");
//            newString = newString.toString().replaceAll(matcher.group(5),"[/URL]");
//
//        }

        String newString = result.toString().replaceAll("</a>","[/URL]");
        newString = newString.replaceAll("<a\\s", "[URL ");

        System.out.println(newString);
    }
}
