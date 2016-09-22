import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WeakStudents {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            List<Integer> marks = new ArrayList<>();
            for (int i = 2; i < data.length; i++) {
                marks.add(Integer.parseInt(data[i]));
            }
            Student student = new Student(firstName, lastName, marks);
            students.add(student);

            line = scanner.nextLine();

        }

        students
                .stream()
                .filter(st -> st.getWeekMarks().size() >= 2)
                .forEach(a -> System.out.printf("%s %s%n", a.firstName, a.lastName));

    }

    public static class Student {

        private String firstName;
        private String lastName;
        private List<Integer> marks;

        public Student(String firstName, String lastName, List<Integer> marks) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.marks = marks;
        }

        public List<Integer> getWeekMarks() {
            return marks.stream().filter(m -> m <= 3).collect(Collectors.toList());
        }
    }
}
