package com.assignment.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoMain {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.assignment.auto");
		Performer performer = context.getBean(Performer.class);
		performer.playMusic("v", "Devi Sri Prasad");
		performer.playMusic("k", "A R Rehman");
		performer.playMusic("g", "Thaman");
	}
}
