package utilisateur;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
 * Servlet implementation class ServletProfil
 */
@WebServlet("/ServletProfil")
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/Profil.jsp";
	private String sexe;
	private String imc;
	HttpSession session;
	Utilisateur user;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		user= (Utilisateur) session.getAttribute("utilisateur");
		user.calculIMC();
		user.setIMC(AfficherIMC(user.getIMC()));
		
		/* Date de naissance  */
		Date dateNaissance = user.getDateNaissance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		request.setAttribute("dateNaissance", dateFormat.format(dateNaissance));
		
		/////	Affichage du sex	/////
		if(user.getSexe().equals("F")) {
			sexe = "Féminin";
		}else {
			sexe = "Masculin";
		}
		
		/////	Affichage IMC	/////
		DecimalFormat format = new DecimalFormat("########.00");
		format.setMaximumFractionDigits(2);
		imc = format.format(user.getIMC());
		
		///// retour des paramètre à la vue	/////
		request.setAttribute("dateNaissance", dateFormat.format(dateNaissance));
		request.setAttribute("user", user);
		request.setAttribute("sexe", sexe);
		request.setAttribute("imc", imc);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public double AfficherIMC(double imc) {
		double nbr;
		return nbr = Math.round(imc*100)/100;
	}

}
