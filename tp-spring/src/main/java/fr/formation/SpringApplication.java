package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.musique.IMusicien;

//@Component
public class SpringApplication {
	@Autowired
	private IMusicien musicien;
	
	public void run() {
		musicien.jouer();
	}
}