package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse And Print the ArrayList
 */
public class ReverseAndPrint {
    public static void main(String[] args) {
        int [] numberArray = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};
        List<Integer> numbers = new ArrayList<>();
        for (int num : numberArray) {
            numbers.add(num);
        }
        System.out.println("--------------");
        System.out.println("Normal");
        System.out.println("--------------");
        for(int element : numbers) {
            System.out.println(element);
        }
        List<Integer> reversed = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++) {
            reversed.add(numbers.get(numbers.size()-(i+1)));
        }
        System.out.println("--------------");
        System.out.println("Reversed");
        System.out.println("--------------");
        for(int element : reversed) {
            System.out.println(element);
        }
    }
}
