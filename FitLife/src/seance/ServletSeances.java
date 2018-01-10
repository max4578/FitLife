package seance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.List_Seance;
import model.Seance;
import model.Utilisateur;

/**
 * Servlet implementation class ServletSeances
 */

public class ServletSeances extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/Seances.jsp";
	private static final String VUE2 = "/Seance";
	private List_Seance listeSeances;
	private String numSeance;
	private String idSeance;
	Seance seance;
	HttpSession session;
	Utilisateur user;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/////	Récupération de la session	/////
		session=request.getSession();
		session.setAttribute("seance", null);
		user = (Utilisateur) session.getAttribute("utilisateur");
		
		/////	Envoie vers la vue la liste des séances de l'utilisateur	/////
		listeSeances = new List_Seance();
		request.setAttribute("listeSeance", listeSeances.getSeance(user.getId()));
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/////	Récupération des paramètres de la vue	/////
		idSeance = request.getParameter("idSeance");
		numSeance = request.getParameter("seance");

		if(idSeance != null) {
		/////	Je retire la séance	/////
			seance = new Seance();
			seance.setId(Integer.parseInt(idSeance));
			seance.SupprimerSeance();
			doGet(request, response);
		}else if(numSeance != null){
		/////	Je vais voir la seance	/////
			seance = new Seance();
			seance = listeSeances.getSeance(user.getId()).get(Integer.parseInt(numSeance));
			session.setAttribute("seance", seance);
			response.sendRedirect( "/FitLife" + VUE2 );
		}else {
			doGet(request, response);
		}
		
	}
}
