package utilisateur;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        	
        	//this.getServletContext().getRequestDispatcher( VUE2 ).forward( request, response );
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
