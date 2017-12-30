package utilisateur;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utilisateur;

/**
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/ServletModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/ModifierProfil.jsp";
	public static final String CHAMP_POIDS = "poids";
	Utilisateur user;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierProfil() {
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
		user= (Utilisateur) session.getAttribute("utilisateur");
		request.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String resultat;
	    Map<String, String> erreurs = new HashMap<String, String>();
		/* Récupération des champs du formulaire. */

        String poids = request.getParameter(CHAMP_POIDS);
          
        /* Gestion de la date */
        user= (Utilisateur) session.getAttribute("utilisateur");
        user.setPoids(Double.parseDouble(poids));
		try {
			user.ModifierInfoCompte();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    request.setAttribute("user", user);	         
	    session.setAttribute("utilisateur", user);

	    /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
       
	}

}
