package fr.formation.tetris.dao;

import fr.formation.tetris.model.Piece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPieceRepository extends JpaRepository<Piece, Integer> {

}
