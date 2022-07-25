package exceptions;

public class IncorrectGradeValueException extends RuntimeException {

    public IncorrectGradeValueException() {
    }

    public IncorrectGradeValueException(String message) {
        super(message);
    }
}
