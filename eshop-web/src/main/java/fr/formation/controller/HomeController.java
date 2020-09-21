package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	@RequestMapping(value = "/home", method = { RequestMethod.GET, RequestMethod.POST })
	@GetMapping
//	@PostMapping("/home")
	public String home(@RequestParam(required = false, defaultValue = "10") int id, Model model) {
//	public String home(@RequestParam(value = "username", defaultValue = "tata", required = false) String user) {
//		return "/WEB-INF/home.jsp";
		
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
}