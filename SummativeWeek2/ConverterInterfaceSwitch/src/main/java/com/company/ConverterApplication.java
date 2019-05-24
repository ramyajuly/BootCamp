package com.company;

import java.util.Scanner;

public class ConverterApplication {
    public static void main(String[] args) {

        String day;
        String month;
        int dayWeek;
        int monthYear;
        Scanner scanner = new Scanner(System.in);
        try {
            Converter converterSwitch = new ConverterSwitch();
            System.out.println("Please enter a number for week? ");
            dayWeek = Integer.parseInt(scanner.nextLine());
            day = converterSwitch.convertDay(dayWeek);
            System.out.println("The day of the week: " + day);
            System.out.println("Please enter a number for month? ");
            monthYear = Integer.parseInt(scanner.nextLine());
            month = converterSwitch.convertMonth(monthYear);
            System.out.println("The month of the year: " + month);
        }
        catch (NumberFormatException nbe){
            System.out.println("You have entered an invalid number.Goodbye!");
        }
        catch (Exception ex)
        {
            ex.getMessage();
        }

    }
}
