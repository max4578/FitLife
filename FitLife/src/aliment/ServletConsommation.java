package aliment;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aliment;
import model.Consommation;
import model.Journee;
import model.List_Aliment;
import model.Utilisateur;

/**
 * Servlet implementation class ServletConsommation
 */
@WebServlet("/ServletConsommation")
public class ServletConsommation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/Consommation.jsp";
	private static final String VUE2 = "/Journee";
	private Aliment aliment = new Aliment();
	private Consommation consommation = new Consommation();
	private List<Aliment> listeAliment = new LinkedList<>();
	private List_Aliment list_aliment= new List_Aliment();
	private HttpSession session;
	private Utilisateur user;
	private Journee journee;
	private String idAliment;
	String error="";
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("erreurConsom", request.getParameter("errorConsom"));
		aliment = null;
		/////	Récupération de la session	/////
		session=request.getSession();
		user = (Utilisateur) session.getAttribute("utilisateur");
		journee = (Journee) session.getAttribute("journee");
		
		/////	Création de la liste d'aliment de l'utilisateur	/////
		idAliment = request.getParameter("id");
		System.out.println("id de l aliment a ajouter a la journee" + idAliment);
		listeAliment = list_aliment.getList(user.getId());
		/////	Récupération de l'aliment gràce à l'id	/////
		for(Aliment a : listeAliment){
			if(a.getId() == Integer.parseInt(idAliment)) {
				aliment = a;
				consommation.setAliment(aliment);
				request.setAttribute("consommation", consommation);
			}
		}
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double quantite;
		String periode;
		
		quantite = Double.parseDouble(request.getParameter("quantite"));
		periode = request.getParameter("periode");
	
		consommation.setPeriode(periode);
		consommation.setQuantite(quantite);
		if(consommation.AjouterConsom(journee.getId())){
			journee.AjoutConsommation(consommation);
	        session.setAttribute("journee", journee);
	       
			this.getServletContext().getRequestDispatcher( VUE2 ).forward( request, response );
			
		}else {
			error="Erreur: Aliment deja present dans la journee a la meme periode";
			request.setAttribute("errorConsom", error);
			response.sendRedirect( "/FitLife/Consommation?id="+consommation.getAliment().getId()+"&errorConsom="+ error );
	
		}
	}

}
