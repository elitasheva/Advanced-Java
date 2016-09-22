import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SUnleashed {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, BigInteger>> data = new LinkedHashMap<>();

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("^([A-Za-z\\s*]+)\\s@([A-Za-z\\s*]+)\\s(\\d{1,3})\\s(\\d{1,6})$");
        while (!"End".equals(input)){

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){

                String singer = matcher.group(1);
                String venue = matcher.group(2);
                String ticketsPrice = matcher.group(3);
                BigInteger ticketsCount = new BigInteger(matcher.group(4));
                BigInteger total = ticketsCount.multiply(new BigInteger(ticketsPrice));

                if (!data.containsKey(venue)){
                    data.put(venue,new LinkedHashMap<>());
                }
                if (!data.get(venue).containsKey(singer)){
                    data.get(venue).put(singer, new BigInteger("0"));
                }
                data.get(venue).put(singer, data.get(venue).get(singer).add(total));
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, BigInteger>> stringLinkedHashMapEntry : data.entrySet()) {

            System.out.println(stringLinkedHashMapEntry.getKey());
            stringLinkedHashMapEntry
                    .getValue()
                    .entrySet()
                    .stream()
                    .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(),e.getValue()));

        }

    }

}
