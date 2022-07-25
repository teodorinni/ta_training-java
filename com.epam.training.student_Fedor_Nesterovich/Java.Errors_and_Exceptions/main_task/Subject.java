import exceptions.IncorrectGradeValueException;

import java.util.List;
import java.util.Objects;

public class Subject {

    private SubjectNames subjectName;
    private List<Integer> grades;

    public Subject(SubjectNames subjectName, List<Integer> grades) {
        setSubjectName(subjectName);
        setGrades(grades);
    }

    public SubjectNames getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(SubjectNames subjectName) {
        this.subjectName = subjectName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        for (int grade : grades ) {
            if (grade < 0 || grade > 10) {
                throw new IncorrectGradeValueException("Grade should be in 0 - 10 range");
            }
        }
        this.grades = grades;
    }

    public void addGrade(int grade) {
        if (grade < 0 || grade > 10) {
            throw new IncorrectGradeValueException("Grade should be in 0 - 10 range");
        } else {
            grades.add(grade);
        };
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName=" + subjectName +
                ", grades=" + grades +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectName == subject.subjectName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName);
    }
}
