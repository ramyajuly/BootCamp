package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Print string using Linked list
 */
public class WordListLinkedList {
    public static void main(String[] args) {
        List<String> wordLinkedList = new LinkedList<>();
        wordLinkedList.add("byte");
        wordLinkedList.add("case");
        wordLinkedList.add("catch");
        wordLinkedList.add("class");
        wordLinkedList.add("const");
        wordLinkedList.add("continue");
        wordLinkedList.add("do");
        wordLinkedList.add("double");
        wordLinkedList.add("else");
        wordLinkedList.add("extends");
        for (String element : wordLinkedList) {
            System.out.println(element);
        }
    }
}
