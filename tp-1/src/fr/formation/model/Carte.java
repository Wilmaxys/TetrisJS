package fr.formation.model;

public class Carte {
	private int id;
	private String nom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Carte() {
	}

	public Carte(String nom) {
		this.nom = nom;
	}

	public Carte(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
}