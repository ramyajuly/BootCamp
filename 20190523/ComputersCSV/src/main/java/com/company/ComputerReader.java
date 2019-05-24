package com.company;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerReader {
    public static void readCSV() {
        try {
            List<Computer> computerList = new ArrayList<>();
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("computers.csv")));
            String currentRow = "";
            String[] headings = new String[0];
            String[] currentCells = new String[0];

            //Heading
            if (scanner.hasNext()) {
                currentRow = scanner.nextLine();
                headings = currentRow.split(",");
                System.out.println("Number of columns: " + headings.length);
                for (String heading : headings) {
                    System.out.println(heading);
                }
            }

            // Now read each remaining row and convert into an object
            while (scanner.hasNext()) {
                currentRow = scanner.nextLine();
                currentCells = currentRow.split(",");
                Computer currentComputer = new Computer();
                currentComputer.setBrand(currentCells[0]);
                currentComputer.setModel(currentCells[1]);
                currentComputer.setCpu(currentCells[2]);
                currentComputer.setRam(currentCells[3]);
                currentComputer.setStorageSize(Integer.parseInt(currentCells[4]));
                computerList.add(currentComputer);
            }

            // Display all Car info
            for (Computer computer : computerList) {
                System.out.println("=================================");
                System.out.println(computer.getBrand());
                System.out.println(computer.getModel());
                System.out.println(computer.getCpu());
                System.out.println(computer.getRam());
                System.out.println(computer.getStorageSize());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Oops - I couldn't find your file: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: It seems your CSV file is malformed. Perhaps some of your rows have too many columns??? ");
        } catch (NumberFormatException e) {
            System.out.println("ERROR: it seems you CSV data is corrupted. Could not conver to number: " + e.getMessage());
        }


    }
}
