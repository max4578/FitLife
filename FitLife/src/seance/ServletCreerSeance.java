package seance;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Exercice;

/**
 * Servlet implementation class ServletCreerSeance
 */
@WebServlet("/ServletCreerSeance")
public class ServletCreerSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/CreerSeance.jsp";
	ArrayList <Exercice> listeExercice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreerSeance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listeExercice = new ArrayList<Exercice>();
		listeExercice.add(new Exercice("Curl Biceps","","Bras",1,(double)1));
		listeExercice.add(new Exercice("Press","","Jambes",1,(double)1));
		listeExercice.add(new Exercice("Tortank","","Dos",1,(double)1));
		listeExercice.add(new Exercice("Barre inclinées","","Epaules",1,(double)1));
		request.setAttribute("liste", listeExercice);
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
