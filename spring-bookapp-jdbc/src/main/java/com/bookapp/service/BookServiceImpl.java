package com.bookapp.service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.BookRepositoryImpl;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	BookRepositoryImpl bookRepository;
	@Override
	public void addBook(Book book) {
		bookRepository.addBook(book);
		
	}

	@Override
	public void updateBook(int bookId, double price) {
		bookRepository.updateBook(bookId, price);
		
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteBook(bookId);
		
	}

	@Override
	public List<Book> getAll() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	@Override
	public List<Book> getByAuthorStartsWith(String author) throws BookNotFoundException {
		List<Book> books = bookRepository.findByAuthorStartsWith(author);
		if(books.isEmpty()) {
			throw new BookNotFoundException("Book not found with this author.");
		}
		Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getAuthor()));
		return books;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> books = bookRepository.findByCategory(category);
		if(books.isEmpty()) {
			throw new BookNotFoundException("Book not found with this category.");
		}
		Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getAuthor()));
		return books;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = bookRepository.findByPriceLessThan(price);
		if(books.isEmpty()) {
			throw new BookNotFoundException("Book not found with this price.");
		}
		Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getAuthor()));
		return books;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> books = bookRepository.findByAuthorContainsAndCategory(author, category);
		if(books.isEmpty()) {
			throw new BookNotFoundException("Book not found with this author and category.");
		}
		Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getAuthor()));
		return books;
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		Book book = bookRepository.findById(bookId);
		if(book == null) {
			throw new IdNotFoundException();
		}
		return book;
	}
	
}
