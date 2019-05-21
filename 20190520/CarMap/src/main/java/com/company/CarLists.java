package com.company;

import java.util.*;

/**
 * Create a List called toyotaList to hold all the Car variables with "Toyota" as the manufacturer and add them to the List.
 * Create a List called fordList to hold all the Car variables with "Ford" as the manufacturer and add them to the List.
 * Create a List called hondaList to hold all the Car variables with "Honda" as the manufacturer and add them to the List.
 * Store all 3 List in a Map with the manufacturer as the key.
 */
public class CarLists {
    public static void main(String[] args) {
        Car camry = new Car("Toyota", "Camry");
        Car corolla = new Car("Toyota", "Corolla");
        Car highlander = new Car("Toyota", "Highlander");

        Car mustang = new Car("Ford", "Mustang");
        Car fusion = new Car("Ford", "Fusion");
        Car taurus = new Car("Ford", "Taurus");

        Car accord = new Car("Honda", "Accord");
        Car civic = new Car("Honda", "Civic");
        Car fit = new Car("Honda", "Fit");


        List<Car> toyotaList = new ArrayList<>();
        toyotaList.add(camry);
        toyotaList.add(corolla);
        toyotaList.add(highlander);

        List<Car> fordList = new ArrayList<>();
        fordList.add(mustang);
        fordList.add(fusion);
        fordList.add(taurus);

        List<Car> hondaList = new ArrayList<>();
        hondaList.add(accord);
        hondaList.add(civic);
        hondaList.add(fit);

        Map<String, List<Car>> cars = new HashMap<>();
        cars.put("Toyota", toyotaList);
        cars.put("Ford", fordList);
        cars.put("Honda", hondaList);
        //Print out the make and model for all Cars from all lists inside your Map.
        Set<Map.Entry<String, List<Car>>> carEntry = cars.entrySet();
        for (Map.Entry<String, List<Car>> entry : carEntry) {
            System.out.println("Key = " + entry.getKey());
            for (Car car : entry.getValue()) {
                System.out.println(" Car make: " + car.getMake() + " , Car Model: " + car.getModel());
            }
        }


    }

}
