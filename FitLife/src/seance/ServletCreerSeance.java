package seance;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Seance;
import model.Utilisateur;

/**
 * Servlet implementation class ServletCreerSeance
 */


public class ServletCreerSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/CreerSeance.jsp";
	private static final String VUE2 = "/Seances";
	Seance seance;
	HttpSession session;
	Utilisateur user;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		user = (Utilisateur) session.getAttribute("utilisateur");
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		seance = new Seance();
		seance.setNom(request.getParameter("nom"));
		seance.AjouterSeance(user.getId());
		this.getServletContext().getRequestDispatcher( VUE2 ).forward( request, response );
	}

}
