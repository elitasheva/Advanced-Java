import java.util.ArrayList;
import java.util.Scanner;

public class StudentsByAge {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            int age =Integer.parseInt(data[2]);
            Student student = new Student(firstName, lastName, age);
            students.add(student);

            line = scanner.nextLine();

        }

        students
                .stream()
                .filter(st -> st.age >= 18 && st.age <= 24)
                .forEach(a -> System.out.printf("%s %s %d%n", a.firstName, a.lastName, a.age));

    }

    public static class Student {

        private String firstName;
        private String lastName;
        private int age;

        public Student(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
    }
}
