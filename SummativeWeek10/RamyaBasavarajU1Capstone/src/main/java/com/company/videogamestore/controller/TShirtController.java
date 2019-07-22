package com.company.videogamestore.controller;

import com.company.videogamestore.Exception.NotFoundException;
import com.company.videogamestore.service.TShirtInventoryService;
import com.company.videogamestore.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Rest controller for Tshirts
 */
@RestController
@RequestMapping("/gamestore/tshirts")
public class TShirtController {
    @Autowired
    TShirtInventoryService tShirtInventoryService;

    /**
     * To add a new Tshirt
     * @param tShirtViewModel
     * @return TShirtViewModel
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel addTshirt(@RequestBody @Valid TShirtViewModel tShirtViewModel) {
        return tShirtInventoryService.addTShirt(tShirtViewModel);

    }

    /**
     * To get a Tshirt
     * @param tShirtId
     * @return TShirtViewModel
     */
    @GetMapping("/{tShirtId}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable("tShirtId") int tShirtId) {
        TShirtViewModel tShirtViewModel = tShirtInventoryService.getTShirt(tShirtId);
        if (tShirtViewModel == null) {
            throw new NotFoundException("TShirt could not be retrieved for id " + tShirtId);
        }
        return tShirtViewModel;
    }

    /**
     * To get all Tshirts
     * @return List<TShirtViewModel>
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getAllGames() {
        return tShirtInventoryService.getAllTShirt();

    }

    /**
     * To delete a Tshirt
     * @param tShirtId
     */
    @DeleteMapping("/{tShirtId}")//Another way to set the Rest API Delete mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable("tShirtId") int tShirtId) {
        tShirtInventoryService.deleteTShirt(tShirtId);
    }

    /**
     * To update a Tshirt
     * @param tShirtId
     * @param tShirtViewModel
     */
    @PutMapping("/{tShirtId}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@PathVariable("tShirtId") int tShirtId, @RequestBody @Valid TShirtViewModel tShirtViewModel) {
        if (tShirtViewModel.gettShirtId() == 0)
            tShirtViewModel.settShirtId(tShirtId);
        if (tShirtId != tShirtViewModel.gettShirtId()) {
            throw new IllegalArgumentException("Game ID on path must match the ID in the Game object");
        }
        tShirtInventoryService.updateTShirt(tShirtViewModel);

    }

    /**
     * To get Tshirts based on size
     * @param size
     * @return List<TShirtViewModel>
     */
    @GetMapping("/size/{size}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsBySize(@PathVariable("size") String size) {
        return tShirtInventoryService.getTShirtsBySize(size);

    }
    /**
     * To get Tshirts based on color
     * @param color
     * @return List<TShirtViewModel>
     */
    @GetMapping("/color/{color}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsByColor(@PathVariable("color") String color) {
        return tShirtInventoryService.getTShirtsByColor(color);

    }
}
