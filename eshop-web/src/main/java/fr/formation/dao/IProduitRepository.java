package fr.formation.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Produit;
import fr.formation.projection.ProduitProjection;
import fr.formation.projection.ProduitSpectificProjection;

public interface IProduitRepository extends JpaRepository<Produit, Integer> {
//	public List<Produit> findAllByOrderBetweenAndFournisseurIdOrderByIdDesc(int a, int b, int fournisseurId);
	
	public List<Produit> findByFournisseurIdOrderByPrixDesc(int fournisseurId);
	
//	public List<Produit> findByFournisseurId(int fournisseurId, Pageable page);
	public int countByFournisseurId(int fournisseurId);
	
	//PAGINE ET COMPTE LE NOMBRE TOTAL D'ELEMENTS
	public Page<Produit> findByFournisseurId(int fournisseurId, Pageable page);
	
	@Query("select p from Produit p where p.fournisseur.id = ?1")
	public List<Produit> findByFournisseurIdQuery(int fournisseurId);
	
	@Query("select p from Produit p where p.fournisseur.id = :id")
	public List<Produit> findByFournisseurIdNamedQuery(@Param("id") int fournisseurId);
	
	@Query("select p from Produit p")
	public List<ProduitProjection> findAllProjection();
	
	@Query("select p.id, p.nom, (select count(distinct pr) from Fournisseur f left join f.produits pr where f = p.fournisseur) as countProduits from Produit p")
	public List<ProduitSpectificProjection> findAllSpecificProjection();
	
	@Query(value = "SELECT * FROM produit", nativeQuery = true)
	public List<Produit> findAllNativeQuery();
}