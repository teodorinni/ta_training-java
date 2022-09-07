package parking;

public class Parking {

    private Car[] parkingPlaces = new Car[5];
    private int freePlaces = 5;

    public Car[] getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(Car[] parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = freePlaces;
    }
}
