package fr.formation.dao;

import java.util.List;

import fr.formation.model.Produit;

public interface IProduitDao extends IDAO<Produit> {
	public List<Produit> findByFournisseurId(int fournisseurId);
}