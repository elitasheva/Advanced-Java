import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MagicExchangeableWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String firstString = input[0];
        String secondString = input[1];

        boolean hasExchangeability = areExchangeable(firstString,secondString);
        System.out.println(hasExchangeability);
    }

    private static boolean areExchangeable(String firstString, String secondString) {

        HashMap<Character,Character> symbols = new HashMap<>();
        if (firstString.length() != secondString.length()){

            long first = firstString.chars().distinct().count();
            long second = secondString.chars().distinct().count();
            if (first == second){
                return true;
            }
            return false;

        }else {

            for (int i = 0; i < firstString.length() ; i++) {

                if (symbols.containsKey(firstString.charAt(i))){

                    if (!symbols.get(firstString.charAt(i)).equals(secondString.charAt(i))){
                        return false;
                    }
                }else {

                    symbols.put(firstString.charAt(i),secondString.charAt(i));
                }

            }
            return true;
        }
    }
}
