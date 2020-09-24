package fr.formation.tetris.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "piece")
public class Piece {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PIECE_ID")
	private int id;

	@Column(name = "PIECE_SIZE")
	private int size;
	
	@OneToMany(mappedBy = "piece", cascade = CascadeType.ALL)
	private List<Block> blocks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean contains(int x, int y){
		boolean contain = false;

		if (blocks != null){
			for (Block block :blocks) {
				if (block.getCoordinateX() == x && block.getCoordinateY() == y)
				{
					contain = true;
				}
			}
		}
		return contain;
	}
}
