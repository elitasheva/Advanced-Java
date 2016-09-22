import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentsByGroup {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"END".equals(line)){

            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            int group = Integer.parseInt(data[2]);
            Student student = new Student(firstName,lastName,group);
            students.add(student);

            line = scanner.nextLine();
        }

        List<Student> selected = students.stream().filter(st -> st.group == 2).collect(Collectors.toList());
        selected
                .stream()
                .sorted((a,b) -> a.firstName.compareTo(b.firstName))
                .forEach(a -> System.out.printf("%s %s%n", a.firstName, a.lastName));



    }

   public static class Student{

        private String firstName;
        private String lastName;
        private int group;

        public Student(String firstName, String lastName, int group){
            this.firstName=firstName;
            this.lastName=lastName;
            this.group=group;
        }
    }
}
