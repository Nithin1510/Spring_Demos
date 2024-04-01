package com.example.javabased;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig{
	
	// bean definitions
	@Bean
	Chinese getChinese() {
		return new Chinese();
	}
	
	@Bean
//	@Qualifier("getIndian")
	Indian getIndian() {
		return new Indian();
	}
	
	@Bean
	@Primary
	Italic getItalic() {
		return new Italic();
	}
	
	@Bean
	Waiter getWaiter() {
		Waiter waiter = new Waiter();
		waiter.setMenuItems(getChinese());
		return waiter;
	}
	
}
