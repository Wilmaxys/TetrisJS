package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IProduitRepository;
import fr.formation.exception.ProduitNotFoundException;
import fr.formation.model.Produit;

@Service
public class ProduitService {
	@Autowired
	private IProduitRepository daoProduit;
	
	public List<Produit> findAll() {
		return this.daoProduit.findAll();
	}
	
	public Produit findById(int id) {
		return this.daoProduit.findById(id).orElseThrow(ProduitNotFoundException::new);
	}
	
	public Produit save(Produit produit) {
		return this.daoProduit.save(produit);
	}
	
	public void deleteById(int id) {
		this.daoProduit.deleteById(id);
	}
}