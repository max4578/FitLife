package seance;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
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
	private String periode;
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
		
		System.out.println(request.getParameter("errorAjout"));
		request.setAttribute("erreurAjout", request.getParameter("errorAjout"));
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
		periode = request.getParameter("periode");
		seance = listeDesSeances.get(indexSeance);
		if(journee.AjouterSeance(seance, periode)) {
			session.setAttribute("journee", journee);
			response.sendRedirect("/FitLife"+VUE2);
		}else
		{
			response.sendRedirect("/FitLife/AjouterSeance?errorAjout=Erreur: la seance est deja presente a la meme periode");
		}
		
	}

}
