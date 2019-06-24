package com.company.videogamestore.controller;

import com.company.videogamestore.Exception.NotFoundException;
import com.company.videogamestore.service.GameInventoryService;
import com.company.videogamestore.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for game
 */
@RestController
@RequestMapping("/gamestore/games")
public class GameController {
    @Autowired
    GameInventoryService gameInventoryService;

    /**
     * To add a new game
     * @param gameViewModel
     * @return GameViewModel
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel addGame(@RequestBody @Valid GameViewModel gameViewModel) {
        return gameInventoryService.addGame(gameViewModel);

    }

    /**
     * To get a game
     * @param gameId
     * @return GameViewModel
     */
    @GetMapping("/{gameId}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("gameId") int gameId) {
        GameViewModel gameViewModel = gameInventoryService.getGame(gameId);
        if (gameViewModel == null) {
            throw new NotFoundException("Game could not be retrieved for id " + gameId);
        }
        return gameViewModel;
    }

    /**
     * To get all games
     * @return
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames() {
        return gameInventoryService.getAllGame();

    }

    /**
     * To delete a game
     * @param gameId
     */
    @DeleteMapping("/{gameId}")//Another way to set the Rest API Delete mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("gameId") int gameId) {
        gameInventoryService.deleteGame(gameId);
    }

    /**
     * To update a game
     * @param gameId
     * @param gameViewModel
     */
    @PutMapping("/{gameId}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable("gameId") int gameId, @RequestBody @Valid GameViewModel gameViewModel) {
        if (gameViewModel.getGameId() == 0)
            gameViewModel.setGameId(gameId);
        if (gameId != gameViewModel.getGameId()) {
            throw new IllegalArgumentException("Game ID on path must match the ID in the Game object");
        }
        gameInventoryService.updateGame(gameViewModel);

    }

    /**
     * To filter games by studio
     * @param studio
     * @return
     */
    @GetMapping("/studio/{studio}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio) {
        return gameInventoryService.getGamesByStudio(studio);

    }

    /**
     * To filter games by ESRBRating
     * @param esrbRating
     * @return
     */
    @GetMapping("rating/{esrbRating}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByRating(@PathVariable("esrbRating") String esrbRating) {
        return gameInventoryService.getGamesByRating(esrbRating);

    }

    /**
     *  To filter games by Title
     * @param title
     * @return
     */
    @GetMapping("title/{title}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable("title") String title) {
        return gameInventoryService.getGamesByTitle(title);

    }
}
