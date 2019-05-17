package com.company;

import java.util.Scanner;

/**
 * Program to convert number to month.
 * UserInput : integers
 */
public class MonthConverterIf {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int userInput = Integer.parseInt(myScanner.nextLine());
        String monthName = getMonthName(userInput);
        System.out.println(monthName);
    }

    /**
     * maps input number to corresponding month
     *
     * @param monthDigit
     * @return
     */
    public static String getMonthName(int monthDigit) {
        String month = "";
        if (monthDigit == 1) {
            month = "January";
        } else if (monthDigit == 2) {
            month = "February";
        } else if (monthDigit == 3) {
            month = "March";
        } else if (monthDigit == 4) {
            month = "April";
        } else if (monthDigit == 5) {
            month = "May";
        } else if (monthDigit == 6) {
            month = "June";
        } else if (monthDigit == 7) {
            month = "July";
        } else if (monthDigit == 8) {
            month = "August";
        } else if (monthDigit == 9) {
            month = "September";
        } else if (monthDigit == 10) {
            month = "October";
        } else if (monthDigit == 11) {
            month = "November";
        } else if (monthDigit == 12) {
            month = "December";
        } else {
            month = "You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.";
        }

        return month;
    }
}
