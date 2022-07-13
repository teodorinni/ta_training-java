package exceptions;

public class PriceBelowZeroException extends RuntimeException {
    public PriceBelowZeroException() {
        super("The price can't be less than zero.");
    }
}
