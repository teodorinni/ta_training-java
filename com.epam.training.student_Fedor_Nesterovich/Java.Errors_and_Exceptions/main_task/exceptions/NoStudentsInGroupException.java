package exceptions;

public class NoStudentsInGroupException extends RuntimeException {

    public NoStudentsInGroupException() {
    }

    public NoStudentsInGroupException(String message) {
        super(message);
    }
}
