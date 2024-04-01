package com.example.javabased;

import java.util.Arrays;
import java.util.List;

public class Italic implements IFoodMenu{

	@Override
	public List<String> showMenu() {
		List<String> italicMenu = Arrays.asList("Truffles", "Gelato", "pizza", "Palenta");
		return italicMenu;
	}

}
