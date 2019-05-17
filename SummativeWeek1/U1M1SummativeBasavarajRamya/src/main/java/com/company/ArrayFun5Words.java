package com.company;

import java.util.Scanner;

/**
 * Program to get five words from user and prints on Screen
 */
public class ArrayFun5Words {
    public static void main(String[] args) {
        String[] funWords = readFunWords();
        print(funWords);
    }

    /**
     * Read five fun words from user
     * @return
     */
    public static String[] readFunWords() {
        Scanner scanner = new Scanner(System.in);
        String[] funWords = new String[5];
        for (int index = 0; index < 5; index++) {
            System.out.println("Please enter your " + (index + 1) + " of 5 fun words:");
            funWords[index] = scanner.nextLine();
        }
        return funWords;
    }

    /**
     * Prints five words to screen
     * @param funWords
     */
    public static void print(String[] funWords) {
        System.out.println("Five fun words: ");
        for (String word : funWords) {
            System.out.print(word + " ");
        }
    }
}
