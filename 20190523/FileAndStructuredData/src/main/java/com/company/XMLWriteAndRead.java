package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class XMLWriteAndRead {
    /**
     * To write to xml file
     */
    public static void writeXML() {
        PrintWriter writer = null;
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));
        try {
            ObjectMapper mapper = new XmlMapper();
            String xmlCarList = mapper.writeValueAsString(carList);
            System.out.println(xmlCarList);
            writer = new PrintWriter(new FileWriter("car.xml"));
            writer.println(xmlCarList);
            System.out.println("Writing to XML File is successful");
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
     * To read from xml file
     */
    public static void readXML() {
        try {
            ObjectMapper mapper = new XmlMapper();
            List<Car> carList;
            carList = mapper.readValue(new File("car.xml"), new TypeReference<List<Car>>() {
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
