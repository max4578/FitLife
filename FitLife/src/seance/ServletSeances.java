package seance;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Exercice;
import model.List_Seance;
import model.Seance;
import model.Utilisateur;

/**
 * Servlet implementation class ServletSeances
 */

public class ServletSeances extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/Seances.jsp";
	private List_Seance listeSeances;
	HttpSession session;
	Utilisateur user;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSeances() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		if(session.isNew()) {
			session.invalidate();
			session=request.getSession();
		}
		user = (Utilisateur) session.getAttribute("utilisateur");
		listeSeances = new List_Seance();
		request.setAttribute("listeSeance", listeSeances.getSeance(user.getId()));
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
