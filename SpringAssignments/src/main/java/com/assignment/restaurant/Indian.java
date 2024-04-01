package com.assignment.restaurant;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Indian implements IFoodMenu{

	@Override
	public List<String> showMenu() {
		List<String> indianMenu = Arrays.asList("Biriyani", "Belluli Kebab", "Grill chicken", "Mutton Biriyani");
		return indianMenu;
	}

}