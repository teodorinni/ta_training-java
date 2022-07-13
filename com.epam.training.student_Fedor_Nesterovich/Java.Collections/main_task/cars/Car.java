package cars;

import cars.specifications.CarBodyTypes;
import cars.specifications.EngineTypes;
import exceptions.*;

import java.util.Objects;

public abstract class Car {

    private String model;
    private String manufacturer;
    private int priceUsd;
    private int maxSpeedKmPerHour;
    private double fuelConsumptionPer100Km;
    private CarBodyTypes bodyType;
    private EngineTypes engineType;

    public Car(String model, String manufacturer, int priceUsd, int maxSpeedKmPerHour, double fuelConsumptionPer100Km, CarBodyTypes bodyType, EngineTypes engineType) throws PriceBelowZeroException, MaxSpeedBelowZeroException, FuelConsumptionBelowZeroException {
        setModel(model);
        setManufacturer(manufacturer);
        setPriceUsd(priceUsd);
        setMaxSpeedKmPerHour(maxSpeedKmPerHour);
        setFuelConsumptionPer100Km(fuelConsumptionPer100Km);
        setBodyType(bodyType);
        setEngineType(engineType);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(int priceUsd) {
        if (priceUsd < 0) {
            throw new PriceBelowZeroException();
        }
        else {
            this.priceUsd = priceUsd;
        }
    }

    public int getMaxSpeedKmPerHour() {
        return maxSpeedKmPerHour;
    }

    public void setMaxSpeedKmPerHour(int maxSpeedKmPerHour) {
        if (maxSpeedKmPerHour < 0) {
            throw new MaxSpeedBelowZeroException();
        }
        else {
            this.maxSpeedKmPerHour = maxSpeedKmPerHour;
        }
    }

    public double getFuelConsumptionPer100Km() {
        return fuelConsumptionPer100Km;
    }

    public void setFuelConsumptionPer100Km(double fuelConsumptionPer100Km) {
        if (fuelConsumptionPer100Km < 0) {
            throw new FuelConsumptionBelowZeroException();
        }
        else {
            this.fuelConsumptionPer100Km = fuelConsumptionPer100Km;
        }
    }

    public CarBodyTypes getBodyType() {
        return bodyType;
    }

    public void setBodyType(CarBodyTypes bodyType) {
        this.bodyType = bodyType;
    }

    public EngineTypes getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineTypes engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", priceUsd=" + priceUsd +
                ", maxSpeedKmPerHour=" + maxSpeedKmPerHour +
                ", fuelConsumptionPer100Km=" + fuelConsumptionPer100Km +
                ", bodyType=" + bodyType +
                ", engineType=" + engineType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return priceUsd == car.priceUsd && maxSpeedKmPerHour == car.maxSpeedKmPerHour && Double.compare(car.fuelConsumptionPer100Km, fuelConsumptionPer100Km) == 0 && Objects.equals(model, car.model) && Objects.equals(manufacturer, car.manufacturer) && bodyType == car.bodyType && engineType == car.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, manufacturer, priceUsd, maxSpeedKmPerHour, fuelConsumptionPer100Km, bodyType, engineType);
    }
}
