package utilisateur;

import java.io.IOException;
import java.text.DecimalFormat;
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
	private String messageIMC;
	private String couleurMessage;
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
		/////	Message IMC	/////
		afficherMessageIMC();
		///// retour des paramètre à la vue	/////
		request.setAttribute("dateNaissance", dateFormat.format(dateNaissance));
		request.setAttribute("user", user);
		request.setAttribute("sexe", sexe);
		request.setAttribute("imc", imc);
		request.setAttribute("messageIMC", messageIMC);
		request.setAttribute("couleurMessage", couleurMessage);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/***
	 * Récupération d'un message et de sa couleur selon l'imc
	 */
	public void afficherMessageIMC() {
		double nbr = user.getIMC();
		if(nbr > 40) {
			messageIMC = "+ de 40 obésité morbide ou massive";
			couleurMessage="Red";
		}else if(nbr <= 40 && nbr > 35) {
			messageIMC = "35 à 40 obésité sévère";
			couleurMessage="Maroon";
		}else if(nbr <= 35 && nbr > 30) {
			messageIMC = "30 à 35 obésité modérée";
			couleurMessage="Olive";
		}else if(nbr <= 30 && nbr > 25) {
			messageIMC = "25 à 30 surpoids";
			couleurMessage="MediumSpringGreen";
		}else if(nbr <= 25 && nbr > 18.5) {
			messageIMC = "18.5 à 25 corpulence normale";
			couleurMessage="Green";
		}else if(nbr <= 18.5 && nbr > 16.5) {
			messageIMC = "16.5 à 18.5 maigreur";
			couleurMessage="Blue";
		}else {
			messageIMC = "- de 16.5 famine";
			couleurMessage="Silver";
		}
	}
}
