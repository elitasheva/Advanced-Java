import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {

    public static void main(String[] args) {

        LinkedHashMap<String, Set<String>> cards = new LinkedHashMap<>();
        //LinkedHashMap<String, Integer> values = new LinkedHashMap<>();

        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))){

            String input = scanner.readLine();
            while (!"JOKER".equals(input)) {

                String[] data = input.split(":");
                String name = data[0];
                List<String> hand = Arrays.asList(data[1].trim().split(",\\s+")).stream().distinct().collect(Collectors.toList());

                if (!cards.containsKey(name)) {

                    cards.put(name, new HashSet<>());
                }
                cards.get(name).addAll(hand);

                input = scanner.readLine();

            }

            for (Map.Entry<String, Set<String>> stringSetEntry : cards.entrySet()) {

                List<String> c = stringSetEntry.getValue().stream().collect(Collectors.toList());
                int value = getValues(c);
                System.out.printf("%s: %d%n",stringSetEntry.getKey(),value);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static int getValues(List<String> hand) {

        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {

            String face = hand.get(i).substring(0, hand.get(i).length() - 1);
            int a = getFaceValue(face);
            char suit = hand.get(i).charAt(hand.get(i).length() - 1);
            int b = getSuitValue(suit);
            sum += a * b;


        }

        return sum;
    }

    private static int getSuitValue(char suit) {

        int a = 0;
        switch (suit) {
            case 'S':
                a = 4;
                break;
            case 'H':
                a = 3;
                break;
            case 'D':
                a = 2;
                break;
            case 'C':
                a = 1;
                break;
        }

        return a;
    }

    private static int getFaceValue(String face) {

        int a = 0;
        switch (face) {
            case "2":
                a = 2;
                break;
            case "3":
                a = 3;
                break;
            case "4":
                a = 4;
                break;
            case "5":
                a = 5;
                break;
            case "6":
                a = 6;
                break;
            case "7":
                a = 7;
                break;
            case "8":
                a = 8;
                break;
            case "9":
                a = 9;
                break;
            case "10":
                a = 10;
                break;
            case "J":
                a = 11;
                break;
            case "Q":
                a = 12;
                break;
            case "K":
                a = 13;
                break;
            case "A":
                a = 14;
                break;

        }

        return a;
    }
}
