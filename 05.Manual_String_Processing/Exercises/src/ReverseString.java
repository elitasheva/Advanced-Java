import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

    public static void main(String[] args) {

        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {

            String input = scanner.readLine();

            StringBuilder sb = new StringBuilder(input);

            System.out.println(sb.reverse());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
