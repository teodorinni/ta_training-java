import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Car extends Thread {

    private static int carCounter = 1;
    private static final int PARKING_TIME_FROM = 5;
    private static final int PARKING_TIME_TO = 10;
    private static final int MAX_WAITING_TIME = 7;
    private int carId;
    private CarState carState;
    private Parking parking;
    private static ReentrantLock lock = new ReentrantLock(true);
    private static Condition condition = lock.newCondition();

    public Car(Parking parking) {
        this.carId = carCounter;
        this.parking = parking;
        carCounter++;
        carState = CarState.WAITING;
        System.out.println("Car № " + carId +": " + carState);
    }

    @Override
    public void run() {
        park(this.parking);
        leave(this.parking);
    }

    synchronized void park(Parking parking) {
        lock.lock();
        for (int i = 0; i < parking.parkingPlaces.length; i++) {
            if (parking.parkingPlaces[i] == null) {
                parking.parkingPlaces[i] = this;
                setCarState(CarState.PARKED);
                parking.freePlaces--;
                System.out.println("Car № " + getCarId() +": " + getCarState());
                System.out.println("Parking places left: " + parking.freePlaces);
                lock.unlock();
                try {
                    TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(PARKING_TIME_FROM, PARKING_TIME_TO));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
        if (getCarState() == CarState.WAITING) {
            try {
                boolean timeLimitNotExpired = condition.await(MAX_WAITING_TIME, TimeUnit.SECONDS);
                if (timeLimitNotExpired) {
                    for (int i = 0; i < parking.parkingPlaces.length; i++) {
                        if (parking.parkingPlaces[i] == null) {
                            parking.parkingPlaces[i] = this;
                            setCarState(CarState.PARKED);
                            parking.freePlaces--;
                            System.out.println("Car № " + getCarId() + ": " + getCarState());
                            System.out.println("Parking places left: " + parking.freePlaces);
                            lock.unlock();
                            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(PARKING_TIME_FROM, PARKING_TIME_TO));
                            break;
                        }
                    }
                } else {
                    setCarState(CarState.LEFT);
                    System.out.println("Car № " + getCarId() +": " + getCarState() + " (The Car waiting time has expired)");
                    System.out.println("Parking places left: " + parking.freePlaces);
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized void leave(Parking parking) {
        lock.lock();
        for (int i = 0; i < parking.parkingPlaces.length; i++) {
            if (parking.parkingPlaces[i] == this) {
                setCarState(CarState.LEFT);
                parking.freePlaces++;
                System.out.println("Car № " + getCarId() +": " + getCarState());
                System.out.println("Parking places left: " + parking.freePlaces);
                parking.parkingPlaces[i] = null;
                condition.signal();
                break;
            }
        }
        lock.unlock();
    }

    public int getCarId() {
        return carId;
    }

    public CarState getCarState() {
        return carState;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carState=" + carState +
                '}';
    }
}
