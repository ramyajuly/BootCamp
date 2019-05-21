package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Program to Add at least 5 Classmate objects to the list.
 * Print out the name and hair color for every object in the list.
 */
public class Main {
    public static void main(String[] args) {
        List<Classmate> classmateList = new ArrayList<>();
        classmateList.add(new Classmate("Riya", "Black"));
        classmateList.add(new Classmate("Reena", "Brown"));
        classmateList.add(new Classmate("Priya", "Dark Black"));
        classmateList.add(new Classmate("Preena", "Dark Brown"));
        classmateList.add(new Classmate("Preeja", "Grey"));
        for (Classmate classmate : classmateList) {
            System.out.println("Name: " + classmate.getName() + " , Hair color: " + classmate.getHairColor());
        }
    }
}
