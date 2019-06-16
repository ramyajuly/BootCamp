package com.company.RamyaBasavarajU1M5Summative.dao;

import com.company.RamyaBasavarajU1M5Summative.dto.Author;

import java.util.List;

public interface AuthorDao {
    //Author
    Author createAuthor(Author author);

    Author readAuthor(int id);

    List<Author> readAllAuthor();

    Author updateAuthor(Author author);

    void deleteAuthor(int id) throws Exception;

}
