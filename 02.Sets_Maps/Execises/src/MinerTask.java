
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, BigInteger> data = new LinkedHashMap<>();
       try {
           while (true){

               String resource = scanner.nextLine();
               if (resource.equals("stop")){
                   break;
               }
               BigInteger quantity = new BigInteger(scanner.nextLine());
               if (!data.containsKey(resource)){
                   data.put(resource,BigInteger.ZERO);
               }
               data.put(resource, data.get(resource).add(quantity));
           }

           for (Map.Entry<String, BigInteger> stringBigIntegerEntry : data.entrySet()) {
               System.out.printf("%s -> %d%n", stringBigIntegerEntry.getKey(), stringBigIntegerEntry.getValue());
           }
       }catch (Exception ex){
           System.out.println(ex.getMessage());
       }
    }
}
