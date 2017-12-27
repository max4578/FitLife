package servlet.main;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;



import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import Singleton.Connexion;
import model.Aliment;



public class ServletConnDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String urlErreur;
	static Connection con;
	public void init() {
		urlErreur=getInitParameter("urlErreur");
		
	}

	
	
	private static URI getBaseURI() {
		   return UriBuilder.fromUri("http://localhost:9090/Web_Service/rest/aliment").build();
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse 
	response)throws ServletException,  IOException{	    
		   ClientConfig config = new DefaultClientConfig();
		   Client client = Client.create(config);
		   WebResource service = client.resource(getBaseURI());

	   String xmlAnswer = service
			   		.path("aliment")
					.accept(MediaType.TEXT_XML)
					.get(String.class);

	   System.out.println(xmlAnswer);
	   
	  
		try {
			   JAXBContext jaxbContext = JAXBContext.newInstance(Aliment.class);
			   Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			   StringReader reader = new StringReader(xmlAnswer);
			   Aliment alim = (Aliment) unmarshaller.unmarshal(reader);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


				try {
					if(!con.isClosed())
						getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request,response);
				} catch (SQLException e) {
					getServletContext().getRequestDispatcher(urlErreur).forward(request,response);
				}  catch (NullPointerException e){
					getServletContext().getRequestDispatcher(urlErreur).forward(request,response);
				}
        }
        
	    
	    public void doPost(HttpServletRequest request, HttpServletResponse 
	    		response)throws ServletException, IOException
	    {
	        doGet(request, response);
	    }
}
