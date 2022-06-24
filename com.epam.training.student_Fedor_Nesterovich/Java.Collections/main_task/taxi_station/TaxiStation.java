package taxi_station;

import cars.Car;
import cars.TaxiCar;
import cars.TaxiStationServiceCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiStation {

    private List<Car> cars;

    public TaxiStation(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTotalCarsCost() {
        int totalCarsCost = 0;
        for (Car car : cars) {
            totalCarsCost += car.getPriceUsd();
        }
        return totalCarsCost;
    }

    public TaxiStation sortByFuelConsumption() {
        cars.sort(Comparator.comparing(Car::getFuelConsumptionPer100Km));
        return this;
    }

    public List<Car> getCarsByMaxSpeed(int maxSpeedFrom, int maxSpeedTo) {
        List<Car> selectedCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMaxSpeedKmPerHour() >= maxSpeedFrom && car.getMaxSpeedKmPerHour() <= maxSpeedTo) {
                selectedCars.add(car);
            }
        }
        return selectedCars;
    }

    public List<TaxiCar> getTaxiCars() {
        List<TaxiCar> taxiCars = new ArrayList<>();
        for (Car car : cars) {
            if (car instanceof TaxiCar) {
                taxiCars.add((TaxiCar) car);
            }
        }
        return taxiCars;
    }

    public List<TaxiStationServiceCar> getTaxiStationServiceCars() {
        List<TaxiStationServiceCar> taxiStationServiceCars = new ArrayList<>();
        for (Car car : cars) {
            if (car instanceof TaxiStationServiceCar) {
                taxiStationServiceCars.add((TaxiStationServiceCar) car);
            }
        }
        return taxiStationServiceCars;
    }

    @Override
    public String toString() {
        return "TaxiStation{" +
                "cars=" + cars +
                '}';
    }
}
