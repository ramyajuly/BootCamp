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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;
/**
 Testing for CRUD operation on Author
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoJdbcTemplateImplTest {
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
     * To test insert, delete and to get a Book
     */
    @Test
    public void addGetDelete() {
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

        Book expectedBook = bookDao.readBook(actualBook.getBookId());
        Assert.assertEquals(expectedBook, actualBook);
        bookDao.deleteBook(actualBook.getBookId());
        expectedBook = bookDao.readBook(actualBook.getBookId());
        Assert.assertNull(expectedBook);

    }

    /**
     * To test all books
     */
    @Test
    public void readAllBook() {
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

        Book book2 = new Book();
        book2.setPublisherId(actualPublisher.getPublisherId());
        book2.setTitle("Dollar Bahu");
        book2.setAuthorId(actualAuthor.getAuthorId());
        book2.setPublishDate(LocalDate.of(2019, 6, 13));
        book2.setIsbn("1234");
        book2.setPrice(56.09);
        Book actualBook1 = bookDao.createBook(book);

        List<Book> actualBookList = bookDao.readAllBook();
        Assert.assertEquals(2, actualBookList.size());
    }

    /**
     * To test updating a book
     */
    @Test
    public void updateBook() {
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

        actualBook.setPrice(60.00);
        actualBook.setIsbn("2345");

        actualBook = bookDao.updateBook(actualBook);
        Book expectedBook = bookDao.readBook(actualBook.getBookId());

        Assert.assertEquals(expectedBook, actualBook);
    }

    @Test
    public void findByAuthor() {
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
        publisher.setName("Penguin Global");
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
        Book addedBook = bookDao.createBook(book);
        List<Book> actualBook = bookDao.findByAuthor("Su", "Mu");
        Assert.assertEquals(1, actualBook.size());
    }
}
