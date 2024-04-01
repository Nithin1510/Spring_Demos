package com.example.javabased;

import java.util.Arrays;
import java.util.List;

public class Indian implements IFoodMenu{

	@Override
	public List<String> showMenu() {
		List<String> indianMenu = Arrays.asList("Biriyani", "Belluli Kebab", "Grill chicken", "Mutton Biriyani");
		return indianMenu;
	}

}