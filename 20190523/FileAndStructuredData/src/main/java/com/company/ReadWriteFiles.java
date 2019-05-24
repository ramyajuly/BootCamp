package com.company;

/**
 * program to read and write different files:
 */
public class ReadWriteFiles {
    public static void main(String[] args) {
        System.out.println("WRITING TO CSV FILE");
        CSVWriteAndRead.writeCSV();
        System.out.println("READING FROM CSV FILE");
       CSVWriteAndRead.readCSV();
        System.out.println("WRITING TO JSON FILE");
       JSONWriteAndRead.writeJSON();
        System.out.println("READING FROM JSON FILE");
       JSONWriteAndRead.readJSON();
        System.out.println("WRITING TO XML FILE");
        XMLWriteAndRead.writeXML();
        System.out.println("READING FROM XML FILE");
        XMLWriteAndRead.readXML();
    }
}
