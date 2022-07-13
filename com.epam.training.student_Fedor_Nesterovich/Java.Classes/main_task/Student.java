import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private static int current_id = 1;
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private Calendar birthDate = Calendar.getInstance();
    private String address;
    private String phoneNumber;
    private String faculty;
    private int course;
    private String group;

    public Student() {
        id = current_id;
        current_id++;
    }

    public Student(String surname, String name, String patronymic, String birthDate, String address,
                   String phoneNumber, String faculty, int course, String group) {
        id = current_id;
        current_id++;
        this.setSurname(surname);
        this.setName(name);
        this.setPatronymic(patronymic);
        this.setBirthDate(birthDate);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
        this.setFaculty(faculty);
        this.setCourse(course);
        this.setGroup(group);
    }

    public Student(String surname, String name, String patronymic, String birthDate, String faculty, int course,
                   String group) {
        id = current_id;
        current_id++;
        this.setSurname(surname);
        this.setName(name);
        this.setPatronymic(patronymic);
        this.setBirthDate(birthDate);
        this.setFaculty(faculty);
        this.setCourse(course);
        this.setGroup(group);
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

    public void setSurname(String surname) throws IllegalArgumentException {
        Pattern p = Pattern.compile("[^a-zА-яЁё ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(surname);
        boolean b = m.find();
        if (!b) this.surname = surname;
        else throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        Pattern p = Pattern.compile("[^a-zА-яЁё]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(name);
        boolean b = m.find();
        if (!b) this.name = name;
        else throw new IllegalArgumentException();
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) throws IllegalArgumentException {
        Pattern p = Pattern.compile("[^a-zА-яЁё ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(patronymic);
        boolean b = m.find();
        if (!b) this.patronymic = patronymic;
        else throw new IllegalArgumentException();
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) throws IllegalArgumentException{
        String[] date;
        date = birthDate.split("-");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]) - 1;
        int day = Integer.parseInt(date[2]);
        Calendar c = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        c.set(year, month, day);
        if (c.after(today) || year < 1900) {
            throw new IllegalArgumentException();
        }
        else {
            this.birthDate = c;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) throws IllegalArgumentException {
        if (course < 1 || course > 7)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.course = course;
        }
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birth_date=" + birthDate.get(Calendar.YEAR) + '-' + birthDate.get(Calendar.MONTH)+ "-" + birthDate.get(Calendar.DATE) +
                ", address='" + address + '\'' +
                ", phone_number='" + phoneNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", group=" + group +
                '}';
    }
}
