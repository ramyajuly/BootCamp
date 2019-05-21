package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Swap last element and first and print using Linked list
 */
public class SwapAndPrintLinkedList {
    public static void main(String[] args) {
        int[] numberArray = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};
        List<Integer> numbers = new LinkedList<>();
        for (int num : numberArray) {
            numbers.add(num);
        }
        System.out.println("----------------");
        System.out.println("Original Linked List");
        for (int element : numbers) {
            System.out.println(element);
        }
        int temp = numbers.get(0);
        int lastElementIndex = numbers.size() - 1;
        numbers.set(0, numbers.get(lastElementIndex));
        numbers.set(lastElementIndex, temp);
        System.out.println("----------------");
        System.out.println("Swapped Linked List");
        for (int element : numbers) {
            System.out.println(element);
        }

    }
}
