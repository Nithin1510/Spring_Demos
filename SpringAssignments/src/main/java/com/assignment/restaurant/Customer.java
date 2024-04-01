package com.assignment.restaurant;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Customer {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext("com.assignment.restaurant");
		
		Waiter waiter = context.getBean(Waiter.class);
		System.out.println("Indian menu: ");
		List<String> india = waiter.viewMenuCard("i");
		for(String ind: india) {
			System.out.println(ind);
		}
		System.out.println();
		System.out.println("Chinese menu: ");
		List<String> china = waiter.viewMenuCard("c");
		for(String chi: china) {
			System.out.println(chi);
		}
		System.out.println();
		System.out.println("Italic menu: ");
		List<String> italic = waiter.viewMenuCard("it");
		for(String italy: italic) {
			System.out.println(italy);
		}
	}

}
