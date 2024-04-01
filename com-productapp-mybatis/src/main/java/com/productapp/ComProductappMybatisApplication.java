package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.service.IProductService;

@SpringBootApplication
public class ComProductappMybatisApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ComProductappMybatisApplication.class, args);
	}
	
	@Autowired
	IProductService productService;

	@Override
	public void run(String... args) throws Exception {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Choose from the below options");
//        System.out.println("1. Add  \n" +
//                "2. Update  \n" +
//                "3. Delete  \n" +
//                "4. Find by productId  \n" +
//                "5. Find All products \n" +
//                "6. Find by brand \n" +
//                "7. Find by less price  \n" +
//                "8. Find by price and category \n" +
//                "9. Exit \n");
//		System.out.println("Enter your choice");
//		int choice = scanner.nextInt();
//		switch (choice) {
//		case 1:
//			System.out.println("Enter ProductId");
//			int productId = scanner.nextInt();
//			System.out.println("Enter productName");
//			String productName = scanner.next();
//			System.out.println("Enter brand");
//			String brand = scanner.next();
//			System.out.println("Enter category");
//			String category = scanner.next();
//			System.out.println("Enter price");
//			double price = scanner.nextDouble();
//			Product product = new Product(productId, productName, brand, category, price);
//			productService.addProduct(product);
//			System.out.println("Insertion success");
//			break;
//		case 2:
//			System.out.println("Update");
//			System.out.println("Enter ProductId");
//			int productId1 = scanner.nextInt();
//			System.out.println("Enter price");
//			double price1 = scanner.nextDouble();
//			productService.updateProduct(productId1, price1);
//			break;
//		case 3:
//			System.out.println("Delete");
//			System.out.println("Enter ProductId");
//			int productId2 = scanner.nextInt();
//			productService.deleteProduct(productId2);
//			break;
//		case 4:
//			System.out.println("By productId");
//			System.out.println("Enter ProductId");
//			int productId3 = scanner.nextInt();
//			System.out.println(productService.getId(productId3));
//			break;
//		case 5:
//			System.out.println("All");
//			List<Product> products = productService.getAll();
//			for (Product prod : products)
//				System.out.println(prod);
//			break;
//		case 6:
//			System.out.println("By Brand");
//			System.out.println("Enter brand");
//			String brand2 = scanner.next();
//			List<Product> productsBrand = productService.getByBrand(brand2);
//			for (Product prod : productsBrand)
//				System.out.println(prod);
//			break;
//		case 7:
//			System.out.println("By price");
//			System.out.println("Enter price");
//			double price3 = scanner.nextDouble();
//			List<Product> productsPr = productService.getByLesPrice(price3);
//			for (Product prod : productsPr)
//				System.out.println(prod);
//			break;
//		case 8:
//			System.out.println("category and price");
//			System.out.println("Enter category");
//			String category1 = scanner.next();
//			System.out.println("Enter price");
//			double price2 = scanner.nextDouble();
//			List<Product> productsPriCat = productService.getByCategoryAndPrice(category1, price2);
//			for (Product prod : productsPriCat)
//				System.out.println(prod);
//			break;
//		case 9:
//			System.exit(1);
//		default:
//			System.out.println("\nInvalid choice\n");
//		}
//		scanner.close();
		
	}
}
