package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Program to create an ArrayList of Integers. Fill up the list with 1,000 random numbers, each from 10 to 99.
 * Then display the contents of the ArrayList on the screen.
 */
public class BasicArrayLists3 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(1000);
        Random randomGenerator= new Random();
        while(numbers.size() <1000){
            numbers.add(randomGenerator.nextInt(90) + 10);
        }
        System.out.print("Array list: " + numbers);
    }
}
