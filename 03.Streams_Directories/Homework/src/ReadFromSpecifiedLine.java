import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFromSpecifiedLine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfStartLine = Integer.parseInt(scanner.nextLine());
        String file1 = "resources/text.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(new File(file1)))) {

            String line = "";
            while ((line = br.readLine()) != null) {
                if (numberOfStartLine > 0){
                    numberOfStartLine--;
                    continue;
                }else {
                    System.out.println(line);
                }

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
