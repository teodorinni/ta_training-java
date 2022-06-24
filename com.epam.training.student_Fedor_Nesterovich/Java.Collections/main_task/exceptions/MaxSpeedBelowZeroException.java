package exceptions;

public class MaxSpeedBelowZeroException extends RuntimeException {
    public MaxSpeedBelowZeroException() {
        super("The maximum speed can't be less than zero.");
    }
}