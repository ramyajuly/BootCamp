package com.company;
import com.company.interfaces.UserIO;
import java.util.Scanner;

public class BetterInput implements UserIO{
    Scanner scanner = new Scanner(System.in);
    private int userInt;
    private long userLong;
    private double userDouble;
    private float userFloat;
    private String userString;

    @Override
    public int readInt(String prompt) {
        try{
            System.out.println(prompt);
            userInt  = Integer.parseInt(scanner.nextLine());
        }
        catch (Exception e){
            readInt("User input not Valid, Please Enter a Integer: ");
        }
        return userInt;
    }

    @Override
    public long readLong(String prompt) {
        try{
            System.out.println(prompt);
            userLong  = Long.parseLong(scanner.nextLine());
        }
        catch (Exception e){
            readLong("User input not Valid, Please Enter a long: ");
        }
        return userLong;
    }

    @Override
    public double readDouble(String prompt) {
        try{
            System.out.println(prompt);
            userDouble  = Double.parseDouble(scanner.nextLine());
        }
        catch (Exception e){
            readDouble("User input not Valid, Please Enter a double: ");
        }
        return userDouble;
    }

    @Override
    public float readFloat(String prompt) {
        try{
            System.out.println(prompt);
            userFloat  = Float.parseFloat(scanner.nextLine());
        }
        catch (Exception e){
            readFloat("User input not Valid, Please Enter a float: ");
        }

        return userFloat;
    }

    @Override
    public String readString(String prompt) {
        try{
            System.out.println(prompt);
            userString  = scanner.nextLine();
        }
        catch (Exception e){
            readFloat("User input not Valid, Please Enter a String: ");
        }
        return userString;
    }
}
