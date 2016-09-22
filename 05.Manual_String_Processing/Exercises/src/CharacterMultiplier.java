import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");

        String firstString = strings[0];
        String secondString = strings[1];

        if (firstString.length() < secondString.length()){
            String temp = firstString;
            firstString = secondString;
            secondString = temp;
        }

        long product = getProduct(firstString, secondString);
        System.out.println(product);
    }

    private static long getProduct(String firstString, String secondString) {
        long product = 0;
        for (int i = 0; i < firstString.length() ; i++) {
            if (i < secondString.length()){
                product += firstString.charAt(i)*secondString.charAt(i);
            }else {
                product+=firstString.charAt(i);
            }

        }
        return product;
    }
}
