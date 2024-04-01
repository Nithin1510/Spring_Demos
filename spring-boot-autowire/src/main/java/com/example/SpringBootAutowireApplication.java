package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.autowiring.ShapeFactory;
import com.example.javabased.Waiter;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class SpringBootAutowireApplication implements CommandLineRunner{

	public static void main(String[] args){
		SpringApplication.run(SpringBootAutowireApplication.class, args);
	}
	
//	@Autowired
//	ShapeFactory shapeFactory;

	@Autowired
	Waiter waiter;
	@Override
	public void run(String... args) throws Exception {
		List<String> menus = waiter.viewMenuCard("i");
		for(String menu: menus) {
			System.out.println(menu);
		}
	}

}
