package com.company;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVWriteAndRead {
    public static void readCSV() {
        try {
            List<Car> carList = new ArrayList<>();
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("car.csv")));
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
                Car currentCar = new Car();
                currentCar.setColor(currentCells[0]);
                currentCar.setMake(currentCells[1]);
                currentCar.setModel(currentCells[2]);
                currentCar.setYear(Integer.parseInt(currentCells[3]));
                carList.add(currentCar);
            }

            // Display all Car info
            for (Car car : carList) {
                System.out.println("=================================");
                System.out.println(car.getYear());
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getColor());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Oops - I couldn't find your file: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: It seems your CSV file is malformed. Perhaps some of your rows have too many columns??? ");
        } catch (NumberFormatException e) {
            System.out.println("ERROR: it seems you CSV data is corrupted. Could not conver to number: " + e.getMessage());
        }


    }

    public static void writeCSV() {
        try {
            List<Car> carList = new ArrayList<>();
            carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
            carList.add(new Car(2001, "Honda", "Civic", "Silver"));
            carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
            carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
            carList.add(new Car(1964, "Ford", "Mustang", "Red"));
            Writer writer = new FileWriter("car.csv");
            CSVWriter csvWriter = new CSVWriter(writer,',',Character.MIN_VALUE,Character.MIN_VALUE,System.lineSeparator());
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(csvWriter).build();
            beanToCsv.write(carList);
            writer.close();
            System.out.println("Writing to CSV File is successful");
            System.out.println("------------------------------------------");
        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("ERROR: Something went wrong writing CSV file: " + e.getMessage());
        }





    }
}
