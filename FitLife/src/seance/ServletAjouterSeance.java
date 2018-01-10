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

import model.Journee;
import model.List_Seance;
import model.Seance;
import model.Utilisateur;

/**
 * Servlet implementation class ServletAjouterSeance
 */

public class ServletAjouterSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/AjouterSeance.jsp";
	private static final String VUE2 = "/Journee";
	private List_Seance listeSeance;
	private List<Seance> listeDesSeances = new LinkedList<>();
	private Seance seance = new Seance();
	private Journee journee = new Journee();
	private int indexSeance;
	HttpSession session;
	Utilisateur user;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjouterSeance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/////	Récupération de la session	/////
		session=request.getSession();
		user = (Utilisateur) session.getAttribute("utilisateur");
		journee = (Journee) session.getAttribute("journee");
		
		/////	Envoie vers la vue une liste des seances de l'utilisateur	/////
		listeSeance = new List_Seance();
		listeDesSeances = listeSeance.getSeance(user.getId());
		request.setAttribute("listeSeance", listeDesSeances);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/////	Récupération de l'index de la séance de la liste utilisateur	/////
		indexSeance = Integer.parseInt(request.getParameter("numSeance"));
		System.out.println(indexSeance);
		seance = listeDesSeances.get(indexSeance);
		System.out.println(seance.getNom());
		journee.AjouterSeance(seance, "matin");
		session.setAttribute("journee", journee);
		this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);
	}

}
