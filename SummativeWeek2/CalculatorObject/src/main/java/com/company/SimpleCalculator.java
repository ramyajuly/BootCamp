package com.company;

/**
 * Program to instantiate the object and use it to perform the following calculations
 * 1 + 1
 * 23 - 52
 * 34 * 2
 * 12 / 3
 * 12 / 7
 * 3.4 + 2.3
 * 6.7 * 4.4
 * 5.5 - 0.5
 * 10.8 / 2.2
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        double a = 1;
        double b = 1;
        System.out.format("%.2f\n",calculate.add(a, b));
        a = 23;
        b = 52;
        System.out.format("%.2f\n",calculate.subtract(a, b));
        a = 34;
        b = 2;
        System.out.format("%.2f\n",calculate.multiply(a, b));
        a = 12;
        b = 3;
        System.out.format("%.2f\n",calculate.divide(a, b));
        a = 12;
        b = 7;
        System.out.format("%.2f\n",calculate.divide(a, b));
        a = 3.4;
        b = 2.3;
        System.out.format("%.2f\n",calculate.add(a, b));
        a = 6.7;
        b = 4.4;
        System.out.format("%.2f\n",calculate.multiply(a, b));
        a=5.5;
        b=0.5;
        System.out.format("%.2f\n",calculate.subtract(a, b));
        a=10.8;
        b=2.2;
        System.out.format("%.2f\n",calculate.divide(a, b));
    }
}
