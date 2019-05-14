package com.trilogy;

import java.util.Random;

/**
 * program that simulates a dice roll by picking a random number from 1-6 and then picking a second random number from 1-6.
 * Add the two values together, and display the total
 */
public class Dice {
    public static void main(String[] args) {
        rollDiceAndPrint();
    }

    /**
     * Adds two values of dice
     */
    private static void rollDiceAndPrint() {
        Random dice1 = new Random();
        Random dice2 = new Random();
        int dice1Num = dice1.nextInt(6) + 1;
        int dice2Num = dice2.nextInt(6) + 1;
        System.out.println("HERE COMES THE DICE!");
        System.out.println("Roll #1: " + dice1Num);
        System.out.println("Roll #2: " + dice2Num);
        System.out.println("The total is " + (dice1Num + dice2Num) + "!");
    }
}
