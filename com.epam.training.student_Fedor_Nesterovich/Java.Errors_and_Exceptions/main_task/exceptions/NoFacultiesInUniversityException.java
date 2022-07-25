package exceptions;

public class NoFacultiesInUniversityException extends RuntimeException {

    public NoFacultiesInUniversityException() {
    }

    public NoFacultiesInUniversityException(String message) {
        super(message);
    }
}
