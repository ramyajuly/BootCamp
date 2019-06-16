package com.company.RamyaBasavarajU1M5Summative.dao;

import com.company.RamyaBasavarajU1M5Summative.dto.Author;
import com.company.RamyaBasavarajU1M5Summative.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Jdbc template implementation and prepared statements for Author
 *
 */
@Repository
public class AuthorDaoJdbcTemplateImpl implements AuthorDao {
    private static final String INSERT_AUTHOR_SQL =
            " insert into author (first_name, last_name, street, city, state, postal_code, phone, email) " +
                    "values (?,?,?,?,?,?,?,?)";
    private static final String SELECT_AUTHOR_SQL =
            "select * from author where author_id=?";
    private static final String SELECT_ALL_AUTHOR_SQL =
            "select * from author";
    private static final String DELETE_AUTHOR_SQL =
            "delete from author where author_id=?";
    private static final String UPDATE_AUTHOR_SQL =
            "update author set first_name=?, last_name=?,street=?, city=?,state=?,postal_code=?,phone=?,email=?" +
                    " where author_id=? ";
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor
     * @param jdbcTemplate
     */
    @Autowired
    public AuthorDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Insert new Author
     * @param author
     * @return Author
     */
    @Override
    @Transactional
    public Author createAuthor(Author author) {
        jdbcTemplate.update(INSERT_AUTHOR_SQL,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostalCode(),
                author.getPhone(),
                author.getEmail());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        author.setAuthorId(id);
        return author;
    }

    /**
     * Get a Author
     * @param id
     * @return Author
     */
    @Override
    public Author readAuthor(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_AUTHOR_SQL, this::mapRowToAuthor, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Get all Authors
     * @return List<Author>
     */
    @Override
    public List<Author> readAllAuthor() {
        return jdbcTemplate.query(SELECT_ALL_AUTHOR_SQL, this::mapRowToAuthor);
    }

    /**
     * Update a Author
     * @param author
     * @return Author
     */
    @Override
    @Transactional
    public Author updateAuthor(Author author) {
        jdbcTemplate.update(UPDATE_AUTHOR_SQL,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostalCode(),
                author.getPhone(),
                author.getEmail(), author.getAuthorId());
        return author;
    }

    /**
     * Delete a Author
     * @param id
     */
    @Override
    @Transactional
    public void deleteAuthor(int id) {

            jdbcTemplate.update(DELETE_AUTHOR_SQL, id);


    }

    /**
     * Maps Author attribute names to SQL table column names
     * @param rs
     * @param rowNum
     * @return Author
     * @throws SQLException
     */
    private Author mapRowToAuthor(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setAuthorId(rs.getInt("author_id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        author.setStreet(rs.getString("street"));
        author.setCity(rs.getString("city"));
        author.setState(rs.getString("state"));
        author.setPostalCode(rs.getString("postal_code"));
        author.setPhone(rs.getString("phone"));
        author.setEmail(rs.getString("email"));
        return author;
    }
}
