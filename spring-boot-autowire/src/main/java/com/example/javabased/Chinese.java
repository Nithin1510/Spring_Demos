package com.example.javabased;

import java.util.Arrays;
import java.util.List;

public class Chinese implements IFoodMenu{

	@Override
	public List<String> showMenu() {
		List<String> chineseMenu = Arrays.asList("Sushi", "Noodles", "Gobi", "Fried rice");
		return chineseMenu;
	}

}
