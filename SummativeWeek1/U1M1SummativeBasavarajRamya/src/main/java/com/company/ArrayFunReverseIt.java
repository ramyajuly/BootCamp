package com.company;

/**
 * Program to declare the following array [1, 2, 3, 4, 5],
 * create another array of equal length, and fill that array with values
 * from the original array in reverse order and print both the arrays.
 */
public class ArrayFunReverseIt {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Original Array: ");
        print(numbers);

        int[] reverseNumbers = reverseIt(numbers);
        System.out.println("Reversed Array: ");
        print(reverseNumbers);
    }

    /**
     * Copy and reverse array elements
     * @param numbers
     * @return
     */
    public static int[] reverseIt(int[] numbers) {
        int[] reverseNumbers = new int[numbers.length];
        for (int i = 0, j = reverseNumbers.length - 1; i < numbers.length; i++, j--) {
            reverseNumbers[j] = numbers[i];
        }
        return reverseNumbers;
    }

    /**
     * Print array elements
     * @param numbers
     */
    public static void print(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
        System.out.println();
    }

}
