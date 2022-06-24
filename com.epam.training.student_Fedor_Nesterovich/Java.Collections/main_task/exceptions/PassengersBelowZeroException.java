package exceptions;

public class PassengersBelowZeroException extends RuntimeException {
    public PassengersBelowZeroException() {
        super("The passenger capacity can't be less than zero.");
    }
}