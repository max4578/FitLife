
package utilisateur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Singleton.Connexion;

/**
 * Servlet implementation class ServletDeconnexion
 */
@WebServlet("/ServletDeconnexion")
public class ServletDeconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/Accueil";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//////////////// Récupération et destruction de la session en cours ////////////////
		HttpSession session = request.getSession();
		
		try {
			session.invalidate();
			Connection con = Connexion.getInstance();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
