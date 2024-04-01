package com.assignment.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Performer {
	
	@Autowired
	@Qualifier("violin")
	IInstrument instrument;
	
	@Autowired
	IInstrument keyboard;
	
	@Autowired
	private IInstrument guitarist;

	
	public IInstrument getGuitarist() {
		return guitarist;
	}
	
	public Performer(IInstrument guitarist) {
		super();
		this.guitarist = guitarist;
	}

	void playMusic(String choice, String song) {
		if(choice.equals("v"))
			instrument.play(song);
		if(choice.equals("g"))
			guitarist.play(song);
		if(choice.equals("k"))
			keyboard.play(song);
	}	
}
