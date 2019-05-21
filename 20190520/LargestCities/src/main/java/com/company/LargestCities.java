package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Create a Map that holds the names of states and their corresponding City objects (State name is the key, City object is the value)
 * Prints the name and population for each City along with its corresponding state name to the screen
 * Prints the states with cities that have a population over a given value (this value is typed in by the user of the program) to the screen
 */
public class LargestCities {
    public static void main(String[] args) {
        Map<String, City> largestCities = new HashMap<>();
        largestCities.put("New York", new City("New York", 8654321));
        largestCities.put("California", new City("Los Angeles", 4563218));
        largestCities.put("Illinois", new City("Chicago", 2716520));
        largestCities.put("Colorado", new City("Denver", 704621));
        largestCities.put("Iowa", new City("Des Moines", 217521));
        largestCities.put("Georgia", new City("Atlanta", 486213));

        Set<String> stateKeys = largestCities.keySet();

        for (String stateKey : stateKeys) {
            City city = largestCities.get(stateKey);
            System.out.println("State: " + stateKey + " , City: " + city.getName() + ", Population: " + city.getPopulation());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Enter minimum population: ");
        long userNumber = Long.parseLong(scanner.nextLine());
        System.out.println("Following are the cities whose population is above the limit: " + userNumber);
        for (String stateKey : stateKeys) {
            City city = largestCities.get(stateKey);
            if (city.getPopulation() > userNumber) {
                System.out.println("State: " + stateKey + " , City: " + city.getName());
            }
        }
    }
}
