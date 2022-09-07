package airport;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Plane extends Thread {

    private static int planeCounter = 1;
    private static final int TIME_FOR_TAKEOFF = 3;
    private final int planeID;
    private PlaneState planeState;
    private final Airport airport;
    private static final ReentrantLock lock = new ReentrantLock(true);
    private static final Condition condition = lock.newCondition();

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
        Plane[] runways = airport.getRunways();
        for (int i = 0; i < runways.length; i++) {
            if (runways[i] == null) {
                runways[i] = this;
                setCarState(PlaneState.ON_RUNWAY);
                airport.setFreeRunways(airport.getFreeRunways() - 1);
                airport.setRunways(runways);
                System.out.println("Plane № " + getPlaneID() +": " + getCarState());
                System.out.println("Free runways left: " + airport.getFreeRunways());
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
                    for (int i = 0; i < runways.length; i++) {
                        if (runways[i] == null) {
                            runways[i] = this;
                            setCarState(PlaneState.ON_RUNWAY);
                            airport.setFreeRunways(airport.getFreeRunways() - 1);
                            airport.setRunways(runways);
                            System.out.println("Plane № " + getPlaneID() + ": " + getCarState());
                            System.out.println("Free runways left: " + airport.getFreeRunways());
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
        Plane[] runways = airport.getRunways();
        for (int i = 0; i < runways.length; i++) {
            if (runways[i] == this) {
                setCarState(PlaneState.LEFT_RUNWAY);
                airport.setFreeRunways(airport.getFreeRunways() + 1);
                System.out.println("Plane № " + getPlaneID() +": " + getCarState());
                System.out.println("Free runways left: " + airport.getFreeRunways());
                runways[i] = null;
                airport.setRunways(runways);
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
