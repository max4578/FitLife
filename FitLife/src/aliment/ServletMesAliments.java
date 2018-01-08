package aliment;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aliment;
import model.List_Aliment;
import model.List_Seance;
import model.Utilisateur;

/**
 * Servlet implementation class ServletMesAliments
 */
@WebServlet("/ServletMesAliments")
public class ServletMesAliments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/MesAliments.jsp";
	private List_Aliment listeAlim;
	private LinkedList<Aliment> liste= new LinkedList<Aliment>();
    private  HttpSession session;
    private Utilisateur user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMesAliments() {
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
		listeAlim= new List_Aliment();
		listeAlim.getList_Perso(user.getId());
		liste=listeAlim.getList_aliment();
		for(Aliment a: liste)
			System.out.println(a.getId());
		
		session.setAttribute("listeAlim", liste);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
