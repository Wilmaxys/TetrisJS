package fr.formation.tetris.dao;

import fr.formation.tetris.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlockRepository extends JpaRepository<Block, Integer> {

}
