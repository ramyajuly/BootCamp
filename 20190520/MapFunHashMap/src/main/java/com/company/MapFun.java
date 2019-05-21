package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Program to add, remove and print key/value pair in Hash map
 */
public class MapFun {
    public static void main(String[] args) {
        Map<String, Integer> carModels = new HashMap<>();
        carModels.put("Toyota Camry",2012);
        carModels.put("Chevy Camaro",1969);
        carModels.put("Hyundai Genesis",2015);
        carModels.put("Jeep Wrangler",2003);
        carModels.put("Honda Civic",2018);
        carModels.put("Toyota Supra",1995);
        carModels.put("Pontiac GTO",1964);
        carModels.put("Toyota Camry",2012);

        Set<Map.Entry<String, Integer>> carModelEntries = carModels.entrySet();
        System.out.println("Printing out all key/value pairs in the Map :");
        System.out.println("-------------------------------------------------");
        for (Map.Entry<String, Integer> entry : carModelEntries) {
            System.out.println("Key = " + entry.getKey() + "; Value = " + entry.getValue());
        }
     //Add two new entries to the Map - a 2012 Ford Explorer and a 2013 Smart Fortwo.
        carModels.put("Ford Explorer",2012);
        carModels.put("Smart Fortwo",1969);
        carModelEntries = carModels.entrySet();
        System.out.println("-------------------------------------------------");
        System.out.println("After adding two new entries, Printing out all key/value pairs in the Map :");
        System.out.println("-------------------------------------------------");
        for (Map.Entry<String, Integer> entry : carModelEntries) {
            System.out.println("Key = " + entry.getKey() + "; Value = " + entry.getValue());
        }

        //Remove the Jeep Wrangler from the Map
        carModels.remove("Jeep Wrangler");
        carModelEntries = carModels.entrySet();
        System.out.println("-------------------------------------------------");
        System.out.println("After removing an entry, Printing out all key/value pairs in the Map :");
        System.out.println("-------------------------------------------------");
        for (Map.Entry<String, Integer> entry : carModelEntries) {
            System.out.println("Key = " + entry.getKey() + "; Value = " + entry.getValue());
        }
    }
}
