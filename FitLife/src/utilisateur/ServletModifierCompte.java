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
 * Servlet implementation class ServletModifierCompte
 */
@WebServlet("/ServletModifierCompte")
public class ServletModifierCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/ModifierCompte.jsp";
	private static final String VUE2 = "/Compte.jsp";
	public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PASS = "motdepasse";
    public static final String CHAMP_NOM = "nom";
    public static final String CHAMP_PRENOM = "prenom";
    public static final String CHAMP_SEXE = "sexe";
    public static final String CHAMP_ANNIVERSAIRE = "anniversaire";
    public static final String CHAMP_TAILLE = "taille";
    public static final String CHAMP_POIDS = "poids";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";
    Utilisateur user;
    HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierCompte() {
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
        String email = request.getParameter( CHAMP_EMAIL );
        String motDePasse = request.getParameter( CHAMP_PASS );
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter(CHAMP_PRENOM);
        String sexe = request.getParameter(CHAMP_SEXE);
        String anniversaire = request.getParameter(CHAMP_ANNIVERSAIRE);
        String taille = request.getParameter(CHAMP_TAILLE);
        String poids = request.getParameter(CHAMP_POIDS);
        
        
        Date dateAnniversaire=null;
        
       
        
        /* Gestion de la date */
        try {
        	
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	dateAnniversaire= sdf.parse(anniversaire);
			System.out.println("35464646:"+dateAnniversaire);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_EMAIL, e.getMessage() );
        }

        /* Validation du champ nom. */
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_NOM, e.getMessage() );
        }
        
        /* Validation du champ prenom. */
        try {
        	validationPrenom( prenom );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_PRENOM, e.getMessage() );
        }
        
        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            /* récupération des nouvelles information à renvoyez à la vue et update dans la DB */
            Utilisateur user= (Utilisateur)session.getAttribute("utilisateur");
            user.setNom(nom);
            user.setPrenom(prenom);
            user.setPassword(motDePasse);
            user.setSexe(sexe);
            user.setDateNaissance(dateAnniversaire);
            user.setTaille(Double.parseDouble(taille));
            try {
				user.ModifierInfoCompte();
				 request.setAttribute("user", user);
		         session.setAttribute("utilisateur", user);
			} catch (ParseException e) {
				e.printStackTrace();
			}
           
            /* Transmission de la paire d'objets request/response à notre JSP */
            this.getServletContext().getRequestDispatcher( VUE2 ).forward( request, response );
        } else {
            resultat = "Échec de l'inscription.";
            /* Stockage du résultat et des messages d'erreur dans l'objet request */
            request.setAttribute( ATT_ERREURS, erreurs );
            request.setAttribute( ATT_RESULTAT, resultat );
            /* Transmission de la paire d'objets request/response à notre JSP */
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }

	}

	/**
	 * Valide l'adresse mail saisie.
	 */
	private void validationEmail( String email ) throws Exception {
	    if ( email != null && email.trim().length() != 0 ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}

	/**
	 * Valide le nom d'utilisateur saisi.
	 */
	private void validationNom( String nom ) throws Exception {
	    if ( nom != null && nom.trim().length() < 3 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
	    }
	}
	
	/**
	 * Valide le prenom d'utilisateur saisi.
	 */
	private void validationPrenom( String prenom ) throws Exception {
	    if ( prenom.equals("") ) {
	        throw new Exception( "Entrez un prenom" );
	    }
	}

}
