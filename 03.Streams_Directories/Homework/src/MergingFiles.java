import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MergingFiles {

    public static void main(String[] args) {

        String[] files = {"resources/first.txt", "resources/second.txt"};
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {

            try (BufferedReader reader = new BufferedReader(new FileReader(files[i]))) {

                String line;
                while ((line = reader.readLine()) != null) {

                    numbers.add(Integer.parseInt(line));
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        String output = "resources/result_MergingFiles.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))){

            numbers.stream().sorted((a,b) -> a.compareTo(b)).forEach(a -> {
                try {
                    writer.write(a.toString()+"\n");
                } catch (IOException e) {
                    e.getMessage();
                }
            });

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
