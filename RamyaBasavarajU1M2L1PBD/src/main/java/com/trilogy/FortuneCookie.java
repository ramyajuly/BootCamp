package com.trilogy;

import java.util.Random;

/**
 * Program that simulates a random fortune from a fortune cookie with least six fortunes.
 * It adds randomly-chosen lotto numbers to the fortune.
 * In Texas, the lotto chooses 6 numbers, each from 1-54.
 */
public class FortuneCookie {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        int randomNum;
        randomNum = randomGenerator.nextInt(6);
        System.out.println("fortune cookie says: " + getFortuneMessage(randomNum));
        int[] lottoNumbers = generateLottoNumbers();
        System.out.println(formatLottoNumbers(lottoNumbers));
    }

    /**
     * To get the fortune message
     *
     * @param randomNumber
     * @return
     */
    public static String getFortuneMessage(int randomNumber) {
        String[] fortunes = {"You will find happiness with a new love.",
                "Stick with your wife.", "Nice Day!", "Good Day!", "Happy Day!", "Peace Day!"};
        return fortunes[randomNumber];
    }

    /**
     * Generates lotto Numbers
     *
     * @return
     */
    public static int[] generateLottoNumbers() {
        Random randomGenerator = new Random();
        int[] lottoNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            lottoNumbers[i] = randomGenerator.nextInt(54) + 1;
        }
        return lottoNumbers;
    }

    /**
     * Formats the lottoNumbers
     *
     * @param lottoNumbers
     * @return
     */
    public static String formatLottoNumbers(int[] lottoNumbers) {
        return String.format("%02d - %02d - %02d - %02d - %02d - %02d", lottoNumbers[0], lottoNumbers[1], lottoNumbers[2], lottoNumbers[3], lottoNumbers[4], lottoNumbers[5]);
    }
}

