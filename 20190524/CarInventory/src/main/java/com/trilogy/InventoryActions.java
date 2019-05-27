package com.trilogy;

import java.util.List;

public interface InventoryActions {
    public List<Car> addCar(List<Car> lstAllCar, Car car);
    public List<Car> deleteCar(List<Car> lstAllCar, int uniqueId);
    public void listAllCars(List<Car> cars);
    public List<Car> searchCars(List<Car> lstCar, int searchIndex, String userInput);
}
