import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Plane extends Thread {

    private static int planeCounter = 1;
    private static final int TIME_FOR_TAKEOFF = 3;
    private int planeID;
    private PlaneState planeState;
    private Airport airport;
    private static ReentrantLock lock = new ReentrantLock(true);
    private static Condition condition = lock.newCondition();

    public Plane(Airport airport) {
        this.planeID = planeCounter;
        this.airport = airport;
        planeCounter++;
        planeState = PlaneState.WAITING;
    }

    @Override
    public void run() {
        enterRunway(this.airport);
        leaveRunway(this.airport);
    }

    synchronized void enterRunway(Airport airport) {
        lock.lock();
        for (int i = 0; i < airport.runways.length; i++) {
            if (airport.runways[i] == null) {
                airport.runways[i] = this;
                setCarState(PlaneState.ON_RUNWAY);
                airport.freeRunways--;
                System.out.println("Plane № " + getPlaneID() +": " + getCarState());
                System.out.println("Free runways left: " + airport.freeRunways);
                lock.unlock();
                try {
                    TimeUnit.SECONDS.sleep(TIME_FOR_TAKEOFF);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
        if (getCarState() == PlaneState.WAITING) {
            try {
                condition.await();
                    for (int i = 0; i < airport.runways.length; i++) {
                        if (airport.runways[i] == null) {
                            airport.runways[i] = this;
                            setCarState(PlaneState.ON_RUNWAY);
                            airport.freeRunways--;
                            System.out.println("Plane № " + getPlaneID() + ": " + getCarState());
                            System.out.println("Free runways left: " + airport.freeRunways);
                            lock.unlock();
                            TimeUnit.SECONDS.sleep(TIME_FOR_TAKEOFF);
                            break;
                        }
                    }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized void leaveRunway(Airport airport) {
        lock.lock();
        for (int i = 0; i < airport.runways.length; i++) {
            if (airport.runways[i] == this) {
                setCarState(PlaneState.LEFT_RUNWAY);
                airport.freeRunways++;
                System.out.println("Plane № " + getPlaneID() +": " + getCarState());
                System.out.println("Free runways left: " + airport.freeRunways);
                airport.runways[i] = null;
                condition.signal();
                break;
            }
        }
        lock.unlock();
    }

    public int getPlaneID() {
        return planeID;
    }

    public PlaneState getCarState() {
        return planeState;
    }

    public void setCarState(PlaneState planeState) {
        this.planeState = planeState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return planeID == plane.planeID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeID);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "planeId=" + planeID +
                ", planeState=" + planeState +
                '}';
    }
}
