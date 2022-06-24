import cars.*;
import cars.specifications.CarBodyTypes;
import cars.specifications.EngineTypes;
import cars.specifications.ServiceCarPurposes;
import taxi_station.TaxiStation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Car> cars = Arrays.asList(
        new TaxiCar("Accent", "Hyundai", 13000, 194, 6.2, CarBodyTypes.SEDAN, EngineTypes.PETROL, Arrays.asList("John Doe", "Jack Doe"), 3),
        new TaxiCar("Golf", "Volkswagen", 16000, 196, 6.0, CarBodyTypes.HATCHBACK, EngineTypes.PETROL, List.of("Jack Harris"), 3),
        new TaxiCar("Scenic", "Renault", 15000, 186, 4.7, CarBodyTypes.MINIVAN, EngineTypes.DIESEL, Arrays.asList("Jack Harris", "John Doe"), 5),
        new TaxiCar("5-series", "BMW", 28000, 235, 7.4, CarBodyTypes.SEDAN, EngineTypes.PETROL, List.of("Jack Bauer"), 3),
        new TaxiCar("Volvo", "V90", 35000, 210, 7.0, CarBodyTypes.ESTATE, EngineTypes.PETROL, Arrays.asList("Jack Bauer", "Jack Doe"), 4),
        new TaxiCar("Sprinter", "Mercedes", 30000, 190, 8.0, CarBodyTypes.MINIBUS, EngineTypes.DIESEL, Arrays.asList("Adam Sandler", "Gregg Monroe"), 12),
        new TaxiCar("RAV4", "Toyota", 27000, 202, 6.7, CarBodyTypes.CROSSOVER, EngineTypes.HYBRID, Arrays.asList("John Doe", "Jack Doe"), 3),
        new TaxiCar("Model 3", "Tesla", 37000, 215, 0, CarBodyTypes.SEDAN, EngineTypes.ELECTRIC, Arrays.asList("Jane Doe", "Gregg Monroe", "Richard Harper"), 3),
        new TaxiCar("Land Cruiser", "Toyota", 45000, 206, 10.3, CarBodyTypes.SUV, EngineTypes.PETROL, List.of("Jack Doe"), 5),
        new TaxiStationServiceCar("Polo", "Volkswagen", 14000, 194, 4.5, CarBodyTypes.HATCHBACK, EngineTypes.PETROL, "Adam Sandler", ServiceCarPurposes.MAINTENANCE_CAR),
        new TaxiStationServiceCar("Superb", "Skoda", 22000, 217, 5.7, CarBodyTypes.SEDAN, EngineTypes.DIESEL, "Jack Bauer", ServiceCarPurposes.MANAGEMENT_CAR),
        new TaxiStationServiceCar("Civic", "Honda", 17000, 204, 4.2, CarBodyTypes.HATCHBACK, EngineTypes.HYBRID, "Jack Harris", ServiceCarPurposes.REPLACEMENT_CAR)
    );

    public static void main(String[] args) {
        TaxiStation taxiStation = new TaxiStation(cars);
        System.out.println("Total cost of all cars in the taxi station: " + taxiStation.getTotalCarsCost());
        taxiStation.sortByFuelConsumption();
        System.out.println("Cars, sorted by fuel consumption: " + taxiStation.getCars());
        Scanner input = new Scanner(System.in);
        System.out.print("Please, enter the minimum top speed for car selection: ");
        int maxSpeedFrom = input.nextInt();
        System.out.print("Please, enter the maximum top speed for car selection: ");
        int maxSpeedTo = input.nextInt();
        System.out.println("Cars with top speed in entered range: " + taxiStation.getCarsByMaxSpeed(maxSpeedFrom, maxSpeedTo));
    }
}
