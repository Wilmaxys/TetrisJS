package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.exception.CarteNotFoundException;
import fr.formation.model.Carte;

@Service
public class CarteService {
	private static int id = 1;
	private List<Carte> cartes;
	
	public List<Carte> findAll() {
		return this.cartes;
	}
	
	public void add(Carte carte) {
		if (this.cartes == null) {
			this.cartes = new ArrayList<>();
		}
		
		carte.setId(id++);
		this.cartes.add(carte);
	}
	
	public void edit(int id, Carte carte) {
		Carte carteToEdit = this.findById(id);
		
		carteToEdit.setNom(carte.getNom());
	}
	
	public Carte findById(int id) {
		return this.cartes
					.stream()
					.filter(c -> c.getId() == id)
					.findFirst()
					.orElseThrow(CarteNotFoundException::new);
	}
	
	public void deleteById(int id) {
		this.cartes.removeIf(c -> c.getId() == id);
	}
}