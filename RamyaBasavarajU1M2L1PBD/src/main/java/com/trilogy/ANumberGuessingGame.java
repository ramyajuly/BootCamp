package com.trilogy;

import java.util.Random;
import java.util.Scanner;

/**
 * Program to pick a random number from 1 to 10 and have the user try to guess that.
 * Tell them if they get it right or wrong, and if they get it wrong,
 * show them what the random number was.
 */
public class ANumberGuessingGame {
    public static void main(String[] args) {
        guessNumber();
    }

    /**
     * To guess the number
     */
    public static void guessNumber() {
        Random randomGenerator = new Random();
        int compGuess = randomGenerator.nextInt(10) + 1;
        System.out.println("I'm thinking of a number from 1 to 10.");
        System.out.println("Your guess: ");
        Scanner scanner = new Scanner(System.in);
        int userGuess = Integer.parseInt(scanner.nextLine());
        if (userGuess == compGuess) {
            System.out.println("That's right!  My secret number was " + compGuess + "!");
        } else {
            System.out.println("Sorry, but I was really thinking of " + compGuess);
        }
    }

}
