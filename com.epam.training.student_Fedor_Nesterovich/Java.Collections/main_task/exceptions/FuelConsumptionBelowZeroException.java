package exceptions;

public class FuelConsumptionBelowZeroException extends RuntimeException {
    public FuelConsumptionBelowZeroException() {
        super("The fuel consumption can't be less than zero.");
    }
}
