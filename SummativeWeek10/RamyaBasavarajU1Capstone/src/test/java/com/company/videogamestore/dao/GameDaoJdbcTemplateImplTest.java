package com.company.videogamestore.dao;

import com.company.videogamestore.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Game Integration testing with Database
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoJdbcTemplateImplTest {
    @Autowired
    GameDao gameDao;

    /**
     * To delete all the records of Games in database
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        List<Game> gameList = gameDao.getAllGame();
        for (Game game : gameList) {
            gameDao.deleteGame(game.getGameId());
        }
    }

    /**
     * To test for adding a new game, to get a game and to delete a game
     */
    @Test
    public void addGetDeleteGame() {
        Game actualGame = new Game();
        actualGame.setTitle("LEGO Arthouse");
        actualGame.setEsrbRating("E");
        actualGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        actualGame.setPrice(new BigDecimal("100.00"));
        actualGame.setStudio("Copenhagen");
        actualGame.setQuantity(1);
        actualGame = gameDao.addGame(actualGame);
        Game expectedGame = gameDao.getGame(actualGame.getGameId());
        assertEquals(expectedGame, actualGame);

        int deleted = gameDao.deleteGame(actualGame.getGameId());
        assertEquals(1, deleted);
    }

    /**
     * Test to get all games
     */
    @Test
    public void getAllGames() {

        List<Game> actualGameLst = new ArrayList<>();
        List<Game> expectedGameLst = new ArrayList<>();

        Game actualGame = new Game();

        actualGame.setTitle("LEGO Arthouse");
        actualGame.setEsrbRating("E");
        actualGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        actualGame.setPrice(new BigDecimal("100.00"));
        actualGame.setStudio("Copenhagen");
        actualGame.setQuantity(1);
        actualGame=gameDao.addGame(actualGame);
        actualGameLst.add(actualGame);

        actualGame = new Game();
        actualGame.setTitle("LEGO Brawls");
        actualGame.setEsrbRating("E");
        actualGame.setDescription(" battle royale games");
        actualGame.setPrice(new BigDecimal("150.00"));
        actualGame.setStudio("Copenhagen");
        actualGame.setQuantity(1);
        actualGame= gameDao.addGame(actualGame);
        actualGameLst.add(actualGame);

        expectedGameLst = gameDao.getAllGame();
        assertEquals(expectedGameLst.size(), actualGameLst.size());

    }

    /**
     * Test to update a game
     */
    @Test
    public void updateGame(){
        Game actualGame = new Game();
        actualGame.setTitle("LEGO Brawls");
        actualGame.setEsrbRating("E");
        actualGame.setDescription(" battle royale games");
        actualGame.setPrice(new BigDecimal("150.00"));
        actualGame.setStudio("Copenhagen");
        actualGame.setQuantity(1);
        actualGame = gameDao.addGame(actualGame);

        Game expecteGame = new Game();
        expecteGame.setTitle("LEGO Arthouse");
        expecteGame.setEsrbRating("E");
        expecteGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        expecteGame.setPrice(new BigDecimal("100.00"));
        expecteGame.setStudio("Copenhagen");
        expecteGame.setQuantity(1);
        expecteGame.setGameId(actualGame.getGameId());

        actualGame.setTitle("LEGO Arthouse");
        actualGame.setEsrbRating("E");
        actualGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        actualGame.setPrice(new BigDecimal("100.00"));
        actualGame.setStudio("Copenhagen");
        actualGame.setQuantity(1);

        actualGame = gameDao.updateGame(actualGame);
        assertEquals(expecteGame, actualGame);

    }

    /**
     * Test to filter game by studio
     */
    @Test
    public void getGamesByStudio(){
        List<Game> actualGameLst = new ArrayList<>();
        Game actualGame = new Game();
        actualGame.setTitle("LEGO Arthouse");
        actualGame.setEsrbRating("E");
        actualGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        actualGame.setPrice(new BigDecimal("100.00"));
        actualGame.setStudio("Copenhagen");
        actualGame.setQuantity(1);
        actualGame = gameDao.addGame(actualGame);
        actualGameLst = gameDao.getGamesByStudio("Copenhagen");
        assertEquals(1,actualGameLst.size());

    }

    /**
     * Test to filter games by ESRB Rating
     */
    @Test
    public void getGamesByESRB(){
        List<Game> actualGameLst = new ArrayList<>();
        Game actualGame = new Game();
        actualGame.setTitle("LEGO Arthouse");
        actualGame.setEsrbRating("E");
        actualGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        actualGame.setPrice(new BigDecimal("100.00"));
        actualGame.setStudio("Copenhagen");
        actualGame.setQuantity(1);
        actualGame = gameDao.addGame(actualGame);
        actualGameLst = gameDao.getGamesByRating("E");
        assertEquals(1,actualGameLst.size());
    }

    /**
     * Test to filter games by Title
     */
    @Test
    public void getGamesByTitle(){
        List<Game> actualGameLst = new ArrayList<>();
        Game actualGame = new Game();
        actualGame.setTitle("LEGO Arthouse");
        actualGame.setEsrbRating("E");
        actualGame.setDescription("it is an expression of the value of creativity in a coming of age story, set amongst a micro LEGO");
        actualGame.setPrice(new BigDecimal("100.00"));
        actualGame.setStudio("Copenhagen");
        actualGame.setQuantity(1);
        actualGame = gameDao.addGame(actualGame);
        actualGameLst = gameDao.getGamesByTitle("LEGO Arthouse");
        assertEquals(1,actualGameLst.size());
    }
}
