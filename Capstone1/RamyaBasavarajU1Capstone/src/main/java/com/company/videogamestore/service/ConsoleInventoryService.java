package com.company.videogamestore.service;

import com.company.videogamestore.dao.ConsoleDao;
import com.company.videogamestore.model.Console;
import com.company.videogamestore.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for Console
 */
@Component
public class ConsoleInventoryService {
    @Autowired
    ConsoleDao consoleDao;

    @Autowired
    public ConsoleInventoryService(ConsoleDao consoleDao) {
        this.consoleDao = consoleDao;
    }

    /**
     * To add a new Console
     * @param consoleViewModel
     * @return ConsoleViewModel
     */
    public ConsoleViewModel addConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());
        console = consoleDao.addConsole(console);
        consoleViewModel.setConsoleId(console.getConsoleId());
        return consoleViewModel;
    }

    /**
     * To get a Console
     * @param consoleId
     * @return ConsoleViewModel
     */
    public ConsoleViewModel getConsole(int consoleId) {
        Console console = consoleDao.getConsole(consoleId);
        if (console != null) {
            ConsoleViewModel consoleViewModel = new ConsoleViewModel();
            consoleViewModel.setConsoleId(console.getConsoleId());
            consoleViewModel.setModel(console.getModel());
            consoleViewModel.setManufacturer(console.getManufacturer());
            consoleViewModel.setMemoryAmount(console.getMemoryAmount());
            consoleViewModel.setProcessor(console.getProcessor());
            consoleViewModel.setPrice(console.getPrice());
            consoleViewModel.setQuantity(console.getQuantity());
            return consoleViewModel;
        } else
            return null;
    }

    /**
     * To get all consoles
     * @return
     */
    public List<ConsoleViewModel> getAllConsole() {
        ConsoleViewModel consoleViewModel;
        List<ConsoleViewModel> consoleViewModelList = new ArrayList<>();
        List<Console> consoleList = new ArrayList<>();
        consoleList = consoleDao.getAllConsole();
        if (consoleList != null) {
            for (Console console : consoleList) {
                consoleViewModel = new ConsoleViewModel();
                consoleViewModel.setConsoleId(console.getConsoleId());
                consoleViewModel.setModel(console.getModel());
                consoleViewModel.setManufacturer(console.getManufacturer());
                consoleViewModel.setMemoryAmount(console.getMemoryAmount());
                consoleViewModel.setProcessor(console.getProcessor());
                consoleViewModel.setPrice(console.getPrice());
                consoleViewModel.setQuantity(console.getQuantity());
                consoleViewModelList.add(consoleViewModel);
            }
        }
        return consoleViewModelList;

    }

    /**
     * To update a single console
     * @param consoleViewModel
     * @return ConsoleViewModel
     */
    public ConsoleViewModel updateConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setConsoleId(consoleViewModel.getConsoleId());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());
        console = consoleDao.updateConsole(console);
        return consoleViewModel;

    }

    /**
     * To delete a console
     * @param consoleId
     * @return
     */
    public int deleteConsole(int consoleId) {
        return consoleDao.deleteConsole(consoleId);


    }

    /**
     * To get all consoles based on manufacturer
     * @param manufacture
     * @return
     */
    public List<ConsoleViewModel> getConsolesByManufacturer(String manufacture) {
        ConsoleViewModel consoleViewModel;
        List<ConsoleViewModel> consoleViewModelList = new ArrayList<>();
        List<Console> consoleList = new ArrayList<>();
        consoleList = consoleDao.getConsolesByManufacturer(manufacture);
        if (consoleList != null) {
            for (Console console : consoleList) {
                consoleViewModel = new ConsoleViewModel();
                consoleViewModel.setConsoleId(console.getConsoleId());
                consoleViewModel.setModel(console.getModel());
                consoleViewModel.setManufacturer(console.getManufacturer());
                consoleViewModel.setMemoryAmount(console.getMemoryAmount());
                consoleViewModel.setProcessor(console.getProcessor());
                consoleViewModel.setPrice(console.getPrice());
                consoleViewModel.setQuantity(console.getQuantity());
                consoleViewModelList.add(consoleViewModel);
            }
        }
        return consoleViewModelList;
    }

}
