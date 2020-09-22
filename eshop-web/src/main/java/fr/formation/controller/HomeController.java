package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Produit;

@Controller
@RequestMapping("/home")
public class HomeController {
	@GetMapping
	public String home(@RequestParam(required = false, defaultValue = "10") int id, Model model) {
		model.addAttribute("id", id);
		
		return "home";
	}
	
	@PostMapping
	public String postHome() {
		return "redirect:/home";
	}
	
	@GetMapping("/{iduser}")
	public String demoPV(@PathVariable("iduser") int id) {
		return "home";
	}
	
	@PostMapping("/demo")
	public String postDemo(Produit produit) {
		return "redirect:/home";
	}
}