package com.trilogy;

/**
 * Program to perform some simple arithmetic operations
 */
public class Main {
    public static void main(String[] args) {
        //Integer
        System.out.println("To calculate of type Integer: ");
        System.out.format("4 + 9 is %d%n", Calculator.add(4, 9));
        System.out.format("22 - 14 is %d%n", Calculator.subtract(22, 14));
        System.out.format("6 * 11 is %d%n", Calculator.multiply(6, 11));
        System.out.format("88 divided by 22 is %f%n", Calculator.divide(88, 22));

        //Float
        System.out.println("\nTo calculate of type Float: ");
        System.out.format("3.2f + 7.9f is %f%n", Calculator.add(3.2f, 7.9f));
        System.out.format("10.3f - 4.22f is %f%n", Calculator.subtract(10.3f, 4.22f));
        System.out.format("6.1f * 11.5f is %f%n", Calculator.multiply(6.1f, 11.5f));
        System.out.format("22.4f divided by 3.67f is %f%n", Calculator.divide(22.4f, 3.67f));

        //Long
        System.out.println("\nTo calculate of type Long: ");
        System.out.format("33L + 307L is %d%n", Calculator.add(33, 307));
        System.out.format("840L - 501L is %d%n", Calculator.subtract(840, 501));
        System.out.format("26L * 13L is %d%n", Calculator.multiply(26, 13));
        System.out.format("7414L divided by 22L is %f%n", Calculator.divide(7414, 22));
        //double
        System.out.println("\nTo calculate of type double: ");
        System.out.format("66.33 + 77.41 is %f%n", Calculator.add(66.33, 77.41));
        System.out.format("104.29 - 36.23 is %f%n", Calculator.subtract(104.29, 36.23));
        System.out.format("48.1 * 2.4 is %f%n", Calculator.multiply(48.1, 2.4));
        System.out.format("90.432 divided by 44.12 is %f%n", Calculator.divide(90.432, 44.12));

        //Test data from GitLab
        System.out.println("\nTest data from GitLab: ");
        System.out.format("3 + 4 is %d%n", Calculator.add(3, 4));
        System.out.format("105 - 13 is %d%n", Calculator.subtract(105, 13));
        System.out.format("373 * 11 is %d%n", Calculator.multiply(373, 11));
        System.out.format("8 divided by 15 is %f%n", Calculator.divide(8, 15));


    }
}
