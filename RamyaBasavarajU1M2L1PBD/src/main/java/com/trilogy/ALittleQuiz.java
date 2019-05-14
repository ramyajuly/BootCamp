package com.trilogy;

import java.util.Scanner;

/**
 * Program  interactive quiz. It should ask the user three multiple-choice questions about something.
 * It must keep track of how many they get wrong, and print out a "score" at the end.
 */
public class ALittleQuiz {
    public static void main(String[] args) {
        int score;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you ready for a quiz?");
        scanner.nextLine();
        System.out.println("Okay, here it comes!");
        score = quiz();
        System.out.println("Overall, you got " + score + " out of 3 correct.");
        System.out.println("Thanks for playing!");
    }

    /**
     * To count the correct answer
     *
     * @return
     */
    public static int quiz() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        int score = 0;
        System.out.println("Q1) What is the capital of Alaska?");
        System.out.println("        1) Melbourne");
        System.out.println("        2) Anchorage");
        System.out.println("        3) Juneau");
        userInput = Integer.parseInt(scanner.nextLine());
        if (userInput == 3) {
            score++;
            System.out.println("That's right!");
        } else {
            System.out.println("Sorry, Juneau is the capital of Alaska.");
        }
        System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?");
        System.out.println("            1) yes");
        System.out.println("            2) no");
        userInput = Integer.parseInt(scanner.nextLine());
        if (userInput == 2) {
            score++;
            System.out.println("That's right!");
        } else {
            System.out.println("Sorry, \"cat\" is a string. ints can only store numbers.");
        }
        System.out.println("Q3) What is the result of 9+6/3?");
        System.out.println("            1) 5");
        System.out.println("            2) 11");
        System.out.println("            3) 15/3");
        userInput = Integer.parseInt(scanner.nextLine());
        if (userInput == 2) {
            score++;
            System.out.println("That's correct!");
        } else {
            System.out.println("Sorry, " + 11 + " is correct score.");
        }
        return score;

    }
}
