import java.io.*;

public class LineNumbers {

    public static void main(String[] args) {

        String inputFile = "resources/text.txt";
        String outputFile = "resources/result_LineNumbers.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {

                count++;
                writer.write(count + ". " + line + "\n");
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
