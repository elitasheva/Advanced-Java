import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class PopulationCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String,BigInteger>> data = new LinkedHashMap<>();
        LinkedHashMap<String,BigInteger> data1 = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"report".equals(input)){

            String[] params = input.split("\\|");
            String city = params[0];
            String country = params[1];
            BigInteger population = new BigInteger(params[2]);

            if (!data.containsKey(country)){
                data.put(country,new LinkedHashMap<>());
            }
            if (!data.get(country).containsKey(city)){
                data.get(country).put(city, new BigInteger("0"));
            }
            data.get(country).put(city, data.get(country).get(city).add(population));

            if (!data1.containsKey(country)){
                data1.put(country, new BigInteger("0"));
            }
            data1.put(country, data1.get(country).add(population));

            input = scanner.nextLine();
        }

        data1.entrySet()
                .stream()
                .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)%n", e.getKey(),e.getValue());
                    data.get(e.getKey())
                            .entrySet()
                            .stream()
                            .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(a -> {
                                System.out.printf("=>%s: %d%n", a.getKey(),a.getValue());
                            });
                });
    }
}
