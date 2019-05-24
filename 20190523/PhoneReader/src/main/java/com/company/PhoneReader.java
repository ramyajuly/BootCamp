package com.company;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PhoneReader {
    public static void readXML() {
        try {
            ObjectMapper mapper = new XmlMapper();
            List<Phone> phoneList;
            phoneList = mapper.readValue(new File("phones.xml"), new TypeReference<List<Phone>>() {
            });
            for (Phone car : phoneList) {
                System.out.println("================");
                System.out.println(car.getBrand());
                System.out.println(car.getModel());
                System.out.println(car.getProcessor());
                System.out.println(car.getStorage());
                System.out.println(car.getPrice());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
