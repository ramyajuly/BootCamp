package com.company;

import com.company.interfaces.UserIO;

public class Application {
    public static void main(String[] args) {
        //  UserIO userInput = new Input();
        UserIO betterInput = new BetterInput();
        int userInt = betterInput.readInt("Enter an integer");
        long userLong = betterInput.readLong("Enter a long");
        double userDouble = betterInput.readDouble("Enter a double");
        float userFloat = betterInput.readFloat("Enter a float");
        String userString = betterInput.readString("Enter a string");
        System.out.println("--------------------------");
        System.out.println("Integer value: " + userInt);
        System.out.println("Long value: " + userLong);
        System.out.println("Double value: " + userDouble);
        System.out.println("Float value: " + userFloat);
        System.out.println("String value: " + userString);
    }
}
