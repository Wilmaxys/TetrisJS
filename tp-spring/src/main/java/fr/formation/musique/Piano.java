package fr.formation.musique;

import org.springframework.stereotype.Component;

@Component
public class Piano implements IInstrument {
	@Override
	public String toString() {
		return "PLAK PLAK PLAK";
	}
}