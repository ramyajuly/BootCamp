package com.company;


import java.util.Arrays;
import java.util.List;

/**
 * Print string elements using list
 */
public class WordList {
    public static void main(String[] args) {
        String[] wordList = {"byte", "case", "catch", "class", "const", "continue", "do", "double", "else", "extends"};
        List<String> wordArrayList = Arrays.asList(wordList);
        for (String element : wordArrayList) {
            System.out.println(element);
        }
    }
}
