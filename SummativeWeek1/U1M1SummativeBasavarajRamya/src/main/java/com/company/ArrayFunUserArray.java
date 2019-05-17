package com.company;

import java.util.Scanner;

/**
 * Program to read and print 5 numbers
 */
public class ArrayFunUserArray {
    public static void main(String[] args) {
        int[] numbers = readUserInput();
        print(numbers);
    }

    /**
     * To read user entered numbers
     * @return
     */
    public static int[] readUserInput() {
        Scanner scanner = new Scanner(System.in);
        int[] userInput = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Please enter your " + (i + 1) + " of 5 numbers");
            userInput[i] = Integer.parseInt(scanner.nextLine());
        }
        return userInput;
    }

    /**
     * prints number array
     *
     * @param numbers
     */
    public static void print(int[] numbers) {
        System.out.println("User Entered Numbers: ");
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }
}
