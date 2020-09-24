package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Carte;

public interface ICarteRepository extends JpaRepository<Carte, Integer> {
	public Carte findByIdAndNom(int id, String nom);
	
	@Query("select c from Carte c where c.id = ?1 and c.nom = ?2")
	public Carte findByIdAndNomQuery(int id, String nom);
}