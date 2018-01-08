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

import model.List_Seance;
import model.Seance;
import model.Utilisateur;

/**
 * Servlet implementation class ServletSeance
 */

public class ServletSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/Seance.jsp";
	private List_Seance listeSeances;
	private List <Seance> mesSeances  = new LinkedList<>();
	private Seance maSeance = new Seance();
	private int numeroSeance;
	private HttpSession session;
	private Utilisateur user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSeance() {
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
		numeroSeance = Integer.parseInt(request.getParameter("seance"));
		listeSeances = new List_Seance();
		mesSeances = listeSeances.getSeance(user.getId());
		maSeance =(Seance) mesSeances.get(numeroSeance);
		session.setAttribute("seance",maSeance);
		request.setAttribute("seance", maSeance );
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
