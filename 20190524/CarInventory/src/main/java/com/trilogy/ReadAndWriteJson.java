package com.trilogy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteJson {

    public static List<Car> readJson() {
        List<Car> lstCar = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            lstCar = mapper.readValue(new File("car.json"), new TypeReference<List<Car>>() {
            });

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
        return lstCar;

    }

    public static List<Car> writeJson(List<Car> carList) {
        //List<Car> carList;
        if (MainMenu.carData == false) {
            carList = new ArrayList<>();
            Car carAdd = new Car("Nissan", "Altima", 2012, "White", 400, 1);
            carList.add(carAdd);
            carAdd = new Car("Honda", "Accord", 2016, "Black", 566.8, 2);
            carList.add(carAdd);
            carAdd = new Car("Toyota", "Camry", 2017, "Blue", 577.9, 3);
            carList.add(carAdd);
            MainMenu.carData = true;
        }
        PrintWriter writer = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonCarList = mapper.writeValueAsString(carList);
            // System.out.println(jsonCarList);
            writer = new PrintWriter(new FileWriter("car.json"));
            writer.println(jsonCarList);
           // System.out.println("Writing to JSON File is successful");
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
        return carList;
    }


}
