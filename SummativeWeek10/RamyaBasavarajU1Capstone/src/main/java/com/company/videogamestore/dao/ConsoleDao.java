package com.company.videogamestore.dao;

import com.company.videogamestore.model.Console;


import java.util.List;

/**
 * Interface for Console module
 */
public interface ConsoleDao {
    Console addConsole(Console console);

    Console getConsole(int consoleId);

    List<Console> getAllConsole();

    Console updateConsole(Console console);

    int deleteConsole(int consoleId);

    List<Console> getConsolesByManufacturer(String manufacture);

}
