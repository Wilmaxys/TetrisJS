package fr.formation.tetris.model;

import javax.persistence.*;

@Entity
@Table(name = "block")
public class Block {

	public Block(){}
	public Block(int x, int y, Piece piece){
		this.coordinateX = x;
		this.coordinateY = y;
		this.piece = piece;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BLOCK_ID")
	private int id;
	
	@Column(name = "BLOCK_COORDINATE_X")
	private int coordinateX;
	
	@Column(name = "BLOCK_COORDINATE_Y")
	private int coordinateY;
	
	@ManyToOne
	@JoinColumn(name = "BLOCK_PIECE_ID")
	private Piece piece;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}
	public int getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}
