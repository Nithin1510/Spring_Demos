package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetController {
	// for user and admin
	// http://localhost:8081/greet
	@GetMapping("/greet")
	public String greet() {
		return "Have a great day";
	}
	
	// for user and admin
	// http://loaclhost:8080/api/user/books/show
	@GetMapping("/user/books/show")
	public List<String> showBooks() {
		return Arrays.asList("Java", "Spring");
	}
	
	// for admin
	// http://localhost:8081/admin/books/in
	@GetMapping("/admin/books/in")
	public String addBooks() {
		return "added";
	}
}
