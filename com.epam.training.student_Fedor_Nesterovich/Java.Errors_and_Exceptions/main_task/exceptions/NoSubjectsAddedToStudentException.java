package exceptions;

public class NoSubjectsAddedToStudentException extends RuntimeException {

    public NoSubjectsAddedToStudentException() {
    }

    public NoSubjectsAddedToStudentException(String message) {
        super(message);
    }
}
