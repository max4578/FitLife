package aliment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aliment;
import model.Aliment_Utilisateur;
import model.Utilisateur;

/**
 * Servlet implementation class ServletAjoutAliment
 */
@WebServlet("/ServletAjoutAliment")
public class ServletAjoutAliment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/AjoutAliment.jsp";
	public static final String VUE2 = "/Journee.jsp";
	public static final String CHAMP_NOM = "nomAliment";
	public static final String CHAMP_CALORIE = "calorie";
	public static final String CHAMP_LIPIDE = "lipide";
	public static final String CHAMP_ACIDEG = "acide_gras";
	public static final String CHAMP_GLUCIDE = "glucide";
	public static final String CHAMP_SUCRE = "sucre";
	public static final String CHAMP_PROTEINE = "proteine";
	public static final String CHAMP_QUANTITE = "quantite";
	HttpSession session;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutAliment() {
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
		String nomAliment = request.getParameter( CHAMP_NOM );
		String calorie = request.getParameter( CHAMP_CALORIE );
		String lipide = request.getParameter(CHAMP_LIPIDE);
		String acideG = request.getParameter(CHAMP_ACIDEG);
		String glucide = request.getParameter(CHAMP_GLUCIDE);
		String sucre = request.getParameter(CHAMP_SUCRE);
		String proteine = request.getParameter(CHAMP_PROTEINE);
		String quantite = request.getParameter(CHAMP_QUANTITE);
		
		Aliment_Utilisateur aliment = new Aliment_Utilisateur(nomAliment,Double.parseDouble(calorie), Double.parseDouble(lipide), Double.parseDouble(acideG), Double.parseDouble(glucide), Double.parseDouble(sucre), Double.parseDouble(proteine), Double.parseDouble(quantite));
		Utilisateur u=(Utilisateur) session.getAttribute("utilisateur");
		System.out.println(u.getId());
		u.AppelAjoutAliment(aliment);
		this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);
	}

}
