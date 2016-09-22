import java.util.*;
import java.util.stream.Collectors;

public class GroupByGroup {

    public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            String[] data = line.split("\\s+");
            String name = data[0] + " " + data[1];
            Integer group = Integer.parseInt(data[2]);
            persons.add(new Person(name, group));

            line = scanner.nextLine();
        }

        Map<Integer, List<Person>> result = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getGroup));


        for (Map.Entry<Integer, List<Person>> integerListEntry : result.entrySet()) {
            System.out.printf("%d - ", integerListEntry.getKey());
            int count = integerListEntry.getValue().size();
            for (Person person : integerListEntry.getValue()) {

                if (count == 1) {
                    System.out.print(person.name);
                } else {
                    System.out.print(person.name + ", ");
                }
                count--;

            }
            System.out.println();

        }

    }

    public static class Person {
        private String name;
        private Integer group;

        public Person(String name, Integer group) {

            this.name = name;
            this.group = group;
        }

        public Integer getGroup() {
            return group;
        }
    }
}
