import java.util.ArrayList;
import java.util.Scanner;

public class FilterStudentsByEmailDomain {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            String email = data[2];
            Student student = new Student(firstName, lastName, email);
            students.add(student);

            line = scanner.nextLine();

        }

        students
                .stream()
                .filter(st -> st.email.endsWith("@gmail.com"))
                .forEach(a -> System.out.printf("%s %s%n", a.firstName, a.lastName));

    }

    public static class Student {

        private String firstName;
        private String lastName;
        private String email;

        public Student(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
    }
}
