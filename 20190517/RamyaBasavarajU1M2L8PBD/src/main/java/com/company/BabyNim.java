package com.company;

import java.util.Scanner;

/**
 * program that starts with three "piles" of 3 counters each. player choose piles and removes counters until all the piles are empty.
 * Game start by placing counters (coins or toothpicks or something) into 3 piles.
 * The player picks a pile, then removes one or more counters from that pile. (It's okay to take the whole pile.)
 * The player picks a new pile, then removes one or more counters from that pile. (It's okay to pick the same pile as before.)
 * Once all piles are empty, the game stops.
 * <p>
 * Does not check for errors like a wrong pile name,
 * or if someone tries to take more counters from the pile than the pile has
 */
public class BabyNim {
    private static int pileCount = 3;
    private static int pileA = pileCount;
    private static int pileB = pileCount;
    private static int pileC = pileCount;
    private static String pile_A = "A";
    private static String pile_B = "B";
    private static String pile_C = "C";

    public static void main(String[] args) {
        countingPiles();
    }

    /**
     * To decrement pile number
     */
    public static void countingPiles() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        String pileName = "";
        int pileNumber = 0;
        System.out.println(pile_A + ":" + pileA + "  " + pile_B + ":" + pileB + "  " + pile_C + ":" + pileC);
        do {
            valid = validatePiles(pileA, pileB, pileC);
            if (!valid) {
                System.out.println("Choose a pile: ");
                pileName = scanner.nextLine();
                System.out.println("How many to remove from pile " + pileName + ": ");
                pileNumber = Integer.parseInt(scanner.nextLine());
                if (pileName.equals(pile_A)) {
                    pileA = pileA - pileNumber;
                } else if (pileName.equals(pile_B)) {
                    pileB = pileB - pileNumber;
                } else if (pileName.equals(pile_C)) {
                    pileC = pileC - pileNumber;
                }
                System.out.println(pile_A + ":" + pileA + "  " + pile_B + ":" + pileB + "  " + pile_C + ":" + pileC);
            } else {
                System.out.println("All piles are empty. Good job!");
            }
        } while (!valid);
    }

    /**
     * To validate pile number is less than or equal to zero
     *
     * @param a
     * @param b
     * @param c
     * @return boolean
     */
    public static boolean validatePiles(int a, int b, int c) {
        boolean pilesValid = false;
        if (a <= 0 && b <= 0 && c <= 0) {
            pilesValid = true;
        }
        return pilesValid;
    }

}