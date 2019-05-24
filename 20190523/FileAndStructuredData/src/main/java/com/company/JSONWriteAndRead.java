package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONWriteAndRead {
    /**
     * Write to json file
     */
    public static void writeJSON() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));
        PrintWriter writer = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonCarList = mapper.writeValueAsString(carList);
            System.out.println(jsonCarList);
            writer = new PrintWriter(new FileWriter("car.json"));
            writer.println(jsonCarList);
            System.out.println("Writing to JSON File is successful");
            System.out.println("------------------------------------------");

        } catch (JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }

    /**
     * Read json file print data
     */
    public static void readJSON() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Car> carList;
            carList = mapper.readValue(new File("car.json"), new TypeReference<List<Car>>() {
            });
            for (Car car : carList) {
                System.out.println("================");
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getYear());
                System.out.println(car.getColor());
            }
        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
