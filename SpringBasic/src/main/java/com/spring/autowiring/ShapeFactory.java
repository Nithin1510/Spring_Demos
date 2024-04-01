package com.spring.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	
	@Autowired
	@Qualifier("rectangle")
	private IShape shape;
	
	@Autowired
	private IShape triangle;
	
	@Autowired
	private IShape shaper;

	public ShapeFactory(IShape shaper) {
		super();
		this.shaper = shaper;
	}

	void printArea(String choice, int x, int y) {
		if(choice.equals("r"))
			shape.area(x, y);
		if(choice.equals("t"))
			triangle.area(x, y);
		if(choice.equals("s"))
			shaper.area(x, y);
	}
}
