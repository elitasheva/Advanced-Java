import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {

    public static void main(String[] args) {

        TreeMap<String, Integer> keyMaterial = new TreeMap<String, Integer>();
        keyMaterial.put("shards", 0);
        keyMaterial.put("fragments", 0);
        keyMaterial.put("motes", 0);

        HashMap<String, String> materialNeededForItem = new HashMap<>();
        materialNeededForItem.put("shards", "Shadowmourne");
        materialNeededForItem.put("fragments", "Valanyr");
        materialNeededForItem.put("motes", "Dragonwrath");

        final int neededQuantity = 250;
        String item = "";
        boolean getItem = false;

        TreeMap<String, Integer> junk = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (input != null && input.trim().length()!= 0){

            String[] data = input.split("\\s+");

            for (int i = 0; i < data.length ; i+=2) {

                int quantity = Integer.parseInt(data[i]);
                String material = data[i+1].toLowerCase();

                if (keyMaterial.containsKey(material)){

                    keyMaterial.put(material,keyMaterial.get(material)+quantity);
                    if (keyMaterial.get(material) >= neededQuantity){

                        keyMaterial.put(material,keyMaterial.get(material)-250);
                        item = materialNeededForItem.get(material);
                        getItem = true;
                        break;
                    }
                }else {

                    if (!junk.containsKey(material)){
                        junk.put(material,0);
                    }
                    junk.put(material,junk.get(material)+ quantity);
                }

            }

            if (getItem){
                break;
            }

            input=scanner.nextLine();
        }
        System.out.println(item + " obtained!");
        keyMaterial.entrySet().stream()
                .sorted((a1,a2) -> a2.getValue().compareTo(a1.getValue()))
                .forEach(a -> System.out.printf("%s: %d\n",a.getKey(),a.getValue()));
        junk.entrySet().stream()
                .forEach(a -> System.out.printf("%s: %d\n",a.getKey(),a.getValue()));

    }
}
