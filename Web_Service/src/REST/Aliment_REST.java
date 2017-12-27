package REST;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.Aliment;

@Path("aliment")
public class Aliment_REST {
	
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getText() {
		Aliment cli = new Aliment(1, "Toto", "Machin");
		
		String retour="";
		retour+=cli.getId();
		retour+=" ";
		retour+=cli.getNom();
		retour+=" ";
		retour+=cli.getPrenom();
		retour+=" ";
		
		return Response.status(Status.OK).entity(retour).build();
	}
	*/
	/*@GET
	@Produces(MediaType.TEXT_XML)
	public Response getXml() {
		Aliment cli = new Aliment(1, "Toto", "Machin");
		
		String retour="<?xml version=\"1.0\"?>";
		retour+="<Aliment>";
		retour+="<id>"+cli.getId()+"</id>";
		retour+="<nom>"+cli.getNom()+"</nom>";
		retour+="<prenom>"+cli.getPrenom()+"</prenom>";
		retour+="</Aliment>";
		
		return Response.status(Status.OK).entity(retour).build();
	}*/
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Response getXml() {
		//Aliment cli = new Aliment(1, "TOTO", "MACHIN");	
		LinkedList<Aliment> l = new LinkedList<Aliment>();
		return Response.status(Status.OK).entity(l).build();
	}
	
}
