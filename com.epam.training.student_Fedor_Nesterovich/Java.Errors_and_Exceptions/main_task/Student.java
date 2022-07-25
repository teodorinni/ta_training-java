import exceptions.NoSubjectsAddedToStudentException;
import exceptions.StudentBirthDateException;
import exceptions.StudentNameException;
import exceptions.StudentSurnameException;

import java.util.Calendar;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    private static int current_id = 1;
    private int id;
    private String surname;
    private String name;
    private Calendar birthDate = Calendar.getInstance();
    private Set<Subject> subjects;

    public Student() {
        id = current_id;
        current_id++;
    }

    public Student(String surname, String name, String birthDate) {
        id = current_id;
        current_id++;
        this.setSurname(surname);
        this.setName(name);
        this.setBirthDate(birthDate);
    }

    public Student(String surname, String name, String birthDate, Set<Subject> subjects) {
        id = current_id;
        current_id++;
        this.setSurname(surname);
        this.setName(name);
        this.setBirthDate(birthDate);
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        Pattern p = Pattern.compile("[^a-zА-яЁё ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(surname);
        boolean b = m.find();
        if (!b) this.surname = surname;
        else throw new StudentSurnameException("The student's surname contains not allowed symbols.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws StudentNameException {
        Pattern p = Pattern.compile("[^a-zА-яЁё]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(name);
        boolean b = m.find();
        if (!b) this.name = name;
        else throw new StudentNameException("The student's name contains not allowed symbols.");
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        String[] date;
        date = birthDate.split("-");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]) - 1;
        int day = Integer.parseInt(date[2]);
        Calendar c = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        c.set(year, month, day);
        if (c.after(today) || year < 1900) {
            throw new StudentBirthDateException("The student's birth date is incorrect or is entered using incorrect format.");
        }
        else {
            this.birthDate = c;
        }
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
    }

    public Set<Subject> getSubjects() {
        if (this.subjects == null || this.subjects.isEmpty()) {
            throw new NoSubjectsAddedToStudentException();
        } else {
            return this.subjects;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate.get(Calendar.YEAR) + '-' + birthDate.get(Calendar.MONTH)+ "-" + birthDate.get(Calendar.DATE) + '\'' +
                ", grades=" + subjects +
                '}';
    }
}
