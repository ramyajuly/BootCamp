package com.company.RamyaBasavarajU1M5Summative.controller;

import com.company.RamyaBasavarajU1M5Summative.dao.*;
import com.company.RamyaBasavarajU1M5Summative.dto.Author;
import com.company.RamyaBasavarajU1M5Summative.dto.Book;
import com.company.RamyaBasavarajU1M5Summative.dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Rest API that keeps track of books in a bookstore.
 */
@RestController
public class RamyaBasavarajU1M5SummativeController {
    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    PublisherDao publisherDao;

    /**
     * Creates a new Book
     *
     * @param book
     * @return Book
     */
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book createBook(@RequestBody @Valid Book book) {
        return bookDao.createBook(book);
    }

    /**
     * To get a book on bookID
     *
     * @param bookId
     * @return Book
     */
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Book readBook(@PathVariable int bookId) {
        return bookDao.readBook(bookId);
    }

    /**
     * To get all Books
     *
     * @return List<Book>
     */
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> readAllBook() {
        return bookDao.readAllBook();
    }

    /**
     * To delete a Book
     *
     * @param bookId
     */
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int bookId) {
        bookDao.deleteBook(bookId);
    }

    /**
     * To update a Book
     *
     * @param book
     * @param bookId
     * @return Book
     */
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Book updateBook(@RequestBody @Valid Book book, @PathVariable int bookId) {
        book.setBookId(bookId);
        try {
            return bookDao.updateBook(book);

        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Please check for publisher id or author id ");
        }
    }

    /**
     * To get one or more books on Authors first name and lastname
     *
     * @param firstName
     * @param lastName
     * @return List<Book>
     */
    @RequestMapping(value = "/book/{firstName}/{lastName}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> findBookByAuthor(@PathVariable @Valid String firstName, @PathVariable @Valid String lastName) {
        return bookDao.findByAuthor(firstName, lastName);
    }

    /**
     * To create a new Author
     *
     * @param author
     * @return Author
     */
    @RequestMapping(value = "/author", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Author createAuthor(@RequestBody @Valid Author author) {
        return authorDao.createAuthor(author);
    }

    /**
     * To get a author on author id
     *
     * @param authorId
     * @return Author
     */
    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Author readAuthor(@PathVariable int authorId) {
        return authorDao.readAuthor(authorId);
    }

    /**
     * To get all authors
     *
     * @return List<Author>
     */
    @RequestMapping(value = "/author", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Author> readAllAuthor() {
        return authorDao.readAllAuthor();
    }

    /**
     * To delete a author
     *
     * @param authorId
     * @throws Exception
     */
    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int authorId) throws Exception {
        try {
            authorDao.deleteAuthor(authorId);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Publisher is associated with Books, Please delete books before deleting publisher");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    /**
     * To update a author
     *
     * @param author
     * @param authorId
     * @return Author
     */
    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Author updateAuthor(@RequestBody @Valid Author author, @PathVariable int authorId) {
        author.setAuthorId(authorId);
        return authorDao.updateAuthor(author);
    }

    /**
     * To create a publisher
     *
     * @param publisher
     * @return Publisher
     */
    @RequestMapping(value = "/publisher", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Publisher createPublisher(@RequestBody @Valid Publisher publisher) {
        return publisherDao.createPublisher(publisher);
    }

    /**
     * To get a publisher
     *
     * @param publisherId
     * @return
     */
    @RequestMapping(value = "/publisher/{publisherId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Publisher readPublisher(@PathVariable int publisherId) {
        return publisherDao.readPublisher(publisherId);
    }

    /**
     * To get all Publishers
     *
     * @return List<Publisher>
     */
    @RequestMapping(value = "/publisher", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Publisher> readAllPublisher() {
        return publisherDao.readAllPublisher();
    }

    /**
     * To delete a publisher
     *
     * @param publisherId
     * @throws Exception
     */
    @RequestMapping(value = "/publisher/{publisherId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int publisherId) throws Exception {
        try {

            publisherDao.deletePublisher(publisherId);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Publisher is associated with Books, Please delete books before deleting publisher");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    /**
     * To update a publisher
     *
     * @param publisher
     * @param publisherId
     * @return Publisher
     */
    @RequestMapping(value = "/publisher/{publisherId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Publisher updatePublisher(@RequestBody @Valid Publisher publisher, @PathVariable int publisherId) {
        publisher.setPublisherId(publisherId);
        return publisherDao.updatePublisher(publisher);

    }


}
