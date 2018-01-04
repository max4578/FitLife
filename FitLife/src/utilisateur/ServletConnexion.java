package utilisateur;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aliment;
import model.Aliment_Admin;
import model.Aliment_Utilisateur;
import model.List_Aliment;
import model.List_Journee;
import model.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/Connexion.jsp";
	public static final String VUE2 = "/Accueil.jsp";
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PASS = "motdepasse";
    public static final String ATT_ERREURS  = "erreurs";
    HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession();
		if(session.isNew()) {
			session.invalidate();
			session=request.getSession();
			
		}

		
		/* Récupération des champs du formulaire. */
        String email = request.getParameter( CHAMP_EMAIL );
        String motDePasse = request.getParameter( CHAMP_PASS );
        Map<String, String> erreurs = new HashMap<String, String>();
        
        /* Vérification que le champs n'est pas vide */
        try {
        	checkChamps( email );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_EMAIL, e.getMessage() );
        }
        
        /* Validation du champ email. */
        try {
        	checkChamps( motDePasse );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_PASS, e.getMessage() );
        }
        
        if(erreurs.isEmpty()) {
        	/* créer la session */
        	Utilisateur u =  new Utilisateur();
        	if(u.connexion(email, motDePasse)) {
        		List_Journee j= new List_Journee();
        		j.FindList_journee_user(u.getId());
        		session.setAttribute("journee_user", j.getList_journee());
        		session.setAttribute("utilisateur", u);
        		this.getServletContext().getRequestDispatcher( VUE2 ).forward( request, response );
        	}
        	else 
        	{
        		erreurs.put("login", "Combinaison login/password incorrect");
        	}
        	

        }else {
        	/* Stockage des messages d'erreur dans l'objet request */
            request.setAttribute( ATT_ERREURS, erreurs );
            /* Transmission de la paire d'objets request/response à notre JSP */
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
		
        
	}

	/**
	 * Vérifie que le champs est saisi.
	 */
	private void checkChamps( String prenom ) throws Exception {
	    if ( prenom.equals("") ) {
	        throw new Exception( "Ce champs est obligatoire" );
	    }
	}
	
}
