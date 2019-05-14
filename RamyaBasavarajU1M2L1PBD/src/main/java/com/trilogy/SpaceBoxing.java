package com.trilogy;

import java.util.Scanner;

/**
 * Program to compute weight on the destination planet based on the table below
 * <p>
 * Planet	Relative gravity
 * 1	Venus	0.78
 * 2	Mars	0.39
 * 3	Jupiter	2.65
 * 4	Saturn	1.17
 * 5	Uranus	1.05
 * 6	Neptune	1.23
 */
public class SpaceBoxing {
    public static void main(String[] args) {
        int weight;
        double boxerWeight;
        int planetNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your current earth weight: ");
        weight = Integer.parseInt(scanner.nextLine());
        System.out.println("I have information for the following planets:");
        System.out.println("1. Venus   2. Mars    3. Jupiter");
        System.out.println("4. Saturn  5. Uranus  6. Neptune");
        System.out.println("Which planet are you visiting?");
        planetNumber = Integer.parseInt(scanner.nextLine());
        boxerWeight = calculateWeight(weight, planetNumber);
        System.out.println("Your weight would be " + boxerWeight + " pounds on that planet.");
    }

    /**
     * calculates weight
     *
     * @param weight
     * @param planetNum
     * @return
     */
    public static double calculateWeight(int weight, int planetNum) {

        return weight * gravityForPlanet(planetNum);
    }

    /**
     * returns gravity for the planet
     *
     * @param planetNum
     * @return
     */
    public static double gravityForPlanet(int planetNum) {
        double gravity;
        switch (planetNum) {
            case 1:
                gravity = 0.78;
                break;
            case 2:
                gravity = 0.39;
                break;
            case 3:
                gravity = 2.65;
                break;
            case 4:
                gravity = 1.17;
                break;
            case 5:
                gravity = 1.05;
                break;
            case 6:
                gravity = 1.23;
                break;
            default:
                gravity = 0.0;
                break;
        }
        return gravity;
    }

}
