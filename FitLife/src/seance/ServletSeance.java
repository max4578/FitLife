package seance;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Seance;

/**
 * Servlet implementation class ServletSeance
 */

public class ServletSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/Seance.jsp";
	private Seance maSeance = new Seance();
	private HttpSession session;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/////	Récupération de la session en cours pour récupérer la séance	/////
		session=request.getSession();
		maSeance = (Seance) session.getAttribute("seance");
		
		/////	Envoie l'objet séance vers la vue	///// 
		request.setAttribute("seance", maSeance );
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
