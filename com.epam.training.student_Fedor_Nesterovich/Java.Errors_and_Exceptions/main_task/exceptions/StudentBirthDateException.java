package exceptions;

public class StudentBirthDateException extends RuntimeException {

    public StudentBirthDateException() {
    }

    public StudentBirthDateException(String message) {
        super(message);
    }
}
