package com.company.videogamestore.dao;

import com.company.videogamestore.model.TShirt;

import java.util.List;

/**
 * Interface for TShirt Module
 */
public interface TShirtDao {
    TShirt addTShirt(TShirt tshirt);

    TShirt getTShirt(int tshirtId);

    List<TShirt> getAllTShirt();

    TShirt updateTShirt(TShirt tshirt);

    int deleteTShirt(int tshirtId);

    List<TShirt> getTShirtsByColor(String color);

    List<TShirt> getTShirtsBySize(String size);
}
