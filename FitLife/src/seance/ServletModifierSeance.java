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
@WebServlet("/ServletModifierSeance")
public class ServletModifierSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/ModifierSeance.jsp";
	private Seance maSeance = new Seance();
	private List_Exercice liste;
	private int nbrRep;
	List <Exercice> listeExercices  = new LinkedList<>();
	private List<Exercice> listeAfficher;
	private Exercice exo = new Exercice();
	HttpSession session;
	Utilisateur user;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierSeance() {
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
		maSeance = (Seance) session.getAttribute("seance");
		String typeExo;
		liste = new List_Exercice();
		listeExercices = (List<Exercice>) liste.getList();
		typeExo = (String) request.getParameter("liste");
		listeAfficher = new LinkedList<>();
		if(typeExo != null) {
			for(Exercice e : listeExercices) {
				if(e.getType().equals(typeExo)) {
					listeAfficher.add(e);
				}
			}
		}
		request.setAttribute("listeExo", maSeance.getList_exercice());
		request.setAttribute("listeExercices", listeAfficher);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nbrRep = Integer.parseInt(request.getParameter("nbrRep"));
		exo = listeAfficher.get(Integer.parseInt(request.getParameter("exercice")));
		System.out.println(exo.getNom());
		maSeance.AjouterExercice(exo, nbrRep);
		doGet(request, response);
	}

}
