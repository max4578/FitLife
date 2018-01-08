package journee;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aliment;
import model.Consommation;
import model.Exercice;
import model.Journee;
import model.Seance;
import model.Utilisateur;

/**
 * Servlet implementation class ServletJournee
 */
@WebServlet("/ServletJournee")
public class ServletJournee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JOURNEE = "journee";
	private static final String VUE = "/Journee.jsp";
	private List<Seance> listSeance;
	private List<Consommation> list_c;
	ArrayList <Exercice> list_exercice;
	private String msgListeSeanceVide = "!!! Aucune séance n'a été effectuée aujourd'hui !!! ON SE MOTIVE";
	private String msgListeConsommationVide = "Aucun aliment consommé aujourd'hui";
	private double calorie;
	private Journee journee;

	HttpSession session;
	Utilisateur user;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJournee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération session */
		session=request.getSession();
		if(session.isNew()) {
			session.invalidate();
			session=request.getSession();
		}
		
		user = (Utilisateur)session.getAttribute("utilisateur");
		/* Création et ajout de la journée si elle n'est pas dans la session */
		if(session.getAttribute("journee") == null) {
			journee = new Journee();
			journee.NouvelleJournee(user.getId());
			session.setAttribute("journee", journee);
		}
		
		/* Date du jour  */
		LocalDate date = LocalDate.now();
	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
	    String jour = date.format(formatters);
		request.setAttribute(JOURNEE, jour);
		
		/* Récupérer la liste des séances */
		listSeance = new ArrayList<Seance>();
		list_exercice = new ArrayList<Exercice>();
		
		listSeance = journee.getListSeance();
		
		/* Récupération des besoin journalier de l'utilisateur */
		user= (Utilisateur) session.getAttribute("utilisateur");
		calorie = user.getMetabolisme();
		if(listSeance.size() == 0) {
			user.Besoin(calorie);
		}else {
			calorie*=1.4;
			user.Besoin(calorie);
		}
		
		/* Information sur la journée */
		journee.calculConsommation();
		/* Récupérer la liste des aliments */
		list_c = new ArrayList<Consommation>();
		list_c = journee.getListConsom();
		
		/* Liste séance(s) */
		if(listSeance.isEmpty()) {
			request.setAttribute("ListeSeanceVide",msgListeSeanceVide);
		}else {
			request.setAttribute("ListeSeance",listSeance);
		}
		
		/* Liste aliment(s) consommé */
		if(list_c.isEmpty()) {
			request.setAttribute("ListeConsommationVide",msgListeConsommationVide);
		}else {
			request.setAttribute("ListeConsommation",list_c);
		}
		
		/////////////////// Vers la vue ///////////////////////
		//Besoin de l'utilisateur
		request.setAttribute("calorie", calorie);
		request.setAttribute("proteine", user.getBesoin_proteine());
		request.setAttribute("lipide", user.getBesoin_lipide());
		request.setAttribute("glucide", user.getBesoin_glucide());
		//Consommation de la journée
		request.setAttribute("calorieConsomme", journee.getCalorie_consom());
		request.setAttribute("proteineConsommee", journee.getProteine_consom());
		request.setAttribute("lipideConsomme", journee.getLipide_consom());
		request.setAttribute("glucideConsomme", journee.getGlucide_consom());
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
