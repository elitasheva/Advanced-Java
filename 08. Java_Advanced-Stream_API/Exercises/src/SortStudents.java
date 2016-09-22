import java.util.ArrayList;
import java.util.Scanner;

public class SortStudents {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            Student student = new Student(firstName, lastName);
            students.add(student);

            line = scanner.nextLine();

        }

        students.stream().sorted((a,b) -> {
            int compare = a.lastName.compareTo(b.lastName);
            if (compare == 0){
                compare = b.firstName.compareTo(a.firstName);
            }
            return compare;
        }).forEach(a -> System.out.printf("%s %s%n", a.firstName, a.lastName));

    }
    public static class Student {

        private String firstName;
        private String lastName;

        public Student(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;

        }
    }
}
