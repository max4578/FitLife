package aliment;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aliment;
import model.Utilisateur;


public class ServletModifierAliment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	public static final String CHAMP_NOM = "nomAliment";
	public static final String CHAMP_CALORIE = "calorie";
	public static final String CHAMP_LIPIDE = "lipide";
	public static final String CHAMP_ACIDEG = "acide_gras";
	public static final String CHAMP_GLUCIDE = "glucide";
	public static final String CHAMP_SUCRE = "sucre";
	public static final String CHAMP_PROTEINE = "proteine";
	public static final String CHAMP_QUANTITE = "quantite";
	Aliment alimentModifie;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierAliment() {
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
		
		LinkedList<Aliment> liste_alim= new LinkedList<Aliment>();
		liste_alim=(LinkedList<Aliment>) session.getAttribute("listeAlim");

		int id= Integer.parseInt(request.getParameter("id"));
		
		Aliment alim=null;
		for(Aliment a : liste_alim)
			if(a.getId()==id)
				alim=a;
		request.setAttribute("alim", alim);
		alimentModifie=alim;
		this.getServletContext().getRequestDispatcher( "/ModifierAliment.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id = request.getParameter( "id" );
		String nomAliment = request.getParameter( CHAMP_NOM );
		String calorie = request.getParameter( CHAMP_CALORIE );
		String lipide = request.getParameter(CHAMP_LIPIDE);
		String acideG = request.getParameter(CHAMP_ACIDEG);
		String glucide = request.getParameter(CHAMP_GLUCIDE);
		String sucre = request.getParameter(CHAMP_SUCRE);
		String proteine = request.getParameter(CHAMP_PROTEINE);
		String quantite = request.getParameter(CHAMP_QUANTITE);
		
		Aliment aliment = new Aliment(Integer.parseInt(id),nomAliment,Double.parseDouble(calorie), Double.parseDouble(lipide), Double.parseDouble(acideG), Double.parseDouble(glucide), Double.parseDouble(sucre), Double.parseDouble(proteine), Double.parseDouble(quantite));
		aliment.ModifierAliment();
		this.getServletContext().getRequestDispatcher( "/MesAliments" ).forward( request, response );
	}

}
