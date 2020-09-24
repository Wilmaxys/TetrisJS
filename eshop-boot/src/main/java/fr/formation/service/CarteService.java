package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.ICarteRepository;
import fr.formation.exception.CarteNotFoundException;
import fr.formation.model.Carte;

@Service
public class CarteService {
	@Autowired
	private ICarteRepository daoCarte;
	
	public List<Carte> findAll() {
		return this.daoCarte.findAll();
	}
	
	public void add(Carte carte) {
		this.daoCarte.save(carte);
	}
	
	@Deprecated
	public void edit(int id, Carte carte) {
		this.daoCarte.save(carte);
	}
	
	public void edit(Carte carte) {
		this.daoCarte.save(carte);
	}
	
	public Carte findById(int id) {
		return this.daoCarte.findById(id)
					.orElseThrow(CarteNotFoundException::new);
	}
	
	public void deleteById(int id) {
		this.daoCarte.deleteById(id);
	}
}