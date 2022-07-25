import exceptions.NoGroupsInFacultyException;

import java.util.Objects;
import java.util.Set;

public class Faculty {

    private FacultyNames name;
    private Set<Group> groups;

    public Faculty(FacultyNames name) {
        this.name = name;
    }

    public Faculty(FacultyNames name, Set<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public FacultyNames getName() {
        return name;
    }

    public void setName(FacultyNames name) {
        this.name = name;
    }

    public Set<Group> getGroups() {
        if (this.groups == null || this.groups.isEmpty()) {
            throw new NoGroupsInFacultyException();
        } else {
            return groups;
        }
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public boolean addGroup(Group group) {
        return this.groups.add(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return name.equals(faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}
