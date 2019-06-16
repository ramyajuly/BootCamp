package com.company.RamyaBasavarajU1M5Summative.dao;

import com.company.RamyaBasavarajU1M5Summative.dto.Book;

import java.util.List;

public interface BookDao {
    //Book
    Book createBook(Book book);

    Book readBook(int id);

    List<Book> readAllBook();

    Book updateBook(Book book);

    void deleteBook(int id);
    //Find book by author
    List<Book> findByAuthor(String firstName,String lastName);
}
