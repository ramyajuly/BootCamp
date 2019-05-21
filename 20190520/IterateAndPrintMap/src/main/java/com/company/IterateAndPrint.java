package com.company;
import java.util.*;

/**
 *
 */
public class IterateAndPrint {
    public static void main(String[] args) {

        Map<String, String> baseballTeam = new HashMap<>();

        baseballTeam.put("Pitcher", "Mike Foltynewicz");
        baseballTeam.put("Catcher", "Brian McCann");
        baseballTeam.put("First Baseman", "Freddie Freeman");
        baseballTeam.put("Second Baseman", "Ozzie Albies");
        baseballTeam.put("Third Baseman", "Josh Donaldson");
        baseballTeam.put("Shortstop", "Dansby Swanson");
        baseballTeam.put("Left Fielder", "Ronald Acuna, Jr.");
        baseballTeam.put("Center Fielder", "Ender Inciarte");
        baseballTeam.put("Right Fielder", "Nick Markakis");


        Set<String> baseBallKeys = baseballTeam.keySet();
        System.out.println("Iterate through and printing all keys in the Map:");
        System.out.println("---------------------------------------------------------");
        for (String key: baseBallKeys) {
            System.out.println(key);
        }

        Collection<String> baseBallValues = baseballTeam.values();
        System.out.println("---------------------------------------------------------");
        System.out.println("Iterate through and printing all values in the Map ");
        System.out.println("---------------------------------------------------------");
        for (String value : baseBallValues) {
            System.out.println(value);
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("Iterate through the Entry Set of the Map and print both the keys and values in the Map.");
        System.out.println("---------------------------------------------------------");

        Set<Map.Entry<String, String>> baseBallEntries = baseballTeam.entrySet();
        for (Map.Entry<String, String> entry : baseBallEntries) {
            System.out.println("Key = " + entry.getKey() + "; Value = " + entry.getValue());
        }

    }


}
