package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Create an ArrayList that can hold Integers.
 * Add ten copies of the number -113 to the ArrayList. Then display the contents of the ArrayList on the screen.
 */
public class BasicArrayLists1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(10);
        while (numbers.size() < 10) {
            numbers.add(-113);
        }
        int j=0;
        while(j<numbers.size()){
            System.out.println("Slot "+ j +" contains a "+ numbers.get(j));
            j++;
        }
    }
}
