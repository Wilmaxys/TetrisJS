package fr.formation.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // ANNOTATION OBLIGATOIRE POUR UNE ENTITE
@Table(name = "produit")
public class Produit {
	@Id // ANNOTATION OBLIGATOIRE - ID NECESSAIRE
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	@Column(name = "PRO_ID")
	private int id;

	@Column(name = "PRO_NOM", length = 50)
	private String nom;

	@Column(name = "PRO_PRIX", precision = 10, scale = 2)
	private BigDecimal prix;

	@Column(name = "PRO_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date date; //A NE PLUS UTILISER (normalement ...)
	private LocalDate date; // ou LocalDateTime
	
	@Column(name = "PRO_TYPE")
	@Enumerated(EnumType.ORDINAL) //.STRING POUR STOCKER EN VARCHAR
	private ProduitType type;
	
	@ManyToOne
	@JoinColumn(name = "PRO_FOURNISSEUR_ID")
	private Fournisseur fournisseur;
	
	@Transient //EXCLURE CET ATTRIBUT DE LA PERSISTENCE
	private String privateName;

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

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ProduitType getType() {
		return type;
	}

	public void setType(ProduitType type) {
		this.type = type;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
}