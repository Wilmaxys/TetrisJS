package fr.formation.model;

public class Carte {
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Carte() { }
	
	public Carte(String nom) {
		this.nom = nom;
	}
}