package com.company;

import java.util.Scanner;

/**
 * program that prompts the user for a number between 1 and 10 and
 * keeps asking until the entered number is in range
 * UserInput : integer
 */
public class ValidNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 10.");
        boolean isValid;
        do {
            int userInput = Integer.parseInt(scanner.nextLine());
            isValid = validateNumber(userInput);
            if (isValid) {
                System.out.println("You entered: " + userInput);
            } else {
                System.out.println("You must enter a number between 1 and 10, please try again.");
            }

        } while (!isValid);
    }

    /**
     * To validate the user input
     *
     * @param userInput
     * @return
     */
    public static boolean validateNumber(int userInput) {
        return (userInput >= 1 && userInput <= 10);
    }
}

