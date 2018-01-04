package servlet.main;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

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
import model.Aliment_Admin;
import model.Aliment_Utilisateur;



public class ServletConnDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String urlErreur;
	static Connection con;
	public void init() {
		urlErreur=getInitParameter("urlErreur");
		con=Connexion.getInstance();
	}

	
	
	private static URI getBaseURI() {
		   return UriBuilder.fromUri("http://localhost:9090/Web_Service/rest/").build();
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse 
	response)throws ServletException,  IOException{	  
		
		   /*Conversiondu XML en classe mappée*/
			try {				  
				ClientConfig config = new DefaultClientConfig();
		 		   Client client = Client.create(config);
		 		   WebResource service = client.resource(getBaseURI());
				   String xmlAnswer = service
						   		.path("aliment/1")
								.accept(MediaType.TEXT_XML)
								.get(String.class);
		
			   System.out.println(xmlAnswer);
				   if(!con.isClosed())
					   con.close();
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
