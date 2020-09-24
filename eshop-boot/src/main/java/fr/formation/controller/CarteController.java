package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Carte;
import fr.formation.service.CarteService;

@Controller
@RequestMapping("/carte")
public class CarteController {
	@Autowired
	private CarteService srvCarte;
	
	@GetMapping("/liste")
	public String findAll(Model model) {
		model.addAttribute("cartes", this.srvCarte.findAll());
		
		return "carte/liste";
	}
	
	@GetMapping("/ajouter")
	public String add() {
		return "carte/form";
	}
	
	@PostMapping("/ajouter")
	public String add(Carte carte) {
		this.srvCarte.add(carte);
		
		return "redirect:./liste";
	}
	
	@GetMapping("/editer")
	public String edit(@RequestParam int id, Model model) {
		model.addAttribute("carte", this.srvCarte.findById(id));
		
		return "carte/form";
	}
	
	@PostMapping("/editer")
	public String edit(@RequestParam int id, Carte carte) {
		this.srvCarte.edit(id, carte);
		
		return "redirect:./liste";
	}
	
	@GetMapping("/supprimer/{id}")
	public String deleteById(@PathVariable int id) {
		this.srvCarte.deleteById(id);
		
		return "redirect:../liste";
	}
}