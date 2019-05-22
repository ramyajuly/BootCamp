package com.trilogy.streams;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AppJacksonRead {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Television> tvList;
            tvList = mapper.readValue(new File("television.json"), new TypeReference<List<Television>>() {
            });
            System.out.println("=================Television Screen size over 60================================");
            tvList
                    .stream()
                    .filter(b -> b.getScreenSize() > 60)
                    .forEach(tv -> {
                                System.out.println("Make: " + tv.getBrand());
                                System.out.println("Model: " + tv.getModel());
                                System.out.println("Color: " + tv.getPrice());
                                System.out.println("Color: " + tv.getScreenSize());
                                System.out.println("===============");
                            }
                    );
            Map<String, List<Television>> groubyBrandTV =
                    tvList
                            .stream()
                            .collect(Collectors.groupingBy(b -> b.getBrand()));

            Set<String> keys = groubyBrandTV.keySet();
            System.out.println("===========Grouping televisions on Brand=========");
            for (String key : keys) {
                System.out.println(key);
            }
            System.out.println("----------------------------------------------------");
            double avgScreenSize = tvList.stream().mapToDouble(b -> b.getScreenSize()).average().getAsDouble();
            System.out.format("Average Screen size %.2f", avgScreenSize);

            System.out.println("\n---------------------------------------------------");
            int largeScreen = tvList.stream().mapToInt(b -> b.getScreenSize()).max().getAsInt();
            System.out.println("Largest Screen size: " + largeScreen);

            System.out.println("-------------Sorting on TV screen size----------------------");
            List<Integer> tvScreenSize = new ArrayList<>();
            int i = 0;
            for (Television tv : tvList) {
                tvScreenSize.add(i, tv.getScreenSize());
                i++;
            }
            Collections.sort(tvScreenSize);
            System.out.println("ScreenSize: ");
            for (Integer iSize : tvScreenSize) {
                System.out.println(iSize);
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
