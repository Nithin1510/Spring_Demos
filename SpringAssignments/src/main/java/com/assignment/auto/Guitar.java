package com.assignment.auto;

import org.springframework.stereotype.Component;

@Component("guitarist")
public class Guitar implements IInstrument{

	@Override
	public void play(String song) {
		System.out.println("Guitar " + song);
	}

}
