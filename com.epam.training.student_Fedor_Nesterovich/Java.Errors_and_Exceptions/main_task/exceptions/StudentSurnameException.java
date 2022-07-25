package exceptions;

public class StudentSurnameException extends RuntimeException {

    public StudentSurnameException() {
    }

    public StudentSurnameException(String message) {
        super(message);
    }
}
