import java.util.Scanner;

public class FormattingNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberA = scanner.nextInt();
        double numberB = scanner.nextDouble();
        double numberC = scanner.nextDouble();

        String numberAToHex = Integer.toHexString(numberA);
        String numberAToBinary = String.format("%10s",Integer.toBinaryString(numberA)).replace(' ','0');

        if (numberAToBinary.length() > 10){
            numberAToBinary = numberAToBinary.substring(0,10);
        }

        System.out.format("|%-10S|%10s|%10.2f|%-10.3f|",numberAToHex,numberAToBinary,numberB,numberC);
    }
}
