package journee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Journee;
import model.List_Journee;
import model.List_Seance;
import model.Seance;
import model.Utilisateur;

/**
 * Servlet implementation class ServletMesJournees
 */
@WebServlet("/ServletMesJournees")
public class ServletMesJournees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/MesJournees.jsp";
	private List<Journee> list_journee;
	private List_Journee liste;
	HttpSession session;
	Utilisateur user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMesJournees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération session */
		session=request.getSession();
		if(session.isNew()) {
			session.invalidate();
			session=request.getSession();
		}
		
		user = (Utilisateur)session.getAttribute("utilisateur");
		liste = new List_Journee();
		list_journee = new ArrayList<Journee>();
		liste.FindList_journee_user(user.getId());
		list_journee = liste.getList_journee();
		
		for(Journee j : list_journee) {
			j.calculConsommation();
		}
		
		request.setAttribute("listeJournee", list_journee);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
