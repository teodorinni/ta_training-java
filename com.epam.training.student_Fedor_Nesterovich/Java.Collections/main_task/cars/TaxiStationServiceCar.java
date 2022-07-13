package cars;

import cars.specifications.CarBodyTypes;
import cars.specifications.EngineTypes;
import cars.specifications.ServiceCarPurposes;
import exceptions.FuelConsumptionBelowZeroException;
import exceptions.MaxSpeedBelowZeroException;
import exceptions.PriceBelowZeroException;

import java.util.Objects;

public class TaxiStationServiceCar extends Car {

    private String responsibleEmployee;
    private ServiceCarPurposes carPurpose;

    public TaxiStationServiceCar(String model, String manufacturer, int priceUsd, int maxSpeedKmPerHour, double fuelConsumptionPer100Km, CarBodyTypes bodyType, EngineTypes engineType, String responsibleEmployee, ServiceCarPurposes carPurpose) throws PriceBelowZeroException, MaxSpeedBelowZeroException, FuelConsumptionBelowZeroException {
        super(model, manufacturer, priceUsd, maxSpeedKmPerHour, fuelConsumptionPer100Km, bodyType, engineType);
        setResponsibleEmployee(responsibleEmployee);
        setCarPurpose(carPurpose);
    }

    public String getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee(String responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    public ServiceCarPurposes getCarPurpose() {
        return carPurpose;
    }

    public void setCarPurpose(ServiceCarPurposes carPurpose) {
        this.carPurpose = carPurpose;
    }

    @Override
    public String toString() {
        return super.toString().replace("}","") +
                ", responsibleEmployee=" + responsibleEmployee +
                ", carPurpose=" + carPurpose +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TaxiStationServiceCar that = (TaxiStationServiceCar) o;
        return Objects.equals(responsibleEmployee, that.responsibleEmployee) && carPurpose == that.carPurpose;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), responsibleEmployee, carPurpose);
    }
}
