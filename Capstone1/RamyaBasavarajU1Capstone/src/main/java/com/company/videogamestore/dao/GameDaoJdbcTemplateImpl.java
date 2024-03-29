package com.company.videogamestore.dao;

import com.company.videogamestore.model.Console;
import com.company.videogamestore.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Game Repository class with JdbcTemplate, prepared statements
 */
@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {
    private JdbcTemplate jdbcTemplate;

    //Prepared Statements for Game
    private static final String INSERT_GAME_SQL =
            "insert into game (title, esrb_rating, description, price, studio,quantity) values (?, ?, ?, ?, ?,?)";

    private static final String SELECT_GAME_SQL =
            "select * from game where game_id = ?";

    private static final String SELECT_ALL_GAME_SQL =
            "select * from game";

    private static final String UPDATE_GAME_SQL =
            "update game set title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?,quantity=? where game_id = ?";

    private static final String DELETE_GAME =
            "delete from game where game_id = ?";

    private static final String SELECT_GAME_BY_STUDIO_SQL =
            "select * from game where LOWER(studio) like LOWER(?)";

    private static final String SELECT_GAME_BY_RATING_SQL =
            "select * from game where LOWER(esrb_rating) like LOWER(?)";

    private static final String SELECT_GAME_BY_TITLE_SQL =
            "select * from game where LOWER(title) like LOWER(?)";

    /**
     * Constructor
     * @param jdbcTemplate
     */
    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * To add a new game
     * @param game
     * @return Game
     */
    @Override
    public Game addGame(Game game) {
        jdbcTemplate.update(
                INSERT_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity()
        );
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        game.setGameId(id);
        return game;
    }

    /**
     * To get a game
     * @param gameId
     * @return Game
     */
    @Override
    public Game getGame(int gameId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, gameId);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this Game id, return null
            return null;
        }
    }

    /**
     * To get all game
     * @return List<Game>
     */
    @Override
    public List<Game> getAllGame() {
        return jdbcTemplate.query(SELECT_ALL_GAME_SQL, this::mapRowToGame);
    }

    /**
     * To update a game
     * @param game
     * @return Game
     */
    @Override
    public Game updateGame(Game game) {
        jdbcTemplate.update(
                UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getGameId()
        );
        return game;
    }

    /**
     * To delete a game
     * @param gameId
     * @return int
     */
    @Override
    public int deleteGame(int gameId) {
        return jdbcTemplate.update(DELETE_GAME, gameId);
    }

    /**
     * To get games by studio
     * @param studio
     * @return List<Game>
     */
    @Override
    public List<Game> getGamesByStudio(String studio) {
        return jdbcTemplate.query(SELECT_GAME_BY_STUDIO_SQL, this::mapRowToGame, studio + "%");
    }

    /**
     * To get games by rating
     * @param esrbRating
     * @return List<Game>
     */
    @Override
    public List<Game> getGamesByRating(String esrbRating) {

        return jdbcTemplate.query(SELECT_GAME_BY_RATING_SQL, this::mapRowToGame, esrbRating + "%");
    }

    /**
     * To get games by title
     * @param title
     * @return List<Game>
     */
    @Override
    public List<Game> getGamesByTitle(String title) {
        return jdbcTemplate.query(SELECT_GAME_BY_TITLE_SQL, this::mapRowToGame, title + "%");
    }

    /**
     * Maps table of data representing a database result set, which
     * is usually generated by executing a statement that queries the database.
     * @param rs
     * @param rowNum
     * @return Game
     * @throws SQLException
     */
    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setEsrbRating(rs.getString("esrb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));
        return game;
    }
}
