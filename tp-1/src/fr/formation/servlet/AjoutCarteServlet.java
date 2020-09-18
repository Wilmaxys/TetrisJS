package fr.formation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Carte;

@WebServlet("/carte/ajouter")
public class AjoutCarteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this
			.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsp/carte/form.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Carte myCarte = new Carte(req.getParameter("nom"));
		
		List<Carte> mesCartes = (List<Carte>)this.getServletContext().getAttribute("cartes");
		
		mesCartes.add(myCarte);
		
		resp.sendRedirect("liste");
	}
}