package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Sum of integers using Array list
 */
public class Total {
    public static void main(String[] args) {
        int total = 0;
        List<Integer> numbers = new ArrayList<>();

        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);
        numbers.add(7);
        numbers.add(6);
        numbers.add(1);
        numbers.add(9);
        numbers.add(10);
        numbers.add(13);
        numbers.add(56);
        numbers.add(43);

        for (int element : numbers) {
            total += element;
        }

        System.out.println("The sum of all elements in the Array list is " + total);
    }
}
