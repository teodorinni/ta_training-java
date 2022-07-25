import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static double calculateAverageGradeByStudent(Student student) {
        List<Integer> selectedGrades = new ArrayList<>();
        for (Subject subject : student.getSubjects()) {
            selectedGrades.addAll(subject.getGrades());
        }
        double averageGrade = selectedGrades.stream().mapToDouble(a -> a).average().orElse(0.0);
        System.out.println("Average grade of student " + student.getName() + " " + student.getSurname() + " is: " + String.format("%.2f", averageGrade));
        return averageGrade;
    }

    public static double calculateAverageGradeByFacultyGroupSubject(Faculty faculty, int groupId, SubjectNames subjectName) {
        List<Integer> selectedGrades = new ArrayList<>();
        for (Group group : faculty.getGroups()) {
            if (group.getId() == groupId) {
                for (Student student : group.getStudents()) {
                    for (Subject subject : student.getSubjects()) {
                        if (subject.getSubjectName() == subjectName) {
                            selectedGrades.addAll(subject.getGrades());
                        }
                    }
                }
            }
        }
        double averageGrade = selectedGrades.stream().mapToDouble(a -> a).average().orElse(0.0);
        System.out.println("Average grade in " + faculty.getName() + " faculty, " + groupId + " group and " + subjectName.name() + " subject is: " + String.format("%.2f", averageGrade));
        return averageGrade;
    }

    public static double calculateAverageGradeBySubject(University university, SubjectNames subjectName) {
        List<Integer> selectedGrades = new ArrayList<>();
        for (Faculty faculty : university.getFaculties()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    for (Subject subject : student.getSubjects()) {
                        if (subject.getSubjectName() == subjectName) {
                            selectedGrades.addAll(subject.getGrades());
                        }
                    }
                }
            }
        }
        double averageGrade = selectedGrades.stream().mapToDouble(a -> a).average().orElse(0.0);
        System.out.println("The university average grade by " + subjectName.name() + " is: " + String.format("%.2f", averageGrade));
        return averageGrade;
    }

    public static void main(String[] args) {
        //  Create students
        List<List<Integer>> gradesList = new ArrayList<>();
        for (int n = 0; n < 54; n++) {
            List<Integer> gradesSubList = new ArrayList<>();
            for (int k = 0; k < 3; k++) {
                gradesSubList.add(ThreadLocalRandom.current().nextInt(0, 11));
            }
            gradesList.add(gradesSubList);
        }
        Student studentComputerScience1 = new Student("Doe", "John", "2000-01-20",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(0)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(1)),
                        new Subject(SubjectNames.COMPUTER_SCIENCE, gradesList.get(2))));
        Student studentComputerScience2 = new Student("Hughes", "Jack", "2001-03-15",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(3)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(4)),
                        new Subject(SubjectNames.COMPUTER_SCIENCE, gradesList.get(5))));
        Student studentComputerScience3 = new Student("Gray", "Mary", "2002-03-07",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(6)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(7)),
                        new Subject(SubjectNames.COMPUTER_SCIENCE, gradesList.get(8))));
        Student studentComputerScience4 = new Student("Brown", "Chris", "2000-10-11",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(9)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(10)),
                        new Subject(SubjectNames.COMPUTER_SCIENCE, gradesList.get(11))));
        Student studentComputerScience5 = new Student("Black", "Bob", "2001-03-15",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(12)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(13)),
                        new Subject(SubjectNames.COMPUTER_SCIENCE, gradesList.get(14))));
        Student studentComputerScience6 = new Student("White", "Ann", "2002-06-08",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(15)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(16)),
                        new Subject(SubjectNames.COMPUTER_SCIENCE, gradesList.get(17))));
        Student studentMaths1 = new Student("Green", "Kate", "2001-05-25",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(18)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(19)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(20))));
        Student studentMaths2 = new Student("Lawson", "Susan", "2002-09-13",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(21)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(22)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(23))));
        Student studentMaths3 = new Student("Jordan", "Michael", "2000-12-24",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(24)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(25)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(26))));
        Student studentMaths4 = new Student("Hamilton", "Lewis", "2000-03-19",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(27)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(28)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(29))));
        Student studentMaths5 = new Student("Lopez", "Jennifer", "2001-03-03",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(30)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(31)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(32))));
        Student studentMaths6 = new Student("Nance", "Larry", "2002-08-08",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(33)),
                        new Subject(SubjectNames.PHYSICS, gradesList.get(34)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(35))));
        Student studentEconomics1 = new Student("Donovan", "Casper", "2000-10-20",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(36)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(37)),
                        new Subject(SubjectNames.SOCIOLOGY, gradesList.get(38))));
        Student studentEconomics2 = new Student("Cobaine", "Kurt", "2001-02-17",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(39)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(40)),
                        new Subject(SubjectNames.SOCIOLOGY, gradesList.get(41))));
        Student studentEconomics3 = new Student("Jennings", "Tracey", "2002-01-07",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(42)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(43)),
                        new Subject(SubjectNames.SOCIOLOGY, gradesList.get(44))));
        Student studentEconomics4 = new Student("Reygan", "Ronald", "2000-01-13",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(45)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(46)),
                        new Subject(SubjectNames.SOCIOLOGY, gradesList.get(47))));
        Student studentEconomics5 = new Student("Shakespeare", "William", "2001-03-01",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(48)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(49)),
                        new Subject(SubjectNames.SOCIOLOGY, gradesList.get(50))));
        Student studentEconomics6 = new Student("Houston", "Aby", "2002-11-14",
                Set.of(new Subject(SubjectNames.MATHEMATICS, gradesList.get(51)),
                        new Subject(SubjectNames.ECONOMICS, gradesList.get(52)),
                        new Subject(SubjectNames.SOCIOLOGY, gradesList.get(53))));

        //  Create groups
        Group groupComputerScience1 = new Group(Set.of(studentComputerScience1, studentComputerScience2, studentComputerScience3));
        Group groupComputerScience2 = new Group(Set.of(studentComputerScience4, studentComputerScience5, studentComputerScience6));
        Group groupMaths1 = new Group(Set.of(studentMaths1, studentMaths2, studentMaths3));
        Group groupMaths2 = new Group(Set.of(studentMaths4, studentMaths5, studentMaths6));
        Group groupEconomics1 = new Group(Set.of(studentEconomics1, studentEconomics2, studentEconomics3));
        Group groupEconomics2 = new Group(Set.of(studentEconomics4, studentEconomics5, studentEconomics6));

        //  Create faculty
        Faculty facultyComputerScience = new Faculty(FacultyNames.COMPUTER_SCIENCE, Set.of(groupComputerScience1, groupComputerScience2));
        Faculty facultyMaths = new Faculty(FacultyNames.MATHEMATICS, Set.of(groupMaths1, groupMaths2));
        Faculty facultyEconomics = new Faculty(FacultyNames.ECONOMICS, Set.of(groupEconomics1, groupEconomics2));

        // Create university
        University university = new University("University", Set.of(facultyComputerScience, facultyMaths, facultyEconomics));

        // Run methods
        calculateAverageGradeByStudent(studentComputerScience3);
        calculateAverageGradeByFacultyGroupSubject(facultyEconomics, 5, SubjectNames.MATHEMATICS);
        calculateAverageGradeBySubject(university, SubjectNames.PHYSICS);
    }
}
