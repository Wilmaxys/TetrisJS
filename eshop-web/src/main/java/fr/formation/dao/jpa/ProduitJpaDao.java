package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IProduitDao;
import fr.formation.model.Produit;

@Repository
public class ProduitJpaDao implements IProduitDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Produit> findAll() {
		return em.createQuery("select p from Produit p", Produit.class)
				.getResultList();
	}

	@Override
	public Produit findById(int id) {
//		return em.createQuery("select p from Produit p where p.id = ?", Produit.class)
//				.setParameter(1, id)
//				.getSingleResult();
		
		return em.find(Produit.class, id);
	}

	@Override
	@Transactional
	public Produit save(Produit entity) {
		if (entity.getId() == 0) { //AJOUT
			em.persist(entity);
		}
		
		else { //UPDATE
			entity = em.merge(entity);
		}
		
		return entity;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		em.createQuery("delete from Produit p where p.id = ?")
			.setParameter(1, id)
			.executeUpdate();
		
//		em.remove(this.findById(id));
	}

	@Override
	public List<Produit> findByFournisseurId(int fournisseurId) {
		return em.createQuery("select p from Produit p where p.fournisseur.id = ?", Produit.class)
				.setParameter(1, fournisseurId)
				.getResultList();
	}
}