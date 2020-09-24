package fr.formation.tetris.service;

import fr.formation.tetris.dao.IPieceRepository;
import fr.formation.tetris.exception.PieceNotFoundException;
import fr.formation.tetris.model.Piece;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PieceService {
	@Autowired
	private IPieceRepository daoPiece;

	@Transactional
	public List<Piece> findAllPieceWithBlock() {
		List<Piece> liste = this.findAll();

		liste.forEach(piece -> {
			Hibernate.initialize(piece.getBlocks());
		});

		return liste;
	}

	public List<Piece> findAll() {
		return this.daoPiece.findAll();
	}

	public void add(Piece piece) {
		this.daoPiece.save(piece);
	}
	
	public Piece findById(int id) {
		return this.daoPiece.findById(id)
				.orElseThrow(PieceNotFoundException::new);
	}
	
	public Piece save(int id, Piece piece) {
		return this.daoPiece.save(piece);
	}
	
	public void deleteById(int id) {
		this.daoPiece.deleteById(id);
	}
}
