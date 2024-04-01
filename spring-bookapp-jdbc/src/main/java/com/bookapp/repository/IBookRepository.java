package com.bookapp.repository;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;

import java.util.List;

public interface IBookRepository {

    void addBook(Book book);

    void updateBook(int bookId, double price);

    void deleteBook(int bookId);

    List<Book> findAll();

    List<Book> findByAuthorStartsWith(String author) throws BookNotFoundException;

    List<Book> findByCategory(String category) throws BookNotFoundException;

    List<Book> findByPriceLessThan(double price) throws BookNotFoundException;

    List<Book> findByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException;

    Book findById(int bookId) throws IdNotFoundException;
}
