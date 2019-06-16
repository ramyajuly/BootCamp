package com.company.RamyaBasavarajU1M5Summative;

import com.company.RamyaBasavarajU1M5Summative.dao.AuthorDao;
import com.company.RamyaBasavarajU1M5Summative.dao.BookDao;
import com.company.RamyaBasavarajU1M5Summative.dao.PublisherDao;
import com.company.RamyaBasavarajU1M5Summative.dto.Author;
import com.company.RamyaBasavarajU1M5Summative.dto.Book;
import com.company.RamyaBasavarajU1M5Summative.dto.Publisher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
    Testing for CRUD operation on Author
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoJdbcTemplateImplTest {
    @Autowired
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    BookDao bookDao;

    /**
     * Deletes all records from Tables -Book, Author, Publisher
     *
     *  * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        List<Book> bookList = bookDao.readAllBook();
        for (Book b : bookList) {
            bookDao.deleteBook(b.getBookId());
        }
        List<Publisher> publisherList = publisherDao.readAllPublisher();
        for (Publisher p : publisherList) {
            publisherDao.deletePublisher(p.getPublisherId());
        }
        List<Author> authorList = authorDao.readAllAuthor();
        for (Author a : authorList) {
            authorDao.deleteAuthor(a.getAuthorId());
        }
    }

    /**
     * Tests to add, get and Delete a author
     * @throws Exception
     */
    @Test
    public void addGetDeleteAuthor() throws Exception {

        Author author = new Author();
        author.setFirstName("Sudha");
        author.setLastName("Murthy");
        author.setStreet("Basavanagudi");
        author.setCity("Bangalore");
        author.setState("KA");
        author.setPostalCode("560013");
        author.setEmail("sudhamurthy@email.com");
        author.setPhone("6666666666");
        Author actualAuthor = authorDao.createAuthor(author);

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Global ");
        publisher.setEmail("penguin@email.com");
        publisher.setStreet("MG Road");
        publisher.setCity("Bangalore");
        publisher.setState("KA");
        publisher.setPostalCode("560032");
        publisher.setPhone("7777777777");
        Publisher actualPublisher = publisherDao.createPublisher(publisher);

        Book book = new Book();
        book.setPublisherId(actualPublisher.getPublisherId());
        book.setTitle("Dollar Bahu");
        book.setAuthorId(actualAuthor.getAuthorId());
        book.setPublishDate(LocalDate.of(2019, 6, 13));
        book.setIsbn("1234");
        book.setPrice(56.09);
        Book actualBook = bookDao.createBook(book);

        Author expectedAuthor = authorDao.readAuthor(actualAuthor.getAuthorId());

        Assert.assertEquals(expectedAuthor, actualAuthor);
        bookDao.deleteBook(actualBook.getBookId());
        try {
            authorDao.deleteAuthor(actualAuthor.getAuthorId());
        }
        catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Author is associated with Books, Please delete books before deleting author");
        }
        catch (Exception ex){
           throw new SQLException(ex.getMessage());
        }

        expectedAuthor = authorDao.readAuthor(actualAuthor.getAuthorId());
        Assert.assertNull(expectedAuthor);
    }

    /**
     * To test all authors
     */
    @Test
    public void readAllAuthors() {
        List<Author> authorList = new ArrayList<>();
        Author author = new Author();
        author.setFirstName("Sudha");
        author.setLastName("Murthy");
        author.setStreet("Basavanagudi");
        author.setCity("Bangalore");
        author.setState("KA");
        author.setPostalCode("560013");
        author.setEmail("sudhamurthy@email.com");
        author.setPhone("6666666666");
        authorList.add(authorDao.createAuthor(author));


        Author author1 = new Author();
        author1.setFirstName("Narayana");
        author1.setLastName("Murthy");
        author1.setStreet("Basavanagudi");
        author1.setCity("Bangalore");
        author1.setState("KA");
        author1.setPostalCode("560013");
        author1.setEmail("narayanamurthy@email.com");
        author1.setPhone("1111111111");
        authorList.add(authorDao.createAuthor(author1));
        Assert.assertEquals(2, authorList.size());

    }

    /**
     * To test updating a author
     */
    @Test
    public void updateAuthor() {
        Author author = new Author();
        author.setFirstName("Sudha");
        author.setLastName("Murthy");
        author.setStreet("Basavanagudi");
        author.setCity("Bangalore");
        author.setState("KA");
        author.setPostalCode("560013");
        author.setEmail("sudhamurthy@email.com");
        author.setPhone("6666666666");
        Author actualAuthor = authorDao.createAuthor(author);
        actualAuthor.setPhone("1212132354");
        actualAuthor.setEmail("sudhamurthy@yaho.com");
        actualAuthor = authorDao.updateAuthor(actualAuthor);
        Author expectedAuthor = authorDao.readAuthor(actualAuthor.getAuthorId());
        Assert.assertEquals(expectedAuthor, actualAuthor);

    }
}
