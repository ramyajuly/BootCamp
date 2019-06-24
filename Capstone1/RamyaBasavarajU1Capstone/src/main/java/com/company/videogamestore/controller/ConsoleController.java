package com.company.videogamestore.controller;

import com.company.videogamestore.Exception.NotFoundException;
import com.company.videogamestore.service.ConsoleInventoryService;
import com.company.videogamestore.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for Console
 */
@RestController
@RequestMapping("/gamestore/consoles")
public class ConsoleController {
    @Autowired
    ConsoleInventoryService consoleInventoryService;

    /**
     * To add a new Console
     * @param console
     * @return ConsoleViewModel
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel addConsole(@RequestBody @Valid ConsoleViewModel console) {
        return consoleInventoryService.addConsole(console);
    }

    /**
     * To get a console
     * @param consoleId
     * @return ConsoleViewModel
     */
    @GetMapping("/{consoleId}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("consoleId")  int consoleId) {
        ConsoleViewModel consoleViewModel = consoleInventoryService.getConsole(consoleId);
        if(consoleViewModel == null){
            throw new NotFoundException("Console could not be retrieved for id " + consoleId);
        }
        return consoleViewModel;
    }

    /**
     * To get all consoles
     * @return List<ConsoleViewModel>
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoles() {
        return consoleInventoryService.getAllConsole();

    }

    /**
     * To delete a console
     * @param consoleId
     */
    @DeleteMapping("/{consoleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("consoleId") int consoleId) {
        consoleInventoryService.deleteConsole(consoleId);
    }

    /**
     * To update a console
     * @param consoleId
     * @param consoleViewModel
     */
    @PutMapping("/{consoleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("consoleId") int consoleId, @RequestBody @Valid ConsoleViewModel consoleViewModel) {
        if (consoleViewModel.getConsoleId() == 0)
            consoleViewModel.setConsoleId(consoleId);
        if (consoleId != consoleViewModel.getConsoleId()) {
            throw new IllegalArgumentException("Console ID on path must match the ID in the Console object");
        }
        consoleInventoryService.updateConsole(consoleViewModel);
    }

    /**
     * To get list of consoles based on manufacturer
     * @param manufacture
     * @return List<ConsoleViewModel>
     */
    @GetMapping("manufacture/{manufacture}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel>  getConsoleByManufacturers(@PathVariable("manufacture") String manufacture) {
        return consoleInventoryService.getConsolesByManufacturer(manufacture);

    }

}
