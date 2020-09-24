package fr.formation.tetris.controller;

import fr.formation.tetris.model.Block;
import fr.formation.tetris.model.Piece;
import fr.formation.tetris.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tetris")
public class TetrisController {

	@Autowired
	private PieceService pieceService;

	@GetMapping("/list")
	public String findAll(Model model) {
		List<Piece> pieces = this.pieceService.findAllPieceWithBlock();
		model.addAttribute("pieces", pieces);

		for (Piece piece: pieces)
		{
			System.out.println("piece");
			for (Block block : piece.getBlocks()){
				System.out.println(block.getCoordinateX());
			}
		}

		return "tetris/list";
	}

	@GetMapping("/play")
	public String play() {
		return "tetris/tetris";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("pieceAdd", new Piece());
		return "tetris/form";
	}

	@PostMapping("/add")
	public String add(@RequestParam(value = "blocks[]") String[] blocks) {
		Piece piece = new Piece();
		piece.setSize(4);

		List<Block> blocksList = new ArrayList<Block>();

		for (String block: blocks){
			String[] coord = block.split(",");
			blocksList.add(new Block(Integer.parseInt(coord[0]),Integer.parseInt(coord[1]), piece));
		}

		piece.setBlocks(blocksList);
		this.pieceService.add(piece);

		return "redirect:/tetris/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam int id, Model model) {
		Piece piece = pieceService.findById(id);

		if (piece != null){
			model.addAttribute("pieceAdd", piece);
		}
		else{
			return "redirect:/tetris/list";
		}

		return "tetris/form";
	}

	@PostMapping("/edit")
	public String edit(@RequestParam int id, @RequestParam(value = "blocks[]") String[] blocks) {
		Piece piece = this.pieceService.findById(id);

		List<Block> blocksList = new ArrayList<>();

		for (String block: blocks){
			String[] coord = block.split(",");
			blocksList.add(new Block(Integer.parseInt(coord[0]),Integer.parseInt(coord[1]), piece));
		}

		piece.setBlocks(blocksList);
		this.pieceService.save(id,piece);

		return "redirect:/tetris/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		this.pieceService.deleteById(id);

		return "redirect:/tetris/list";
	}

	@GetMapping("/testAdd")
	public String testAdd() {
		Piece examplePiece = new Piece();
		examplePiece.setSize(3);
		List<Block> blocks = new ArrayList<Block>();

		Block block1 = new Block();
		block1.setCoordinateX(1);
		block1.setCoordinateY(1);
		blocks.add(block1);

		Block block2 = new Block();
		block2.setCoordinateX(1);
		block2.setCoordinateY(2);
		blocks.add(block2);

		Block block3 = new Block();
		block3.setCoordinateX(1);
		block3.setCoordinateY(3);
		blocks.add(block3);

		Block block4 = new Block();
		block4.setCoordinateX(2);
		block4.setCoordinateY(2);
		blocks.add(block4);

		examplePiece.setBlocks(blocks);

		for (Block block:
			 examplePiece.getBlocks()) {
			block.setPiece(examplePiece);
		}

		this.pieceService.add(examplePiece);


		return "redirect:/tetris/list";
	}

}
