import airport.Airport;
import airport.Plane;

public class Main {

    private static final int PLANES_COUNT = 10;

    public static void main(String[] args) {
        Airport airport = new Airport();
        for (int i = 0; i < PLANES_COUNT; i++) {
            Plane plane = new Plane(airport);
            plane.start();
        }
    }
}
