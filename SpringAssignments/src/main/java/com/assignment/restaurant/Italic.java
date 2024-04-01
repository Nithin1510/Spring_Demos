package com.assignment.restaurant;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("italian")
public class Italic implements IFoodMenu{

	@Override
	public List<String> showMenu() {
		List<String> italicMenu = Arrays.asList("Truffles", "Gelato", "pizza", "Palenta");
		return italicMenu;
	}

}
