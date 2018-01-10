package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Singleton.Connexion;
import model.Consommation;
import model.Journee;
import model.List_Journee;
import model.Seance;
import oracle.jdbc.OracleTypes;

@Path("list_journee")
public class List_Journee_REST {
	Connection con = Connexion.getInstance();

	@GET
	@Produces(MediaType.TEXT_XML)
	public Response getXml() throws SQLException {
		
		LinkedList<Journee> ljournee= new LinkedList<Journee>();
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= gestion_journee.get_all_journee; END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);

		while (rs.next()) {
			java.util.Date newDate = rs.getTimestamp(2);
		    ljournee.add(new Journee(rs.getInt(1),newDate,new LinkedList<Seance>(),new LinkedList<Consommation>()));
		}
		
		for(Journee j:ljournee) {
			j.setListSeance(List_Seance_REST.getList(j.getId()));
			j.setListConsom(List_Consommation_REST.getList(j.getId()));
		}
		myStmt.close();
		rs.close();
		List_Journee list= new List_Journee(ljournee);
		return Response.status(Status.OK).entity(list).build();
	}
	
	
	@POST
	@Produces(MediaType.TEXT_XML)
	@Path("journees_utilisateur")
	public Response getJourneeUser(@QueryParam("idUser") int id) throws SQLException {
		
		LinkedList<Journee> ljournee= new LinkedList<Journee>();
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= gestion_journee.get_journee_user(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setInt(2,id);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);

		while (rs.next()) {	
			java.util.Date newDate = rs.getTimestamp(2);
		    ljournee.add(new Journee(rs.getInt(1),newDate,new LinkedList<Seance>(),new LinkedList<Consommation>()));
		}
		
		for(Journee j:ljournee) {
			j.setListSeance(List_Seance_REST.getList(j.getId()));
			j.setListConsom(List_Consommation_REST.getList(j.getId()));
		}
		myStmt.close();
		rs.close();
		List_Journee list= new List_Journee(ljournee);
		return Response.status(Status.OK).entity(list).build();
	}
}
