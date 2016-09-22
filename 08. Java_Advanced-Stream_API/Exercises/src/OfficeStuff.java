import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class OfficeStuff {

    public static void main(String[] args) {

        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {

            String[] input = scanner.nextLine().replaceAll("\\|","").split("-");
            String company = input[0].trim();
            Integer amount = Integer.parseInt(input[1].trim());
            String product = input[2].trim();
            
            if (!data.containsKey(company)){
                data.put(company, new LinkedHashMap<>());
            }
            
            if (!data.get(company).containsKey(product)){
                data.get(company).put(product,0);
            }

            data.get(company).put(product,data.get(company).get(product)+amount);
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> firstEntry : data.entrySet()) {
            System.out.printf("%s: ", firstEntry.getKey());
            int count = firstEntry.getValue().size();
            for (Map.Entry<String,Integer> secondEntry : firstEntry.getValue().entrySet()) {

                if (count > 1){
                    System.out.printf("%s-%d, ",secondEntry.getKey(), secondEntry.getValue());
                }else {
                    System.out.printf("%s-%d",secondEntry.getKey(), secondEntry.getValue());
                }
                count--;

            }
            System.out.println();
        }
    }
}
