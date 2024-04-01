package com.bookapp.util;

public class Queries {
	
    public static final String InsertQuery= "INSERT INTO book(book_id, title, author, category, price) VALUES (?, ?, ?, ?, ?);";
    public static final String UpdateQuery= "UPDATE book SET price=? WHERE book_id=?;";
    public static final String DeleteQuery= "DELETE FROM book WHERE book_id=?;";

    public static final String selectQuery = "SELECT * FROM BOOK";
    public static final String SelectByAuthorQuery = "SELECT * FROM BOOK WHERE author=?";
    public static final String SelectByCategoryQuery = "SELECT * FROM BOOK WHERE category=?";
    public static final String SelectByPriceQuery = "SELECT * FROM BOOK WHERE price<?";
    public static final String SelectByAuthorAndCategoryQuery = "SELECT * FROM BOOK WHERE author=? && category=?";
    public static final String SelectById = "SELECT * FROM BOOK WHERE book_Id=?";
}
