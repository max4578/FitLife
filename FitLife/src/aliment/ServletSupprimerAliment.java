package aliment;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aliment;


/**
 * Servlet implementation class SupprimerAliment
 */
@SuppressWarnings("unchecked")
public class ServletSupprimerAliment extends HttpServlet {
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

  
    public ServletSupprimerAliment() {
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
		alim.SupprimerAliment();
		response.sendRedirect( "/FitLife/MesAliments" );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
