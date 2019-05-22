package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Program to create an ArrayList of Integers
 * Fill the ArrayList with ten random numbers (1-100)
 * Copy each value from the ArrayList into another ArrayList of the same capacity
 * Change the last value in the first ArrayList to a -7
 * Display the contents of both ArrayLists
 */
public class CopyingArrayLists {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(10);
        Random randomGenerator = new Random();
        while (numbers.size() < 10) {
            numbers.add(randomGenerator.nextInt(100) + 1);
        }
       // System.out.println("Array list: " + numbers);
        List<Integer> copyNumbers = new ArrayList<>();
        int j = 0;
        while (j < numbers.size()) {
            copyNumbers.add(numbers.get(j));
            j++;
        }
        numbers.set(numbers.size()-1,-7);
        System.out.println("Array list: " + numbers);
        System.out.println("Array list: " + copyNumbers);
    }
}

