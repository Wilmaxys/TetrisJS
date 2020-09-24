package fr.formation.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ProduitProjection {
	public int getId();
	public String getNom();
	
	@Value("#{target.nom}")
	public String getLibelle();
	
	@Value("#{target.fournisseur.nom}")
	public String getFournisseurNom();
}