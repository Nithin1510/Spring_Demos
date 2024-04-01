package com.bookapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappBasicApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappBasicApplication.class, args);
	}
	
	@Autowired
	IBookService bookService;
	
	@Override
	public void run(String... args) throws Exception {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("1. List of books \n" +
                "2. Author \n" +
                "3. Category \n" +
                "4. Price \n" +
                "5. Author and category \n" +
                "6. BookId \n" +
                "7. Exit\n");
        System.out.println("Enter your choice : ");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                System.out.println("Available books -> ");
                List<Book> books = bookService.getAll();
                for (Book book: books){
                    System.out.println(book);
                }
                break;
            case 2:
                System.out.println("Enter author name : ");
                String author = sc.next();
                try{
                    List<Book> bookByAuthor = bookService.getByAuthorStartsWith(author);
                    for (Book book: bookByAuthor){
                        System.out.println(book);
                    }
                } catch (BookNotFoundException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                System.out.println("Enter book category : ");
                String category = sc.next();
                try{
                    List<Book> bookByCategory = bookService.getByCategory(category);
                    for (Book book: bookByCategory){
                        System.out.println(book);
                    }
                } catch (BookNotFoundException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                System.out.println("Enter book price : ");
                double price = sc.nextDouble();
                try{
                    List<Book> bookByPrice = bookService.getByPriceLessThan(price);
                    for (Book book: bookByPrice){
                        System.out.println(book);
                    }
                } catch (BookNotFoundException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 5:
                System.out.println("Enter author name : ");
                String author1 = sc.next();
                System.out.println("Enter book category : ");
                String category1 = sc.next();
                try{
                    List<Book> bookByAuthorAndCategory = bookService.getByAuthorContainsAndCategory(author1, category1);
                    for (Book book: bookByAuthorAndCategory)
                        System.out.println(book);
                } catch (BookNotFoundException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 6:
                System.out.println("Enter bookId : ");
                int bookId = sc.nextInt();
                System.out.println(bookService.getById(bookId));
                break;
            case 7:
                System.exit(1);
            default:
                System.out.println("\nInvalid choice\n");
                break;          
        }
	}
}
