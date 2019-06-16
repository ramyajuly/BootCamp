package com.company.RamyaBasavarajU1M5Summative.dao;

import com.company.RamyaBasavarajU1M5Summative.dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Jdbc template implementation and prepared statements for Publisher
 */
@Repository
public class PublisherDaoJdbcTemplateImpl implements PublisherDao {
    private static final String INSERT_PUBLISHER_SQL =
            " insert into publisher (name, street, city, state, postal_code, phone, email) " +
                    "values (?,?,?,?,?,?,?)";
    private static final String SELECT_PUBLISHER_SQL =
            "select * from publisher where publisher_id=?";
    private static final String SELECT_ALL_PUBLISHER_SQL =
            "select * from publisher";
    private static final String DELETE_PUBLISHER_SQL =
            "delete from publisher where publisher_id=?";
    private static final String UPDATE_PUBLISHER_SQL =
            "update publisher set name=?, street=?, city=?,state=?,postal_code=?,phone=?,email=?" +
                    " where publisher_id=? ";
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor
     * @param jdbcTemplate
     */
    @Autowired
    public PublisherDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Insert new Publisher
     * @param publisher
     * @return Publisher
     */
    @Override
    @Transactional
    public Publisher createPublisher(Publisher publisher) {
        jdbcTemplate.update(INSERT_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostalCode(),
                publisher.getPhone(),
                publisher.getEmail());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        publisher.setPublisherId(id);
        return publisher;
    }

    /**
     * Get a Publisher
     * @param id
     * @return Publisher
     */
    @Override
    public Publisher readPublisher(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Get all Publishers
     * @return List<Publisher>
     */
    @Override
    public List<Publisher> readAllPublisher() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHER_SQL, this::mapRowToPublisher);
    }

    /**
     * Update Publisher
     * @param publisher
     * @return Publisher
     */
    @Override
    @Transactional
    public Publisher updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostalCode(),
                publisher.getPhone(),
                publisher.getEmail(), publisher.getPublisherId());
        return publisher;
    }

    /**
     * Delete a Publisher
     * @param id
     */
    @Override
    @Transactional
    public void deletePublisher(int id) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, id);
    }

    /**
     * Maps Publisher attribute names to SQL table column names
     * @param rs
     * @param rowNum
     * @return Publisher
     * @throws SQLException
     */
    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setStreet(rs.getString("street"));
        publisher.setCity(rs.getString("city"));
        publisher.setState(rs.getString("state"));
        publisher.setPostalCode(rs.getString("postal_code"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setEmail(rs.getString("email"));
        return publisher;
    }
}
