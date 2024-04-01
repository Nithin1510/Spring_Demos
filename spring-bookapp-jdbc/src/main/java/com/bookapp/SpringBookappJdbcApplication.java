package com.bookapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJdbcApplication.class, args);
	}

	@Autowired
	private IBookService bookService;

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
                "7. Add new book \n" +
                "8. Update existing book \n" +
                "9. Remove book \n" +
                "10. Exit\n");
        System.out.println("Enter your choice : ");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                System.out.println("Available books -> ");
                List<Book> books = bookService.getAll();
                for (Book book: books)
                    System.out.println(book);
                break;
            case 2:
                System.out.println("Enter author name : ");
				String author = sc.next();
				List<Book> bookByAuthor = bookService.getByAuthorStartsWith(author);
				for (Book book : bookByAuthor)
					System.out.println(book);
				break;
            case 3:
                System.out.println("Enter book category : ");
                String category = sc.next();
				List<Book> bookByCategory = bookService.getByCategory(category);
				for (Book book : bookByCategory)
					System.out.println(book);
                break;
            case 4:
                System.out.println("Enter book price : ");
                double price = sc.nextDouble();
				List<Book> bookByPrice = bookService.getByPriceLessThan(price);
				for (Book book : bookByPrice)
					System.out.println(book);
				break;
            case 5:
                System.out.println("Enter author name : ");
                String author1 = sc.next();
                System.out.println("Enter book category : ");
                String category1 = sc.next();
				List<Book> bookByAuthorAndCategory = bookService.getByAuthorContainsAndCategory(author1, category1);
				for (Book book : bookByAuthorAndCategory)
					System.out.println(book);
                break;
            case 6:
                System.out.println("Enter bookId : ");
                int bookId = sc.nextInt(); 
                System.out.println(bookService.getById(bookId));
                break;
            case 7:
            	System.out.println("Enter bookId : ");
    			int bookId1 = sc.nextInt();
    			System.out.println("Enter book name : ");
    			String bookName = sc.next();
    			System.out.println("Enter author name : ");
    			String author2 = sc.next();
    			System.out.println("Enter book category : ");
    			String category2 = sc.next();
    			System.out.println("Enter book price : ");
    			double price1 = sc.nextDouble();
    			Book book = new Book(bookName, author2, category2, bookId1, price1);
    			bookService.addBook(book);
    			break;
            case 8:
            	System.out.println("Enter bookId : ");
    			int bookId2 = sc.nextInt();
    			System.out.println("Enter book price : ");
    			double price2 = sc.nextDouble();
    			bookService.updateBook(bookId2, price2);
    			break;
            case 9:
            	System.out.println("Enter bookId : ");
    			int bookId3 = sc.nextInt();
    			bookService.deleteBook(bookId3);
    			System.out.println("Delete success");
    			break;
            case 10:
                System.exit(1);
            default:
                System.out.println("\nInvalid choice\n");
                break;          
        }
	}
}
