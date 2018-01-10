package seance;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Exercice;
import model.List_Exercice;
import model.Seance;
import model.Utilisateur;

/**
 * Servlet implementation class ServletModifierSeance
 */

public class ServletModifierSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/ModifierSeance.jsp";
	private static final String VUE2 = "/Seances";
	private Seance maSeance;
	private List_Exercice liste;
	private String nbrRep;
	private String typeExo;
	private List <Exercice> listeExercices  = new LinkedList<>();
	private List<Exercice> listeAfficher;
	private Exercice exo = new Exercice();
	HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/////	R�cup�ration de la session en cours	/////
		session=request.getSession();
		maSeance = (Seance) session.getAttribute("seance");
		
		/////	Cr�ation de la liste des �xercices selon le type choisi	/////
		liste = new List_Exercice();
		listeExercices = (List<Exercice>) liste.getList();
		
		/////	Cr�ation de la liste des �xercices selon le type choisi	/////
		listeAfficher = new LinkedList<>();
		typeExo = (String) request.getParameter("liste");
		if(typeExo != null) {
			for(Exercice e : listeExercices) {
				if(e.getType().equals(typeExo)) {
					listeAfficher.add(e);
				}
			}
		}

		/////	Envoie des param�tres vers la vue	/////
		request.setAttribute("listeExo", maSeance.getList_exercice());
		request.setAttribute("listeExercices", listeAfficher);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/////	R�cup�ration des param�tres de la vue	/////
		nbrRep = request.getParameter("nbrRep");
		exo = listeAfficher.get(Integer.parseInt(request.getParameter("exercice")));
		
		/////	Ajout de l'exercice � la liste des exercices de la s�ance	/////
		maSeance.AjouterExercice(exo, Integer.parseInt(nbrRep));
		/////	Mettre � jours la s�ance dans la session	/////
		session.setAttribute("seance", maSeance);
		doGet(request, response);
	}

}
