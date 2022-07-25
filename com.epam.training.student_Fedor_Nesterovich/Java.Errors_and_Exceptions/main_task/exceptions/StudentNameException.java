package exceptions;

public class StudentNameException extends RuntimeException {

    public StudentNameException() {
    }

    public StudentNameException(String message) {
        super(message);
    }
}
