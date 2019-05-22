package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Program to Create an ArrayList of Integers. Fill up the list with ten random numbers, each from 1 to 100.
 * Then display the contents of the ArrayList on the screen.
 */
public class BasicArrayLists2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(10);
        Random randomGenerator= new Random();
        while(numbers.size() <10){
            numbers.add(randomGenerator.nextInt(100) + 1);
        }
        System.out.println("Array list: " + numbers);
    }
}
