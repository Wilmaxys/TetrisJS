package fr.formation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Carte;

@WebServlet("/carte/supprimer")
public class SupprimerCarteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//RECUPERER LE PARAMETRE "id", EN STRING QU'ON CONVERTIT APRES
		String idString = req.getParameter("id");
		int id = Integer.parseInt(idString);
		
		//RECUPERER LA LISTE DES CARTES (DU SCOPE APPLICATION)
		List<Carte> cartes = (List<Carte>)this.getServletContext().getAttribute("cartes");
		
		//SUPPRIMER LA CARTE DONT L'ID ==
		cartes.removeIf(c -> c.getId() == id);
		
		//REDIRIGER VERS LA LISTE
		resp.sendRedirect("liste");
	}
}