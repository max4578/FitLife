package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import Singleton.Connexion;
import model.Consommation;
import model.Journee;
import model.Seance;
import oracle.jdbc.OracleTypes;

@Path("journee")
public class Journee_REST {
	Connection con = Connexion.getInstance();

	/*Récupère une journee avec son ID passé dans l' URL*/
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("{id}")
	public Response getXml(@PathParam("id") int id) throws SQLException {	
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= gestion_journee.get_journee(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setInt(2, id);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);
		Journee journee=null;
		while (rs.next()) {
			java.util.Date newDate = rs.getTimestamp(2);
		    journee=new Journee(rs.getInt(1),newDate,new LinkedList<Seance>(),new LinkedList<Consommation>());
		}
		myStmt.close();
		rs.close();
		return Response.status(Status.OK).entity(journee).build();
	}
	
	
	/*Recupère la journee actuelle de l' utilisateur*/
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("get_journee")
	public Response Find_Journee(@QueryParam("idUser") int idU) throws SQLException, ParseException {	

		CallableStatement myStmt =con.prepareCall("BEGIN ?:= gestion_journee.get_journee(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setInt(2,idU);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);
		Journee journee=null;
		while (rs.next()) {
			java.util.Date newDate = rs.getTimestamp(2);
			journee=new Journee(rs.getInt(1),newDate,new LinkedList<Seance>(),new LinkedList<Consommation>());
			System.out.println(rs.getInt(1));
		}
		System.out.println(journee.getId());
		/*Récupère les listes de séances et d' exercices de la journée*/
		journee.setListSeance(List_Seance_REST.getList(journee.getId()));
		journee.setListConsom(List_Consommation_REST.getList(journee.getId()));
		myStmt.close();
		rs.close();
		return Response.status(Status.OK).entity(journee).build();		
				

	}
	
	/*Création de la journée de l' utilisateur si elle n' existe pas déjà*/
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("ajout")
	public Response Create_Journee(@QueryParam("idUser") int idU) throws SQLException, ParseException {	
	
		CallableStatement myStmt2 =con.prepareCall("BEGIN gestion_journee.create_journee(?); END;");
		myStmt2.setInt(1,idU);
		myStmt2.execute();
		myStmt2.close();
		return Response.status(Status.OK).build();		

		
	}
	
	/*Ajout d' une séance a la journée actuelle*/
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("ajouter_seance")
	public Response AddSeance(@QueryParam("idJournee") int idJ,@QueryParam("idSeance") int idS,@QueryParam("periode") String periode) throws SQLException, ParseException {	

		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:=gestion_journee.add_Seance_journee(?,?,?); END;");
		myStmt.registerOutParameter(1, java.sql.Types.INTEGER);
		myStmt.setInt(2,idJ);
		myStmt.setInt(3,idS);
		myStmt.setString(4, periode);
		myStmt.execute();
		if(myStmt.getInt(1)==1) {
			myStmt.close();
			return Response.status(Status.OK).entity("OK").build();		
		
		}
		else {
			myStmt.close();
			return Response.status(Status.OK).entity("FOUND").build();		
		}		

	}
	
	
}
