package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * program to creates an ArrayList of Integers.
 * Fill the ArrayList with random numbers from 1 to 100.
 * Display the values in the ArrayList on the screen.
 * Then use a linear search to find the largest value in the ArrayList,
 * and display that value and its slot number.
 */
public class LargeNumber {
    public static void main(String[] args) {
            List<Integer> numbers = new ArrayList<>(10);
            Random randomGenerator = new Random();
            while (numbers.size() < 10) {
                numbers.add(randomGenerator.nextInt(100) + 1);
            }
            System.out.println("Array list: " + numbers);
            int largeNumber = numbers.get(0);
            int slot = 0;
            for (int i = 0; i < numbers.size(); i++) {
                if (largeNumber < numbers.get(i)) {
                    largeNumber = numbers.get(i);
                    slot = i;
                }
            }
            System.out.println("The largest value is: " + largeNumber + ", which is in slot " + slot);
    }
}
