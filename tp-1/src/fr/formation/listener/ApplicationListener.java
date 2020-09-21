package fr.formation.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.formation.model.Carte;

@WebListener
public class ApplicationListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Carte> mesCartes = new ArrayList<>();

		mesCartes.add(new Carte(1, "AS DE TREFFLE"));
		mesCartes.add(new Carte(2, "QUI PIQUE"));
		mesCartes.add(new Carte(3, "TON COEUR"));
		
		sce.getServletContext().setAttribute("cartes", mesCartes);
	}
}