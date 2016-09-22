import java.io.*;

public class OddLines {

    public static void main(String[] args) {

        String inputFile = "resources/text.txt";
        String outputFile = "resources/result_OddLines.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {

                if (count % 2 != 0){
                    writer.write(line);
                    writer.newLine();
                }

                count++;
            }

        } catch (FileNotFoundException ex) {

            System.out.println(ex.getMessage());
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
