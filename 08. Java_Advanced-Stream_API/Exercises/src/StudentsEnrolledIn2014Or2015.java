import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentsEnrolledIn2014Or2015 {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            String[] data = line.split("\\s+");
            String facNumber = data[0];
            List<Integer> marks = new ArrayList<>();
            for (int i = 1; i < data.length; i++) {
                marks.add(Integer.parseInt(data[i]));
            }
            Student student = new Student(facNumber, marks);
            students.add(student);

            line = scanner.nextLine();

        }

        students.stream().filter(st -> st.facNumber.endsWith("14") || st.facNumber.endsWith("15")).forEach(a -> {
            for (Integer mark : a.marks) {
                System.out.print(mark + " ");
            }
            System.out.println();
        });
    }

    public static class Student {

        private String facNumber;
        private List<Integer> marks;

        public Student(String facNumber, List<Integer> marks) {
            this.facNumber = facNumber;
            this.marks = marks;
        }


    }
}
