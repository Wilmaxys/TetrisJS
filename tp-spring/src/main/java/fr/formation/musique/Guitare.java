package fr.formation.musique;

import org.springframework.stereotype.Component;

@Component
//@Primary //ON DEMANDE A SPRING QU'IL EST PRIORITAIRE PAR RAPPORT AUX AUTRES BEAN DU MEME TYPE
public class Guitare implements IInstrument {
	@Override
	public String toString() {
		return "GLINK GLINK GLINK";
	}
}