package com.company.videogamestore.service;


import com.company.videogamestore.dao.GameDao;

import com.company.videogamestore.model.Game;
import com.company.videogamestore.viewmodel.GameViewModel;
import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;
/**
 * Unit test for Game Service using mock
 */
public class GameInventoryServiceTest {
    GameInventoryService gameInventoryService;
    GameDao gameDao;

    /**
     * TO set up before running tests
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        setUpGameDaoMock();
        gameInventoryService = new GameInventoryService(gameDao);
    }

    /**
     * Test to add a new game
     */
    @Test
    public void addGame() {
        GameViewModel actualGame = new GameViewModel();
        actualGame.setTitle("LEGO Arthouse");
        actualGame.setEsrbRating("E");
        actualGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        actualGame.setPrice(new BigDecimal("100.00"));
        actualGame.setStudio("Copenhagen");
        actualGame.setQuantity(1);
        actualGame = gameInventoryService.addGame(actualGame);
        GameViewModel expectedGame = gameInventoryService.getGame(actualGame.getGameId());
        assertEquals(expectedGame, actualGame);
    }

    /**
     * Test to get all games
     */
    @Test
    public void getAllGame() {
        List<GameViewModel> actualGameLst = new ArrayList<>();
        List<GameViewModel> expectedGameLst = new ArrayList<>();

        GameViewModel expectedGame = new GameViewModel();
        expectedGame.setGameId(6);
        expectedGame.setTitle("LEGO Arthouse");
        expectedGame.setEsrbRating("E");
        expectedGame.setDescription("expression of the value of creativity");
        expectedGame.setPrice(new BigDecimal("100.00"));
        expectedGame.setStudio("Copenhagen");
        expectedGame.setQuantity(1);
        expectedGameLst.add(expectedGame);

        expectedGame = new GameViewModel();
        expectedGame.setGameId(9);
        expectedGame.setTitle("LEGO Brawls");
        expectedGame.setEsrbRating("E");
        expectedGame.setDescription(" battle royale games");
        expectedGame.setPrice(new BigDecimal("150.00"));
        expectedGame.setStudio("Copenhagen");
        expectedGame.setQuantity(1);
        expectedGameLst.add(expectedGame);

        actualGameLst = gameInventoryService.getAllGame();
        assertEquals(expectedGameLst.size(), actualGameLst.size());
    }

    /**
     * To get a game
     */
    @Test
    public void getGame() {
        GameViewModel expectedGame = new GameViewModel();
        expectedGame.setGameId(6);
        expectedGame.setTitle("LEGO Arthouse");
        expectedGame.setEsrbRating("E");
        expectedGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        expectedGame.setPrice(new BigDecimal("100.00"));
        expectedGame.setStudio("Copenhagen");
        expectedGame.setQuantity(1);
        GameViewModel actualGame= gameInventoryService.getGame(6);
        assertEquals(expectedGame, actualGame);
    }

    /**
     * To update a game
     */
    @Test
    public void updateGame() {
        GameViewModel actualGame = new GameViewModel();
        actualGame.setGameId(6);
        actualGame.setTitle("LEGO Arthouse");
        actualGame.setEsrbRating("E");
        actualGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        actualGame.setPrice(new BigDecimal("100.00"));
        actualGame.setStudio("Copenhagen");
        actualGame.setQuantity(1);
        actualGame = gameInventoryService.updateGame(actualGame);

        GameViewModel expectedGame = new GameViewModel();
        expectedGame.setGameId(6);
        expectedGame.setTitle("LEGO Arthouse");
        expectedGame.setEsrbRating("E");
        expectedGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        expectedGame.setPrice(new BigDecimal("100.00"));
        expectedGame.setStudio("Copenhagen");
        expectedGame.setQuantity(1);
        assertEquals(expectedGame, actualGame);
    }

    /**
     * To test for deleting a game
     */
    @Test
    public void deleteGame() {
       int deleted = gameInventoryService.deleteGame(9);
       assertEquals(1,deleted);
    }

    /***
     * To test to filter game by studio
     */
    @Test
    public void getGamesByStudio() {
        List<GameViewModel> expectedGameLst = new ArrayList<>();
        GameViewModel expectedGame = new GameViewModel();
        expectedGame.setGameId(6);
        expectedGame.setTitle("LEGO Arthouse");
        expectedGame.setEsrbRating("E");
        expectedGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        expectedGame.setPrice(new BigDecimal("100.00"));
        expectedGame.setStudio("Copenhagen");
        expectedGame.setQuantity(1);
        expectedGameLst.add(expectedGame);
        List<GameViewModel> actualGameLst = gameInventoryService.getGamesByStudio("Copenhagen");
        assertEquals(expectedGameLst.size(),actualGameLst.size());
    }

    /***
     * To test to filter game by ESRB Rating
     */
    @Test
    public void getGamesByEsrb() {
        List<GameViewModel> expectedGameLst = new ArrayList<>();
        GameViewModel expectedGame = new GameViewModel();
        expectedGame.setGameId(6);
        expectedGame.setTitle("LEGO Arthouse");
        expectedGame.setEsrbRating("E");
        expectedGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        expectedGame.setPrice(new BigDecimal("100.00"));
        expectedGame.setStudio("Copenhagen");
        expectedGame.setQuantity(1);
        expectedGameLst.add(expectedGame);
        List<GameViewModel> actualGameLst = gameInventoryService.getGamesByRating("E");
        assertEquals(expectedGameLst.size(),actualGameLst.size());
    }

    /***
     * To test to filter game by Title
     */
    @Test
    public void getGamesByTitle() {
        List<GameViewModel> expectedGameLst = new ArrayList<>();
        GameViewModel expectedGame = new GameViewModel();
        expectedGame.setGameId(6);
        expectedGame.setTitle("LEGO Arthouse");
        expectedGame.setEsrbRating("E");
        expectedGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        expectedGame.setPrice(new BigDecimal("100.00"));
        expectedGame.setStudio("Copenhagen");
        expectedGame.setQuantity(1);
        expectedGameLst.add(expectedGame);
        List<GameViewModel> actualGameLst = gameInventoryService.getGamesByTitle("LEGO Arthouse");
        assertEquals(expectedGameLst.size(),actualGameLst.size());
    }

    /**
     * Helper Method
     */
    public void setUpGameDaoMock() {
        gameDao = mock(GameDao.class);

        //---- GAME To BE SAVED
        Game gameToBeSaved = new Game();
        gameToBeSaved.setTitle("LEGO Arthouse");
        gameToBeSaved.setEsrbRating("E");
        gameToBeSaved.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        gameToBeSaved.setPrice(new BigDecimal("100.00"));
        gameToBeSaved.setStudio("Copenhagen");
        gameToBeSaved.setQuantity(1);

        //---- GAME AFTER SAVE
        Game gameAfterSaved = new Game();
        gameAfterSaved.setGameId(6);
        gameAfterSaved.setTitle("LEGO Arthouse");
        gameAfterSaved.setEsrbRating("E");
        gameAfterSaved.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        gameAfterSaved.setPrice(new BigDecimal("100.00"));
        gameAfterSaved.setStudio("Copenhagen");
        gameAfterSaved.setQuantity(1);

        //--GAMES TO BE ADDED TO LIST
        Game gameAfterSaved1 = new Game();
        gameAfterSaved1.setGameId(9);
        gameAfterSaved1.setTitle("LEGO Brawls");
        gameAfterSaved1.setEsrbRating("E");
        gameAfterSaved1.setDescription(" battle royale games");
        gameAfterSaved1.setPrice(new BigDecimal("150.00"));
        gameAfterSaved1.setStudio("Copenhagen");
        gameAfterSaved1.setQuantity(1);

        List<Game> lstGame = new ArrayList<>();
        lstGame.add(gameAfterSaved);
        lstGame.add(gameAfterSaved1);

        //----ADD GAME TO LIST BY STUDIO
        List<Game> lstGameByStudio = new ArrayList<>();
        lstGameByStudio.add(gameAfterSaved);

        //----ADD GAME TO LIST BY ESRB Rating
        List<Game> lstGameByESRB = new ArrayList<>();
        lstGameByESRB.add(gameAfterSaved);

        //-----ADD GAME TO LIST BY Title
        List<Game> lstGameByTitle = new ArrayList<>();
        lstGameByTitle.add(gameAfterSaved);

        doReturn(gameAfterSaved).when(gameDao).addGame(gameToBeSaved);
        doReturn(gameAfterSaved).when(gameDao).getGame(6);
        doReturn(lstGame).when(gameDao).getAllGame();
        doReturn(gameAfterSaved).when(gameDao).updateGame(gameAfterSaved);
        doReturn(1).when(gameDao).deleteGame(9);
        doReturn(lstGameByStudio).when(gameDao).getGamesByStudio("Copenhagen");
        doReturn(lstGameByESRB).when(gameDao).getGamesByRating("E");
        doReturn(lstGameByTitle).when(gameDao).getGamesByTitle("LEGO Arthouse");
    }
}
