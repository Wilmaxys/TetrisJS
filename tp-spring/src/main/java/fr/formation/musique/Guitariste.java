package fr.formation.musique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("unSuperGuitariste") //ON DEMANDE A SPRING DE MANAGER L'INSTANCE, AVEC CE NOM LA
@Lazy
public class Guitariste implements IMusicien {
	@Autowired //DEMANDE A SPRING D'INJECTION LA DEPENDANCE
	@Qualifier("guitare")
	private IInstrument instrument;

//	public void setInstrument(IInstrument instrument) {
//		this.instrument = instrument;
//	}
	
	public Guitariste() {
		System.out.println("CONSTRUCTION DU GUITARISTE");
	}

	@Override
	public void jouer() {
		System.out.println("Le guitariste joue " + this.instrument);
	}
}