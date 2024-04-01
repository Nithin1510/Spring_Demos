package com.assignment.restaurant;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Chinese implements IFoodMenu{

	@Override
	public List<String> showMenu() {
		List<String> chineseMenu = Arrays.asList("Sushi", "Noodles", "Gobi", "Fried rice");
		return chineseMenu;
	}

}
