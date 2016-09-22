import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class WordCount {

    public static void main(String[] args) {

        String firstInput = "resources/text_words.txt";
        String secondInput = "resources/text_initial.txt";
        LinkedHashMap<String, Integer> result = new LinkedHashMap();
        List<String> wordsForCheck = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(firstInput))) {

            String line;
            while ((line = reader.readLine()) != null) {
                wordsForCheck.addAll(Arrays.asList(line.split("\\s+")));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + "  " + firstInput);
        }

        for (int i = 0; i < wordsForCheck.size(); i++) {

            String currentWord = wordsForCheck.get(i);

            if (!result.containsKey(currentWord)) {
                result.put(currentWord, 0);
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(secondInput))) {

                String line;
                while ((line = reader.readLine()) != null) {

                    String[] currentLine = line.split("([,\\?:!\\-\\.\\s+])");
                    for (String s : currentLine) {

                        if (s.toLowerCase().equals(currentWord)) {
                            result.put(currentWord, result.get(currentWord) + 1);
                        }
                    }
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage() + "  " + secondInput);
            }

        }

       String output = "resources/result_WordCount.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))){

            result
                    .entrySet()
                    .stream()
                    .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> {
                        try {
                            writer.write(String.format("%s - %d%n", entry.getKey(), entry.getValue()));
                        } catch (IOException e) {
                            e.getMessage();
                        }
                    });

        }catch (IOException ex){
            System.out.println(ex.getMessage() + "  " + output);
        }


    }

}
