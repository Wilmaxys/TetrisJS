package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carte")
public class Carte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CART_ID")
	private int id;
	
	@Column(name = "CART_NOM", length = 25)
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
}