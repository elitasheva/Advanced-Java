import java.util.*;
import java.util.stream.Collectors;

public class StudentsJoinedToSpecialties {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        List<StudentSpecialty> specialties = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"Students:".equals(line)) {

            String[] params1 = line.split("\\s+");
            String speciality1 = params1[0];
            String speciality2 = params1[1];
            String facNumber = params1[2];
            specialties.add(new StudentSpecialty(speciality1 + " " + speciality2, facNumber));
            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!"END".equals(line)) {
            String[] params2 = line.split("\\s+");
            String facNumber = params2[0];
            String firstName = params2[1];
            String secondName = params2[2];
            students.add(new Student(firstName + " " + secondName, facNumber));
            line = scanner.nextLine();
        }


        List<Tripple> result = students
                .stream()
                .flatMap(v1 -> specialties.stream()
                        .filter(v2 -> v1.facultyNumber.equals(v2.facultyNumber))
                        .map(v2 -> new Tripple(v1.name, v1.facultyNumber, v2.specialtyName)))
                .sorted((a, b) -> a.v1.compareTo(b.v1))
                .collect(Collectors.toList());


        for (Tripple tripple : result) {
            System.out.printf("%s %s %s%n", tripple.v1, tripple.v2, tripple.v3);
        }

    }

    public static class StudentSpecialty {
        private String specialtyName;
        private String facultyNumber;

        public StudentSpecialty(String specialtyName, String facultyNumber) {
            this.specialtyName = specialtyName;
            this.facultyNumber = facultyNumber;

        }
    }

    public static class Student {
        private String name;
        private String facultyNumber;

        public Student(String name, String facultyNumber) {
            this.name = name;
            this.facultyNumber = facultyNumber;

        }
    }

    public static class Tripple {
        private final String v1;
        private final String v2;
        private final String v3;

        public Tripple(String v1, String v2, String v3) {
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3;
        }
    }

}



