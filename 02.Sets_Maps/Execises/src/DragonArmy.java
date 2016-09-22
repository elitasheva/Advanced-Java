import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {

    private static final int DEFAULT_HEALTH = 250;
    private static final int DEFAULT_DAMAGE = 45;
    private static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, Dragon>> data = new LinkedHashMap<>();
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {

            String[] params = scanner.nextLine().split("\\s+");
            String type = params[0];
            String name = params[1];

            int damage = 0;
            if ("null".equals(params[2])) {
                damage = DEFAULT_DAMAGE;
            } else {
                damage = Integer.parseInt(params[2]);
            }

            int health = 0;
            if ("null".equals(params[3])) {
                health = DEFAULT_HEALTH;
            } else {
                health = Integer.parseInt(params[3]);
            }

            int armor = 0;
            if ("null".equals(params[4])) {
                armor = DEFAULT_ARMOR;
            } else {
                armor = Integer.parseInt(params[4]);
            }

            Dragon currentDragon = new Dragon(name, health, damage, armor);
            if (!data.containsKey(type)) {
                data.put(type, new TreeMap<>());
            }

            data.get(type).put(name, currentDragon);

        }

        for (Map.Entry<String, TreeMap<String, Dragon>> dataEntry : data.entrySet()) {

            double averageDamage = 0.0;
            double averageHealth = 0.0;
            double averageArmor = 0.0;
            StringBuilder dragons = new StringBuilder();
            int countCurrentType = dataEntry.getValue().size();

            for (Map.Entry<String, Dragon> current : dataEntry.getValue().entrySet()) {
                Dragon dragon = current.getValue();
                averageDamage += dragon.getDamage();
                averageHealth += dragon.getHealth();
                averageArmor += dragon.getArmor();
                dragons.append(String.format("-%s -> damage: %d, health: %d, armor: %d%n",
                        dragon.getName(), dragon.getDamage(), dragon.getHealth(), dragon.getArmor()));
            }

            averageDamage /= countCurrentType;
            averageHealth /= countCurrentType;
            averageArmor /= countCurrentType;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", dataEntry.getKey(), averageDamage, averageHealth, averageArmor);
            System.out.println(dragons.toString().trim());
        }


    }

}

class Dragon {

    private String name;
    private int health;
    private int damage;
    private int armor;

    public Dragon(String name, int health, int damage, int armor) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }


    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }

    public String getName() {
        return name;
    }
}
