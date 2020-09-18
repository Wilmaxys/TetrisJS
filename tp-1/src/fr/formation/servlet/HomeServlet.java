package fr.formation.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Utilisateur;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//RECUPERER LE PARAMETRE DE REQUETE
		String myUsername = req.getParameter("username");
		
		//TRANSFERER L'INFO A LA VUE (EN PASSANT PAR LES ATTRIBUTS)
		//ON PASSE PAR LE SCOPE "REQUEST"
		req.setAttribute("utilisateur", myUsername);
		
		req.setAttribute("prenoms", Arrays.asList("Marc", "Olivier", "Julie", "Margaux"));
		
		//!, L'ORDRE EST IMPORTANT, ON TRANSMET AVANT DE TRANSFERER
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsp/demo.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myUsername = req.getParameter("username");
		String myPassword = req.getParameter("password");
		Utilisateur myUtilisateur = new Utilisateur(myUsername, myPassword);
		
		//ON AJOUTE LA VALEUR DANS LE SCOPE SESSION
//		req.getSession().setAttribute("util", myUsername);
		req.getSession().setAttribute("util", myUtilisateur);
		
		
		//ON REDIRIGE VERS LE DOGET
//		this.doGet(req, resp); //CA C'EST PAS UNE REDIRECTION
		resp.sendRedirect("home"); //CA C'EST UNE REDIRECTION
	}
}