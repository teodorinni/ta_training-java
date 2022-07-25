package exceptions;

public class NoGroupsInFacultyException extends RuntimeException {

    public NoGroupsInFacultyException() {
    }

    public NoGroupsInFacultyException(String message) {
        super(message);
    }
}
