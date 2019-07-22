package com.company.videogamestore.dao;

import com.company.videogamestore.model.Game;

import java.util.List;

/**
 * Interface for Game Module
 */
public interface GameDao {
    Game addGame(Game game);

    Game getGame(int gameId);

    List<Game> getAllGame();

    Game updateGame(Game game);

    int deleteGame(int gameId);

    List<Game> getGamesByStudio(String studio);

    List<Game> getGamesByRating(String esrbRating);

    List<Game> getGamesByTitle(String title);
}
