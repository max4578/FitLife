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
 * Servlet implementation class ServletSeance
 */
@WebServlet("/ServletSeance")
public class ServletSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/Seances.jsp";
	ArrayList <Exercice> list_exercice = new ArrayList<Exercice>();
	
	
       
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
	/*	list_exercice.add(new Exercice("1","","",1,(double)1));
		list_exercice.add(new Exercice("2","","",1,(double)1));
		list_exercice.add(new Exercice("3","","",1,(double)1));
		list_exercice.add(new Exercice("4","","",1,(double)1));*/
		request.setAttribute("liste", list_exercice);
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
