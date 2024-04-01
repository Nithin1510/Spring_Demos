package com.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.autowiring");
		ShapeFactory factory = context.getBean(ShapeFactory.class);
		factory.printArea("s", 20, 20);
		factory.printArea("t", 50, 20);
		factory.printArea("r", 30, 20);

	}
}
