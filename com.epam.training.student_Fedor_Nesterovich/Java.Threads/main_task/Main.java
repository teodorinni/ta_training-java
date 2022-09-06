import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        System.out.print("Input how many cars to park: ");
        int carsAmount = new Scanner(System.in).nextInt();
        for (int i = 0; i < carsAmount; i++) {
            Car car = new Car(parking);
            car.start();
        }
    }
}
