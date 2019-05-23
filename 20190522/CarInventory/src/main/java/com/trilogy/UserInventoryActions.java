package com.trilogy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserInventoryActions implements InventoryActions {

    /**
     * To car to inventory
     * @param lstAllCar
     * @param car
     * @return
     */
    @Override
    public List<Car> addCar(List<Car> lstAllCar, Car car) {
        lstAllCar.add(car);
        return lstAllCar;
    }

    /**
     * To delete a car from inventory
     * @param cars
     * @param uniqueId
     * @return
     */
    @Override
    public List<Car> deleteCar(List<Car> cars, int uniqueId) {
        cars.removeIf(car->car.getUniqueId()==uniqueId);
        return cars;
    }

    /**
     * To list all cars in the inventory
     * @param cars
     */
    @Override
    public void listAllCars(List<Car> cars) {
        if (cars != null && cars.size() != 0) {
            cars
                    .stream()
                    .forEach(car -> {
                                System.out.println("CarId: " + car.getUniqueId());
                                System.out.println("Make: " + car.getMake());
                                System.out.println("Model: " + car.getModel());
                                System.out.println("Year: " + car.getYear());
                                System.out.println("Color: " + car.getColor());
                                System.out.println("Miles: " + car.getMiles());
                                System.out.println("===============");
                            }
                    );
        }
        else{
            System.out.println("No cars in Inventory");
        }
    }

    /**
     * To search the car inventory
     * @param lstCar
     * @param searchIndex
     * @param userInput
     * @return
     */
    @Override
    public List<Car> searchCars(List<Car> lstCar, int searchIndex, String userInput) {
        List<Car> cars = new ArrayList<>();
        switch (searchIndex) {
            case 1:
                cars = lstCar.stream().filter(b->b.getMake().equalsIgnoreCase(userInput)).collect(Collectors.toList());
                break;
            case 2:
                cars = lstCar.stream().filter(b->b.getModel().equalsIgnoreCase(userInput)).collect(Collectors.toList());
                break;
            case 3:
                cars = lstCar.stream().filter(b->b.getColor().equalsIgnoreCase(userInput)).collect(Collectors.toList());
                break;
            case 4:
                cars = lstCar.stream().filter(b->b.getYear() ==Integer.parseInt(userInput)).collect(Collectors.toList());
                break;
            case 5:
                cars = lstCar.stream().filter(b->b.getMiles()<Double.parseDouble(userInput)).collect(Collectors.toList());
                break;
            default:
                System.out.println("Not a valid Input");
                break;
        }
        return cars;
    }

    /**
     * Initial car inventory data;
     * @return
     */
    public List<Car> carDatabase() {
        List<Car> lstCar = new ArrayList<>();
        Car carAdd = new Car("Nissan", "Altima", 2012, "White", 400, 1);
        lstCar.add(carAdd);
        carAdd = new Car("Honda", "Accord", 2016, "Black", 566.8, 2);
        lstCar.add(carAdd);
        carAdd = new Car("Toyota", "Camry", 2017, "Blue", 577.9, 3);
        lstCar.add(carAdd);
        return lstCar;
    }

}
