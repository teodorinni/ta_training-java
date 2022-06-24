package cars;

import cars.specifications.CarBodyTypes;
import cars.specifications.EngineTypes;
import exceptions.PassengersBelowZeroException;

import java.util.List;
import java.util.Objects;

public class TaxiCar extends Car {

    private List<String> driversList;
    private int maxPassengers;

    public TaxiCar(String model, String manufacturer, int priceUsd, int maxSpeedKmPerHour, double fuelConsumptionPer100Km, CarBodyTypes bodyType, EngineTypes engineType, List<String> driversList, int maxPassengers) {
        super(model, manufacturer, priceUsd, maxSpeedKmPerHour, fuelConsumptionPer100Km, bodyType, engineType);
        setDriversList(driversList);
        setMaxPassengers(maxPassengers);
    }

    public List<String> getDriversList() {
        return driversList;
    }

    public void setDriversList(List<String> driversList) {
        this.driversList = driversList;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        if (maxPassengers < 0) {
            throw new PassengersBelowZeroException();
        }
        else{
            this.maxPassengers = maxPassengers;
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("}","") +
                ", driversList=" + driversList +
                ", maxPassengers=" + maxPassengers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TaxiCar taxiCar = (TaxiCar) o;
        return maxPassengers == taxiCar.maxPassengers && Objects.equals(driversList, taxiCar.driversList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), driversList, maxPassengers);
    }
}
