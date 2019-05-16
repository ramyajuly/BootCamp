package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {
    Scanner scanner = new Scanner(System.in);
    private int userInt;
    private long userLong;
    private double userDouble;
    private float userFloat;
    private String userString;

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        userInt = Integer.parseInt(scanner.nextLine());
        return userInt;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        userLong = Long.parseLong(scanner.nextLine());
        return userLong;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        userDouble = Double.parseDouble(scanner.nextLine());
        return userDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        userFloat = Float.parseFloat(scanner.nextLine());
        return userFloat;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        userString = scanner.nextLine();
        return userString;
    }
}
