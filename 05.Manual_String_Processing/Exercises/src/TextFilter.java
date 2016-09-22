import java.util.Scanner;

public class TextFilter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(",\\s+");
        String text = scanner.nextLine();

        StringBuilder result = new StringBuilder(text);

        for (int i = 0; i < words.length; i++) {

            String currentWord = words[i];

           while (true){
               int index = result.indexOf(currentWord);
               if (index == -1){
                   break;
               }
               String newStr = new String(new char[currentWord.length()]).replace('\0','*');
               result.delete(index,index+currentWord.length());
               result.insert(index,newStr);
           }

        }

        System.out.println(result);
    }
}
