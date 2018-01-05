package seance;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Exercice;
import model.Seance;

/**
 * Servlet implementation class ServletSeance
 */

public class ServletSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/Seances.jsp";
	ArrayList <Seance> listSeance;
	ArrayList <Exercice> list_exercice;

       
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
		list_exercice = new ArrayList<Exercice>();
		listSeance = new ArrayList<Seance>();
		list_exercice.add(new Exercice("Curl Biceps","","Bras",1,(double)1));
		list_exercice.add(new Exercice("Press","","Jambes",1,(double)1));
		list_exercice.add(new Exercice("Tortank","","Dos",1,(double)1));
		list_exercice.add(new Exercice("Barre inclinées","","Epaules",1,(double)1));
		
		listSeance.add(new Seance(list_exercice,"Séance du lundi"));
		listSeance.add(new Seance(list_exercice,"Séance du mardi"));
		listSeance.add(new Seance(list_exercice,"Séance du mercredi"));
		request.setAttribute("liste", listSeance);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
