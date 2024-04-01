package com.bookapp.repository;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.Queries;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements IBookRepository {

	private JdbcTemplate jdbcTemplate;
	
	public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addBook(Book book) {
		Object[] bookAdd = {book.getBookId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getPrice()};
		jdbcTemplate.update(Queries.InsertQuery, bookAdd);
	}

	@Override
	public void updateBook(int bookId, double price) {
		jdbcTemplate.update(Queries.UpdateQuery, bookId, price);
		
	}

	@Override
	public void deleteBook(int bookId) {
		jdbcTemplate.update(Queries.DeleteQuery, bookId);
		
	}

	@Override
	public List<Book> findAll() {
		RowMapper<Book> mapper = new BookMapper();
		List<Book> books = jdbcTemplate.query(Queries.selectQuery, mapper);
		return books;
	}

	@Override
	public List<Book> findByAuthorStartsWith(String author) throws BookNotFoundException {
		return jdbcTemplate.query(Queries.SelectByAuthorQuery, (rs, rowNum) ->{
			Book book = new Book();
			book.setAuthor(rs.getString("author"));
			book.setBookId(rs.getInt("book_id"));
			book.setTitle(rs.getString("title"));
			book.setCategory(rs.getString("category"));
			book.setPrice(rs.getDouble("price"));
			return book;
		},author);
	}

	@Override
	public List<Book> findByCategory(String category) throws BookNotFoundException {
		List<Book> books = jdbcTemplate.query(Queries.SelectByCategoryQuery, new BookMapper(), category);
		return books;
	}

	@Override
	public List<Book> findByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = jdbcTemplate.query(Queries.SelectByPriceQuery, new BookMapper(), price);
		return books;
	}

	@Override
	public List<Book> findByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> books = jdbcTemplate.query(Queries.SelectByAuthorAndCategoryQuery, new BookMapper(), author, category);
		return books;
	}

	@Override
	public Book findById(int bookId) throws IdNotFoundException {
		Book book = jdbcTemplate.queryForObject(Queries.SelectById, Book.class, bookId);
		return book;
	}
}
