package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Program to do below actions:
 * When a user enters a non-integer value, display "Please enter a valid number."
 * When a user chooses a value not present in the array, display "Please choose an available pet."
 * If the file does not exist, display that information to the user.
 * If there was trouble writing the file, display that information.
 * Regardless of success or exceptions, tell the user to "Have a nice day!"
 */
public class Application {

    public static void main(String[] args) {
        boolean valid = true;
        int petIndex = 0;

        do {
            try {

                petIndex = Pets.choosePet();
                valid = false;

            } catch (NumberFormatException nfe) {
                valid = true;
                System.out.println("Please enter valid number: ");
            }

        }
        while (valid);

        try {
            String chosenPet = Pets.retrievePet(petIndex);
            System.out.println(chosenPet);
            Pets.readPetsFromFile();
            Pets.writePetToFile(chosenPet);

        } catch (
                ArrayIndexOutOfBoundsException aiob) {
            System.out.println("Please choose an available pet.");
        } catch (
                FileNotFoundException io) {
            System.out.println("Cannot locate file " + io.getMessage());
        } catch (
                IOException io) {
            System.out.println(io.getMessage());
        }
        finally {
            System.out.println("Have a Nice day!");
        }

    }


}


