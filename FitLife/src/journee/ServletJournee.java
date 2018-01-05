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

import model.Exercice;
import model.Journee;
import model.List_Consommation;
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
	private List_Consommation list_c;
	ArrayList <Exercice> list_exercice;
	private String msgListeSeanceVide = "Aucun séance n'a été créée !!!";
	private String msgListeConsommationVide = "Aucun aliment consommé aujourd'hui";
	private Double calorie;

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
		user= (Utilisateur) session.getAttribute("utilisateur");
		calorie = user.getMetabolisme();
		user.Besoin(calorie);
		
		
		/* Date du jour  */
		LocalDate date = LocalDate.now();
	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
	    String jour = date.format(formatters);
		request.setAttribute(JOURNEE, jour);
		
		/* Récupérer la liste des séances */
		listSeance = new ArrayList<Seance>();
		list_exercice = new ArrayList<Exercice>();
		
		/*
		list_exercice.add(new Exercice("Curl Biceps","","Bras",1,(double)1));
		list_exercice.add(new Exercice("Press","","Jambes",1,(double)1));
		list_exercice.add(new Exercice("Tortank","","Dos",1,(double)1));
		list_exercice.add(new Exercice("Barre inclinées","","Epaules",1,(double)1));
		listSeance.add(new Seance(list_exercice,"Séance du lundi"));
		listSeance.add(new Seance(list_exercice,"Séance du mardi"));
		*/
		
		/////////////////// Vers la vue ///////////////////////
		request.setAttribute("calorie", calorie);
		request.setAttribute("proteine", user.getBesoin_proteine());
		request.setAttribute("lipide", user.getBesoin_lipide());
		request.setAttribute("glucide", user.getBesoin_glucide());
		
		/* Récupérer la liste des aliments */
		list_c = new List_Consommation();
		
		/* Liste séance(s) */
		if(listSeance.isEmpty()) {
			request.setAttribute("ListeSeanceVide",msgListeSeanceVide);
		}else {
			request.setAttribute("ListeSeance",listSeance);
		}
		
		/* Liste aliment(s) consommé */
		if(list_c.equals(null)) {
			//La liste des consommation	
		}else {
			request.setAttribute("ListeConsommation",msgListeConsommationVide);
		}
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
