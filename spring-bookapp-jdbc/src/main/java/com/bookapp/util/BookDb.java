package com.bookapp.util;

import com.bookapp.model.Book;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookDb
{
    public List<Book> showBooks(){
        return Arrays.asList(
                new Book("Java in Action", "John David", "Tech", 1, 900.90),
                new Book("5 am club", "Robin", "SelfHelp", 2, 300.68),
                new Book("HTML for Dummies", "Ben John", "Tech", 3, 1900.45),
                new Book("Secrets", "Ben", "Tech", 4, 4700.90),
                new Book("Seven Habits", "John Hopper", "Self Help", 5, 5900.90),
                new Book("Avengers", "Lee", "Fiction", 6, 10000.00)
        );
    }
}
