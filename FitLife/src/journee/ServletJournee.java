package journee;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Journee;

/**
 * Servlet implementation class ServletJournee
 */
@WebServlet("/ServletJournee")
public class ServletJournee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JOURNEE = "journee";

       
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
		
		
		/* Date du jour  */
		LocalDate date = LocalDate.now();
	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
	    String jour = date.format(formatters);
		request.setAttribute(JOURNEE, jour);
		
		/* Liste séance(s) */
		
		/* Liste aliment(s) consommé */
		
		this.getServletContext().getRequestDispatcher("/Journee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
