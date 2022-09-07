package airport;

public class Airport {

    private Plane[] runways = new Plane[5];
    private int freeRunways = 5;

    public Plane[] getRunways() {
        return runways;
    }

    public void setRunways(Plane[] runways) {
        this.runways = runways;
    }

    public int getFreeRunways() {
        return freeRunways;
    }

    public void setFreeRunways(int freeRunways) {
        this.freeRunways = freeRunways;
    }
}
