package com.company.RamyaBasavarajU1M5Summative.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private int bookId;
    @NotEmpty(message = "ISBN cannot be empty")
    private String isbn;
 @NotNull(message = "PUBLISH DATE cannot be empty or null")
    private LocalDate publishDate;
    @NotNull(message = "AUTHOR ID cannot be empty")
    private int authorId;
    @NotEmpty(message = "TITLE cannot be empty")
    private String title;
    @NotNull(message = "PUBLISHER ID cannot be empty")
    private int publisherId;
    @NotNull(message = "PRICE cannot be empty")
    private Double price;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                authorId == book.authorId &&
                publisherId == book.publisherId &&
                isbn.equals(book.isbn) &&
                publishDate.equals(book.publishDate) &&
                title.equals(book.title) &&
                price.equals(book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, isbn, publishDate, authorId, title, publisherId, price);
    }
}
