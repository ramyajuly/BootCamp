package com.company.RamyaBasavarajU1M5Summative.dao;

import com.company.RamyaBasavarajU1M5Summative.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Jdbc template implementation and prepared statements for Book
 */
@Repository
public class BookDaoJdbcTemplateImpl implements BookDao {
    private static final String INSERT_BOOK_SQL =
            " insert into book (isbn,publish_date,author_id,title,publisher_id,price) " +
                    "values (?,?,?,?,?,?)";
    private static final String SELECT_BOOK_SQL =
            "select * from book where book_id=?";
    private static final String SELECT_ALL_BOOK_SQL =
            "select * from book";
    private static final String DELETE_BOOK_SQL =
            "delete from book where book_id=?";
    private static final String UPDATE_BOOK_SQL =
            "update book set isbn=?, publish_date=?,author_id=?, title=?,publisher_id=?,price=?" +
                    " where book_id=? ";
    private static final String SELECT_BOOK_BY_AUTHOR="select * from book inner join author " +
            "on book.author_id=author.author_id where LOWER(author.first_name) like LOWER(?) and LOWER(author.last_name) " +
            "like LOWER(?) ";

    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor
     * @param jdbcTemplate
     */
    @Autowired
    public BookDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Insert new book record
     * @param book
     * @return Book
     */
    @Override
    @Transactional
    public Book createBook(Book book) {
        //isbn,publish_date,author_id,title,publisher_id,price
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        book.setBookId(id);
        return book;
    }

    /**
     * Get a Book
     * @param id
     * @return Book
     */
    @Override
    public Book readBook(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Get all Book
     * @return List<Book>
     */
    @Override
    public List<Book> readAllBook() {
        return jdbcTemplate.query(SELECT_ALL_BOOK_SQL, this::mapRowToBook);
    }

    /**
     * Update a Book
     * @param book
     * @return Book
     */
    @Override
    @Transactional
    public Book updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(), book.getBookId());
        return book;
    }

    /**
     * Delete a Book
     * @param id
     */
    @Override
    @Transactional
    public void deleteBook(int id) {
        jdbcTemplate.update(DELETE_BOOK_SQL, id);
    }

    /**
     * Get all books by Author First name and Last name
     * @param firstName
     * @param lastName
     * @return List<Book>
     */
    @Override
    public List<Book>  findByAuthor(String firstName,String lastName) {
        return jdbcTemplate.query(SELECT_BOOK_BY_AUTHOR,this::mapRowToBook,firstName +"%",lastName+"%");
    }

    /**
     * Maps Book attribute names to SQL table column names
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setIsbn(rs.getString("isbn"));
        java.sql.Date mySqlDate = rs.getDate("publish_date");
        LocalDate myLocalDate = mySqlDate.toLocalDate();
        book.setPublishDate(myLocalDate);
        book.setAuthorId(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPublisherId(rs.getInt("publisher_id"));
        book.setPrice(rs.getDouble("price"));
        return book;
    }
}
