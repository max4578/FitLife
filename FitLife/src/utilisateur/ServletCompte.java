package utilisateur;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utilisateur;

/**
 * Servlet implementation class ServletCompte
 */
@WebServlet("/ServletCompte")
public class ServletCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/Compte.jsp";
	private String sexe;  
	HttpSession session;
	Utilisateur user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		session=request.getSession();
		user= (Utilisateur) session.getAttribute("utilisateur");
		
		//////	Affichage de date de naissance	/////
		Date dateNaissance = user.getDateNaissance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		/////	Affichage du sex	/////
		if(user.getSexe().equals("F")) {
			sexe = "Féminin";
		}else {
			sexe = "Masculin";
		}
		
		///// retour des paramètre à la vue	/////
		request.setAttribute("user", user);
		request.setAttribute("dateNaissance", dateFormat.format(dateNaissance));
		request.setAttribute("sexe", sexe);
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
