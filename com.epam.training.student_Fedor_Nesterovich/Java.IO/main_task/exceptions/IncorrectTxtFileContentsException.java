package exceptions;

public class IncorrectTxtFileContentsException extends RuntimeException {

    public IncorrectTxtFileContentsException() {
    }

    public IncorrectTxtFileContentsException(String message) {
        super(message);
    }
}
