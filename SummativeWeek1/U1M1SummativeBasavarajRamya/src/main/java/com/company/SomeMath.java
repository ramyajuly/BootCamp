package com.company;

/**
 * Program to find Total, average, largest
 */
public class SomeMath {
    public static void main(String[] args) {
        int total = total5(1, 2, 3, 4, 5);
        System.out.println("Total of numbers: " + total);
        double average = average5(1, 3, 5, 7, 9);
        System.out.println("Average of numbers: " + average);
        double largest = largest5(42.0, 35.1, 2.3, 40.2, 15.6);
        System.out.println("largest of numbers: " + largest);
    }

    /**
     * To find total for 5 number
     *
     * @param num1
     * @param num2
     * @param num3
     * @param num4
     * @param num5
     * @return
     */
    public static int total5(int num1, int num2, int num3, int num4, int num5) {
        return num1 + num2 + num3 + num4 + num5;
    }

    /**
     * To find the average for 5 numbers
     *
     * @param num1
     * @param num2
     * @param num3
     * @param num4
     * @param num5
     * @return
     */
    public static double average5(int num1, int num2, int num3, int num4, int num5) {
        return ((num1 + num2 + num3 + num4 + num5) / 5);
    }

    /**
     * To find the largest of 5 numbers
     *
     * @param num1
     * @param num2
     * @param num3
     * @param num4
     * @param num5
     * @return
     */
    public static double largest5(double num1, double num2, double num3, double num4, double num5) {
        double[] numbers = {num1, num2, num3, num4, num5};
        double largeNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largeNumber) {
                largeNumber = numbers[i];
            }
        }

        return largeNumber;
    }
}
