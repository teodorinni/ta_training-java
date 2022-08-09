package exceptions;

public class FileExtensionException extends RuntimeException {

    public FileExtensionException() {
    }

    public FileExtensionException(String message) {
        super(message);
    }
}
