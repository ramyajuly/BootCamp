package com.company.videogamestore.service;

import com.company.videogamestore.dao.GameDao;
import com.company.videogamestore.model.Game;
import com.company.videogamestore.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for Game
 */
@Component
public class GameInventoryService {
    @Autowired
    GameDao gameDao;

    @Autowired
    public GameInventoryService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    /**
     * To add a game
     * @param gameViewModel
     * @return GameViewModel
     */
    public GameViewModel addGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setDescription(gameViewModel.getDescription());
        game.setQuantity(gameViewModel.getQuantity());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game = gameDao.addGame(game);
        gameViewModel.setGameId(game.getGameId());
        return gameViewModel;
    }

    /**
     * To get a game
     * @param gameId
     * @return GameViewModel
     */
    public GameViewModel getGame(int gameId) {

        Game game = gameDao.getGame(gameId);
        if (game != null) {
            GameViewModel gameViewModel = new GameViewModel();
            gameViewModel.setGameId(game.getGameId());
            gameViewModel.setTitle(game.getTitle());
            gameViewModel.setDescription(game.getDescription());
            gameViewModel.setQuantity(game.getQuantity());
            gameViewModel.setPrice(game.getPrice());
            gameViewModel.setStudio(game.getStudio());
            gameViewModel.setEsrbRating(game.getEsrbRating());
            return gameViewModel;
        } else
            return null;

    }

    /**
     * To get all games
     * @return List<GameViewModel>
     */
    public List<GameViewModel> getAllGame() {
        GameViewModel gameViewModel;
        List<GameViewModel> gameViewModelList = new ArrayList<>();
        List<Game> gameList = new ArrayList<>();
        gameList = gameDao.getAllGame();
        if (gameList != null) {
            for (Game game : gameList) {
                gameViewModel = new GameViewModel();
                gameViewModel.setGameId(game.getGameId());
                gameViewModel.setTitle(game.getTitle());
                gameViewModel.setDescription(game.getDescription());
                gameViewModel.setQuantity(game.getQuantity());
                gameViewModel.setPrice(game.getPrice());
                gameViewModel.setStudio(game.getStudio());
                gameViewModel.setEsrbRating(game.getEsrbRating());
                gameViewModelList.add(gameViewModel);
            }
        }
        return gameViewModelList;

    }

    /**
     * To update a existing game
     * @param gameViewModel
     * @return GameViewModel
     */
    public GameViewModel updateGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setGameId(gameViewModel.getGameId());
        game.setTitle(gameViewModel.getTitle());
        game.setDescription(gameViewModel.getDescription());
        game.setQuantity(gameViewModel.getQuantity());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        gameDao.updateGame(game);
        return gameViewModel;
    }

    /**
     * To delete a game
     * @param gameId
     * @return int
     */
    public int deleteGame(int gameId) {
        return gameDao.deleteGame(gameId);

    }

    /**
     * To get games by studio
     * @param studio
     * @return List<GameViewModel>
     */
    public List<GameViewModel> getGamesByStudio(String studio) {
        GameViewModel gameViewModel;
        List<GameViewModel> gameViewModelList = new ArrayList<>();
        List<Game> gameList = new ArrayList<>();
        gameList = gameDao.getGamesByStudio(studio);
        if (gameList != null) {
            for (Game game : gameList) {
                gameViewModel = new GameViewModel();
                gameViewModel.setGameId(game.getGameId());
                gameViewModel.setTitle(game.getTitle());
                gameViewModel.setDescription(game.getDescription());
                gameViewModel.setQuantity(game.getQuantity());
                gameViewModel.setPrice(game.getPrice());
                gameViewModel.setStudio(game.getStudio());
                gameViewModel.setEsrbRating(game.getEsrbRating());
                gameViewModelList.add(gameViewModel);
            }
        }
        return gameViewModelList;

    }

    /**
     * To get games by rating
     * @param esrbRating
     * @return List<GameViewModel>
     */
    public List<GameViewModel> getGamesByRating(String esrbRating) {
        GameViewModel gameViewModel;
        List<GameViewModel> gameViewModelList = new ArrayList<>();
        List<Game> gameList = new ArrayList<>();
        gameList = gameDao.getGamesByRating(esrbRating);
        if (gameList != null) {
            for (Game game : gameList) {
                gameViewModel = new GameViewModel();
                gameViewModel.setGameId(game.getGameId());
                gameViewModel.setTitle(game.getTitle());
                gameViewModel.setDescription(game.getDescription());
                gameViewModel.setQuantity(game.getQuantity());
                gameViewModel.setPrice(game.getPrice());
                gameViewModel.setStudio(game.getStudio());
                gameViewModel.setEsrbRating(game.getEsrbRating());
                gameViewModelList.add(gameViewModel);
            }
        }
        return gameViewModelList;



    }

    /**
     * To get games by title
     * @param title
     * @return List<GameViewModel>
     */
    public List<GameViewModel> getGamesByTitle(String title) {
        GameViewModel gameViewModel;
        List<GameViewModel> gameViewModelList = new ArrayList<>();
        List<Game> gameList = new ArrayList<>();
        gameList = gameDao.getGamesByTitle(title);
        if (gameList != null) {
            for (Game game : gameList) {
                gameViewModel = new GameViewModel();
                gameViewModel.setGameId(game.getGameId());
                gameViewModel.setTitle(game.getTitle());
                gameViewModel.setDescription(game.getDescription());
                gameViewModel.setQuantity(game.getQuantity());
                gameViewModel.setPrice(game.getPrice());
                gameViewModel.setStudio(game.getStudio());
                gameViewModel.setEsrbRating(game.getEsrbRating());
                gameViewModelList.add(gameViewModel);
            }
        }
        return gameViewModelList;

    }
}
