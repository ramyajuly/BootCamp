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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 Testing for CRUD operation on Author
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoJdbcTemplateImplTest {
    @Autowired
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    BookDao bookDao;

    /**
     * Deletes all records from Tables -Book, Author, Publisher
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        List<Book> bookList = bookDao.readAllBook();
        for (Book b : bookList) {
            bookDao.deleteBook(b.getBookId());
        }
        List<Author> authorList = authorDao.readAllAuthor();
        for (Author a : authorList) {
            authorDao.deleteAuthor(a.getAuthorId());
        }
        List<Publisher> publisherList = publisherDao.readAllPublisher();
        for (Publisher p : publisherList) {
            publisherDao.deletePublisher(p.getPublisherId());
        }

    }

    /**
     * To insert , delete and get a publisher
     * @throws Exception
     */
    @Test
    public void addGetDeletePublisher() throws Exception {
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

        Publisher expectedPublisher = publisherDao.readPublisher(actualPublisher.getPublisherId());

        Assert.assertEquals(expectedPublisher, actualPublisher);
        bookDao.deleteBook(actualBook.getBookId());
        try {
            publisherDao.deletePublisher(actualPublisher.getPublisherId());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Publisher is associated with Books, Please delete books before deleting publisher");
        }
        catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        expectedPublisher = publisherDao.readPublisher(actualPublisher.getPublisherId());
        Assert.assertNull(expectedPublisher);
    }

    /**
     * To test all publishers
     */
    @Test
    public void readAllPublishers() {
        List<Publisher> publisherList = new ArrayList<>();
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Global ");
        publisher.setEmail("penguin@email.com");
        publisher.setStreet("MG Road");
        publisher.setCity("Bangalore");
        publisher.setState("KA");
        publisher.setPostalCode("560032");
        publisher.setPhone("7777777777");
        publisherList.add(publisherDao.createPublisher(publisher));


        Publisher publisher1 = new Publisher();
        publisher1.setName("Penguin Global ");
        publisher1.setEmail("penguin@email.com");
        publisher1.setStreet("MG Road");
        publisher1.setCity("Bangalore");
        publisher1.setState("KA");
        publisher1.setPostalCode("560032");
        publisher1.setPhone("7777777777");
        Publisher actualPublisher = publisherDao.createPublisher(publisher);
        publisherList.add(publisherDao.createPublisher(publisher1));
        Assert.assertEquals(2, publisherList.size());

    }

    /**
     * To test updating a publisher
     */
    @Test
    public void updatePublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Global ");
        publisher.setEmail("penguin@email.com");
        publisher.setStreet("MG Road");
        publisher.setCity("Bangalore");
        publisher.setState("KA");
        publisher.setPostalCode("560032");
        publisher.setPhone("7777777777");
        Publisher actualPublisher = publisherDao.createPublisher(publisher);
        actualPublisher.setPhone("1212132354");
        actualPublisher.setEmail("sudhamurthy@yaho.com");
        actualPublisher = publisherDao.updatePublisher(actualPublisher);
        Publisher expectedPublisher = publisherDao.readPublisher(actualPublisher.getPublisherId());
        Assert.assertEquals(expectedPublisher, actualPublisher);

    }
}
