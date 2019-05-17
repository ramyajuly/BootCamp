package com.company;

import java.util.Scanner;

/**
 * Program to convert number to month.
 * Userinput: integer
 */
public class MonthConverterSwitch {
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
        String month;

        switch (monthDigit) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                month = "You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.";
                break;
        }
        return month;

    }
}
