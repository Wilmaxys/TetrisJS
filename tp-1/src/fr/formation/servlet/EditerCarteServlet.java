package fr.formation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Carte;


@WebServlet("/carte/editer")
public class EditerCarteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//RECUPERER LA CARTE
		Carte carte = this.getCarte(req);
		
		//TRANSMETTRE LA CARTE A LA VUE (SCOPE REQUEST)
		req.setAttribute("carte", carte);
		
		//AFFICHE LA VUE
		this
			.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsp/carte/form.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//RECUPERER LA CARTE
		Carte carte = this.getCarte(req);
		
		carte.setNom(req.getParameter("nom"));
		
		resp.sendRedirect("liste");
	}
	
	
	private Carte getCarte(HttpServletRequest req) {
		//RECUPERER LE PARAMETRE "id", EN STRING QU'ON CONVERTIT APRES
		String idString = req.getParameter("id");
		int id = Integer.parseInt(idString);
		
		//RECUPERER LA LISTE DES CARTES (DU SCOPE APPLICATION)
		List<Carte> cartes = (List<Carte>)this.getServletContext().getAttribute("cartes");
		
		//RECUPERER LA CARTE
		return cartes
					.stream()
					.filter(c -> c.getId() == id)
					.findFirst()
					.orElseThrow();
	}
}