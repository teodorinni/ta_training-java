import exceptions.NoFacultiesInUniversityException;

import java.util.Objects;
import java.util.Set;

public class University {

    private String name;
    private Set<Faculty> faculties;

    public University(String name) {
        this.name = name;
    }

    public University(String name, Set<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Faculty> getFaculties() {
        if (this.faculties == null || this.faculties.isEmpty()) {
            throw new NoFacultiesInUniversityException();
        } else {
            return faculties;
        }
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public boolean addFaculty(Faculty faculty) {
        return this.faculties.add(faculty);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}
