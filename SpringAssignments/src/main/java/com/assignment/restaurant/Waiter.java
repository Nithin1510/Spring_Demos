package com.assignment.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Waiter {
	
	@Autowired
	private IFoodMenu indian;
	
	@Autowired
	@Qualifier("chinese")
	private IFoodMenu chinese;
	
	@Autowired
	private IFoodMenu italian;
	
	List<String> viewMenuCard(String choice){
		if(choice.equals("i"))
			return indian.showMenu();
		if(choice.equals("c"))
			return chinese.showMenu();
		if(choice.equals("it"))
			return italian.showMenu();
		return null;
	}
}
