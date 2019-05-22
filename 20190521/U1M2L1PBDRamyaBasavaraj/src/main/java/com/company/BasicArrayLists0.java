package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Program to create an ArrayList that can hold Integers. Add ten copies of the number -113 to the ArrayList.
 * Then display the contents of the ArrayList on the screen.
 */
public class BasicArrayLists0 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-113);
        numbers.add(-113);
        numbers.add(-113);
        numbers.add(-113);
        numbers.add(-113);
        numbers.add(-113);
        numbers.add(-113);
        numbers.add(-113);
        numbers.add(-113);
        numbers.add(-113);
        System.out.println("Slot 0 contains a "+ numbers.get(0));
        System.out.println("Slot 1 contains a "+ numbers.get(1));
        System.out.println("Slot 2 contains a "+ numbers.get(2));
        System.out.println("Slot 3 contains a "+ numbers.get(3));
        System.out.println("Slot 4 contains a "+ numbers.get(4));
        System.out.println("Slot 5 contains a "+ numbers.get(5));
        System.out.println("Slot 6 contains a "+ numbers.get(6));
        System.out.println("Slot 7 contains a "+ numbers.get(7));
        System.out.println("Slot 8 contains a "+ numbers.get(8));
        System.out.println("Slot 9 contains a "+ numbers.get(9));
    }
}
