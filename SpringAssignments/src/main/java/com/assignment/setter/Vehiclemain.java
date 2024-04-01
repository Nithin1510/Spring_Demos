package com.assignment.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Vehiclemain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.assignment.setter");
		
		Vehicle vehicle = (Vehicle) context.getBean("vehicle");
		System.out.println(vehicle);

	}

}
