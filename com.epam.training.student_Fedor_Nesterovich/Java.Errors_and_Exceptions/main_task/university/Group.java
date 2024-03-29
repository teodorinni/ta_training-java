package university;

import exceptions.NoStudentsInGroupException;

import java.util.Objects;
import java.util.Set;

public class Group {

    private static int counter = 1;
    private final int id;
    private Set<Student> students;

    public Group() {
        this.id = counter;
        counter++;
    }

    public Group(Set<Student> students) {
        this.id = counter;
        counter++;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public Set<Student> getStudents() {
        if (this.students == null || this.students.isEmpty()) {
            throw new NoStudentsInGroupException();
        } else {
            return students;
        }
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public boolean addStudent(Student student) {
        return this.students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, students);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", students=" + students +
                '}';
    }
}
