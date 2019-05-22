package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Program to Create an ArrayList that can hold Integers, and fill each slot with a different random value from 1-50.
 * Display those values on the screen, and then prompt the user for an integer.
 * Search through the ArrayList, and if the item is present, give the slot number where it is located.
 * If the value is not in the ArrayList, display a single message saying so.
 * If the value is present more than once, display the message as many times as necessary,
 * or display a single message giving the last slot number in which it appeared.
 */
public class WhereIsItArrayList {
    public static void main(String[] args) {
        try {
            List<Integer> numbers = new ArrayList<>(10);
            Random randomGenerator = new Random();
            while (numbers.size() < 10) {
                numbers.add(randomGenerator.nextInt(50) + 1);
            }
            System.out.print("Array list: " + numbers);
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nValue to find:");
            int userValue = Integer.parseInt(scanner.nextLine());
            boolean valueFound = false;
            for (int i = 0; i < numbers.size(); i++) {
                if (userValue == numbers.get(i)) {
                    System.out.println(userValue + " is in slot " + i);
                    valueFound = true;
                }
            }
            if(!valueFound){
                System.out.println(userValue +" not found in the ArrayList.");
            }
        } catch (Exception ex) {
            System.out.println("Try again with number");
        }
    }
}
