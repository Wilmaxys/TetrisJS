package fr.formation.tetris.service;

import fr.formation.tetris.dao.IBlockRepository;
import fr.formation.tetris.exception.BlockNotFoundException;
import fr.formation.tetris.model.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {

	@Autowired
	private IBlockRepository daoBlock;
	
	public List<Block> findAll() {
		return this.daoBlock.findAll();
	}
	
	public Block findById(int id) {
		return this.daoBlock.findById(id)
				.orElseThrow(BlockNotFoundException::new);
	}
	
	public Block save(Block block) {
		return this.daoBlock.save(block);
	}
	
	public void deleteById(int id) {
		this.daoBlock.deleteById(id);
	}
}
