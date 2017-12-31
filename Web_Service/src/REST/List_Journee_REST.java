package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Singleton.Connexion;
import model.Exercice;
import model.Journee;
import model.List_Consommation;
import model.List_Exercice;
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
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= get_all_journee; END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);

		while (rs.next()) {
		    ljournee.add(new Journee(rs.getInt(1),rs.getDate(2),new LinkedList<Seance>(),new List_Consommation()));
		}
		
		List_Journee list= new List_Journee(ljournee);
		return Response.status(Status.OK).entity(list).build();
	}
}
